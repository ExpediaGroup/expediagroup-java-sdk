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
package com.expediagroup.sdk.exemplar.playground;

import com.expediagroup.sdk.exemplar.rest.client.ExemplarClient;
import com.expediagroup.sdk.exemplar.rest.operation.SearchHotelOperation;
import com.expediagroup.sdk.exemplar.rest.operation.SearchHotelOperationParams;
import com.expediagroup.sdk.okhttp.OkHttpClientConfiguration;
import com.expediagroup.sdk.okhttp.OkHttpTransport;

/**
 * Custom OkHttp Transport Configuration Example
 * <p>
 * This class demonstrates how to configure and customize the OkHttp transport layer
 * used by the Expedia Group SDK for HTTP communication. It shows how to override
 * default timeout settings and configure the underlying HTTP client for specific
 * performance or reliability requirements.
 * <p>
 * Key Concepts Demonstrated:
 * - Custom OkHttp client configuration with timeout settings
 * - Transport layer customization for SDK clients
 * - Dependency injection of custom transport into SDK clients
 * <p>
 * Common Use Cases:
 * - Adjusting timeout values for slow networks or long-running operations
 * - Configuring connection pooling and retry behavior
 * - Adding custom interceptors
 * - Setting up proxy configurations
 * <p>
 * Transport Architecture:
 * The SDK uses a pluggable transport architecture where the HTTP client can be
 * customized without changing the high-level API interactions. This allows for
 * fine-tuned control over network behavior while maintaining clean separation
 * of concerns between business logic and transport configuration.
 *
 * @see OkHttpTransport
 * @see OkHttpClientConfiguration
 * @see ExemplarClient
 */
public class ConfigureOkHttpTransport {

    /**
     * Main entry point for demonstrating custom OkHttp transport configuration.
     */
    public static void main(String[] args) {
        // Step 1: Create custom OkHttp configuration with extended timeouts
        // These values are in milliseconds and override the SDK defaults
        OkHttpClientConfiguration configuration = OkHttpClientConfiguration.builder()
            .callTimeout(100000)      // 100 seconds total request timeout
            .connectTimeout(100000)   // 100 seconds to establish connection
            .readTimeout(100000)      // 100 seconds between data reads
            .writeTimeout(100000)
            .retryOnConnectionFailure(true)
            // .interceptors()
            // .connectionPool()
            .build();

        // Step 2: Initialize the OkHttp transport with custom configuration
        OkHttpTransport transport = new OkHttpTransport(configuration);

        // Step 3: Create SDK client with the custom transport
        ExemplarClient exemplarClient = new ExemplarClient(transport);

        // Step 4: Execute a sample operation to demonstrate the custom transport
        SearchHotelOperationParams params = SearchHotelOperationParams.builder().build();
        SearchHotelOperation operation = new SearchHotelOperation(params);

        // Execute the operation - network calls will use our custom timeout settings
        exemplarClient.execute(operation);

        System.out.println("Operation completed successfully with custom OkHttp configuration!");
    }
}
