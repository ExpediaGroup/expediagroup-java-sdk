/*
 * Copyright (C) 2025 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.expediagroup.sdk.exemplar.playground.rest;

import com.expediagroup.sdk.exemplar.rest.client.ExemplarClient;
import com.expediagroup.sdk.exemplar.rest.model.BookingRequest;
import com.expediagroup.sdk.exemplar.rest.model.GuestInfo;
import com.expediagroup.sdk.exemplar.rest.model.Hotel;
import com.expediagroup.sdk.exemplar.rest.model.ProblemDetail;
import com.expediagroup.sdk.exemplar.rest.model.exception.CreateBooking400Exception;
import com.expediagroup.sdk.exemplar.rest.operation.CreateBookingOperation;
import com.expediagroup.sdk.exemplar.rest.operation.SearchHotelOperation;
import com.expediagroup.sdk.exemplar.rest.operation.SearchHotelOperationParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

/**
 * Exception Handling and Error Response Deserialization Example
 * <p>
 * This class demonstrates how to properly handle exceptions and extract detailed
 * error information when using the Expedia Group SDK. It showcases the SDK's
 * exception handling mechanism that maps HTTP error status codes
 * to strongly-typed exception classes with structured error response data.
 * <p>
 * SDK Exception Generation:
 * For each operation class, the SDK automatically generates specific exception
 * classes that correspond to each error status code defined in the OpenAPI
 * specification file. These exceptions follow a naming pattern:
 * {OperationName}{StatusCode}Exception (e.g., CreateBooking400Exception).
 * <p>
 * Error Response Deserialization:
 * The SDK automatically deserializes the actual error response from the server
 * by calling .getErrorResponse() on the caught exception. This returns the
 * defined error model from the original OpenAPI spec file. In this example,
 * the error model is ProblemDetail as defined in the exemplar-server.
 * <p>
 * Key Benefits:
 * - Type-safe error handling with specific exception classes per status code
 * - Automatic deserialization of structured error responses
 * - Access to detailed error information beyond just HTTP status codes
 * - Consistent error handling patterns across all SDK operations
 * <p>
 * Common Exception Types by HTTP Status:
 * - 400 Bad Request: Client-side validation errors, malformed requests
 * - 401 Unauthorized: Authentication failures
 * - 403 Forbidden: Authorization/permission errors
 * - 404 Not Found: Resource not found errors
 * - 500 Internal Server Error: Server-side processing errors
 *
 * @see CreateBooking400Exception
 * @see ProblemDetail
 * @see ExemplarClient
 */
public class HandleOperationException {
    /** Logger for tracking exception handling and error details */
    private static final Logger logger = LoggerFactory.getLogger(HandleOperationException.class);

    /** SDK client instance for executing operations and handling exceptions */
    private static final ExemplarClient exemplarClient = new ExemplarClient();

    /**
     * Main entry point for demonstrating SDK exception handling and error response processing.
     * <p>
     * This example deliberately triggers a validation error to showcase how the SDK:
     * 1. Maps HTTP error status codes to specific exception types
     * 2. Deserializes server error responses into structured error models
     * 3. Provides access to detailed error information for proper error handling
     * <p>
     * The demonstration workflow:
     * 1. Search for a hotel to use in booking creation
     * 2. Create an intentionally invalid booking request (past checkout date)
     * 3. Catch the specific 400 Bad Request exception
     * 4. Extract and display the structured error response details
     * <p>
     * Exception Handling Pattern:
     * The SDK generates exception classes for each operation and status code combination.
     * This allows for precise error handling based on both the operation context and
     * the specific type of error that occurred.
     */
    public static void main(String[] args) {

        // Step 1: Search for a hotel to use in the booking attempt
        // This operation should succeed and provide a valid hotel for booking
        SearchHotelOperationParams searchHotelOperationParams = SearchHotelOperationParams.builder()
            .city("New York")
            .build();

        SearchHotelOperation searchHotelOperation = new SearchHotelOperation(searchHotelOperationParams);

        Hotel hotel = exemplarClient.execute(searchHotelOperation).getData().get(0);

        // Step 2: Create an intentionally invalid booking request to trigger an exception
        // The checkout date is set to the past, which should cause a validation error
        BookingRequest bookingRequest = BookingRequest.builder()
            .hotelId(hotel.getId())
            .checkInDate(LocalDate.now())
            .checkOutDate(LocalDate.now().minusDays(1)) // Intentionally invalid: past date
            .guests(3)
            .guestInfo(
                GuestInfo.builder()
                    .firstName("John")
                    .lastName("Doe")
                    .email("example@email.com")
                    .build()
            )
            .build();

        CreateBookingOperation operation = new CreateBookingOperation(bookingRequest);

        // Step 3: Execute the operation and handle the expected exception
        try {
            exemplarClient.execute(operation);
            logger.warn("Expected validation error did not occur - check booking request data");
        } catch (CreateBooking400Exception e) {
            // Step 4: Handle the specific 400 Bad Request exception
            logger.info("Caught expected validation error: {}", e.getMessage());

            // Step 5: Extract structured error response from the exception
            // The SDK automatically deserializes the server's error response
            // into the ProblemDetail model as defined in the OpenAPI specification
            ProblemDetail problemDetail = e.getErrorResponse();

            // Step 6: Log detailed error information for debugging and user feedback
            logger.info("Structured error details: {}", problemDetail);
            logger.info("Exception handling demonstration completed successfully.");
        } catch (Exception e) {
            // Handle any unexpected exceptions that might occur
            logger.error("Unexpected error during exception handling demonstration: {}", e.getMessage(), e);
        } finally {
            exemplarClient.dispose();
        }
    }
}
