/**
 * Copyright (C) 2025 Expedia, Inc.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.expediagroup.sdk.exemplar.playground.common;

import com.expediagroup.sdk.core.http.*;
import com.expediagroup.sdk.core.transport.AsyncTransport;
import com.expediagroup.sdk.exemplar.rest.client.AsyncExemplarClient;
import com.expediagroup.sdk.exemplar.rest.operation.SearchHotelOperation;
import com.expediagroup.sdk.exemplar.rest.operation.SearchHotelOperationParams;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

/*
 * Custom Transport Implementation Example
 *
 * This class demonstrates how to implement a custom async transport layer for the Expedia Group SDK.
 * The transport layer is responsible for executing HTTP requests and mapping responses back
 * to the SDK's expected format.
 *
 * Key Responsibilities:
 * 1. Map SDK Request objects to the chosen HTTP client's request format
 * 2. Execute HTTP requests using the chosen client
 * 3. Map HTTP responses back to SDK Response objects
 * 4. Handle connection lifecycle (initialization and cleanup)
 *
 * This implementation uses Java's built-in HttpClient (Java 11+) which returns CompletableFuture
 * for async calls. Fortunately, this matches the SDK's `AsyncTransport` design.
 */
public class CustomAsyncTransport {
    private static final Logger logger = LoggerFactory.getLogger(CustomAsyncTransport.class);

    public static void main(String[] args) {
        Java11HttpClientAsyncTransport customAsyncTransport = new Java11HttpClientAsyncTransport();
        AsyncExemplarClient exemplarClient = new AsyncExemplarClient(customAsyncTransport);

        logger.info("1. Search All Hotels - Starting async request");

        SearchHotelOperationParams params = SearchHotelOperationParams.builder().build();
        SearchHotelOperation operation = new SearchHotelOperation(params);

        exemplarClient.execute(operation)
            .thenAccept(response -> {
                logger.info("Async response received successfully!");
            })
            .exceptionally(throwable -> {
                logger.error("Async request failed: {}", throwable.getMessage(), throwable);
                return null;
            })
            .join();

        logger.info("Search completed successfully.");

        customAsyncTransport.dispose();
    }

    /** Custom Transport implementation using Java's built-in HttpClient */
    private static class Java11HttpClientAsyncTransport implements AsyncTransport {

        /** Java HttpClient instance configured for SDK usage */
        private final HttpClient httpClient;

        /** Initialize the custom transport with a configured HttpClient */
        public Java11HttpClientAsyncTransport() {
            this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(30))
                .followRedirects(HttpClient.Redirect.NORMAL)
                .version(HttpClient.Version.HTTP_2)
                .build();
        }

        /*
         * Execute an HTTP request using the Java HttpClient.
         *
         * This method performs the core transport functionality:
         * 1. Maps the SDK Request to an HttpClient HttpRequest
         * 2. Executes the HTTP request synchronously
         * 3. Maps the HttpClient response back to an SDK Response
         * 4. Handles any HTTP client exceptions
         *
         * NOTE: This implementation is for demo purposes only, some additional logic might be required
         * for production usage.
         */
        @NotNull
        @Override
        public CompletableFuture<Response> execute(@NotNull Request request) {
            try {
                HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                    .uri(URI.create(request.getUrl().toString()))
                    .timeout(Duration.ofSeconds(60));

                switch (request.getMethod().name()) {
                    case "GET":
                        requestBuilder.GET();
                        break;
                    case "POST":
                        requestBuilder.POST(createRequestBody(request));
                        break;
                    case "PUT":
                        requestBuilder.PUT(createRequestBody(request));
                        break;
                    case "DELETE":
                        requestBuilder.DELETE();
                        break;
                    case "PATCH":
                        requestBuilder.method("PATCH", createRequestBody(request));
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported HTTP method: " + request.getMethod());
                }

                request.getHeaders().entries().forEach(header -> requestBuilder.header(header.getKey(), header.getValue().toString()));

                HttpRequest httpRequest = requestBuilder.build();

                return httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString())
                    .thenApply(httpResponse -> mapToSdkResponse(httpResponse, request))
                    .exceptionally(throwable -> {
                        throw new RuntimeException("HTTP request execution failed: " + throwable.getMessage(), throwable);
                    });

            } catch (Exception e) {
                CompletableFuture<Response> failedFuture = new CompletableFuture<>();
                failedFuture.completeExceptionally(new RuntimeException("HTTP request execution failed: " + e.getMessage(), e));
                return failedFuture;
            }
        }

        /**
         * Create an HttpRequest.BodyPublisher from the SDK request body.
         *
         * @param request the SDK request containing the body
         * @return HttpRequest.BodyPublisher for the request body
         */
        private HttpRequest.BodyPublisher createRequestBody(Request request) {
            try (Buffer buffer = new Buffer()) {
                if (request.getBody() == null) {
                    return HttpRequest.BodyPublishers.noBody();
                }

                request.getBody().writeTo(buffer);
                return HttpRequest.BodyPublishers.ofString(buffer.readUtf8());
            } catch (Exception e) {
                throw new RuntimeException("HTTP request execution failed: " + e.getMessage(), e);
            }
        }

        /**
         * Map HttpClient response to SDK Response format.
         *
         * @param httpResponse the HttpClient response
         * @return SDK Response object
         */
        private Response mapToSdkResponse(HttpResponse<String> httpResponse, Request request) {
            int statusCode = httpResponse.statusCode();

            Headers.Builder headersBuilder = Headers.builder();
            httpResponse.headers().map().forEach(headersBuilder::add);

            String body = httpResponse.body();

            return Response.builder()
                .body(ResponseBody.create(new ByteArrayInputStream(body.getBytes()), CommonMediaTypes.APPLICATION_JSON))
                .headers(headersBuilder.build())
                .protocol(Protocol.HTTP_2)
                .request(request)
                .status(Status.fromCode(statusCode))
                .build();
        }

        /*
         * Clean up resources when the transport is no longer needed.
         *
         * The Java HttpClient manages its own connection pool and resources.
         * No explicit cleanup is required, but this method provides a hook
         * for any custom cleanup logic if needed.
         */
        @Override
        public void dispose() {
            // no-op
        }
    }
}
