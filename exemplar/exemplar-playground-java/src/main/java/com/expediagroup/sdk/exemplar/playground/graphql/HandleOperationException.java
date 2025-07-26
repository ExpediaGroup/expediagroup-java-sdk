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
package com.expediagroup.sdk.exemplar.playground.graphql;

import com.expediagroup.sdk.core.exception.service.ExpediaGroupServiceException;
import com.expediagroup.sdk.exemplar.graphql.client.ExemplarGraphQLClient;
import com.expediagroup.sdk.exemplar.graphql.generated.DemoHttpExceptionQuery;
import com.expediagroup.sdk.exemplar.graphql.generated.DemoNoDataErrorQuery;
import com.expediagroup.sdk.exemplar.graphql.generated.DemoPartialResponseQuery;
import com.expediagroup.sdk.graphql.exception.NoDataException;
import com.expediagroup.sdk.graphql.model.RawResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * GraphQL Exception Handling and Error Response Processing Demonstration
 *
 * This class provides a demonstration of GraphQL error handling patterns
 * in the Expedia Group SDK. It showcases all scenarios handled by the
 * GraphQLExecutor method, demonstrating how different types of
 * GraphQL responses are processed and converted into appropriate SDK exceptions or responses.
 *
 * GraphQL Response Processing Overview:
 * Unlike REST APIs that use HTTP status codes to indicate errors, GraphQL always returns
 * HTTP 200 (success) and embeds error information within the response payload. The SDK's
 * GraphQLExecutor applies specific conventions to make error handling predictable and
 * consistent with the broader SDK design.
 *
 * Three Main Error Scenarios Demonstrated:
 *
 * 1. Network Exceptions (response.exception != null):
 *    - Occurs when underlying HTTP transport fails or server throws runtime exceptions
 *    - Results in ExpediaGroupServiceException being thrown
 *    - No GraphQL payload is received from the server
 *    - Examples: Network issues, server crashes, resolver exceptions
 *
 * 2. GraphQL Error Response with No Data:
 *    - Server processes the GraphQL request but returns errors for all requested fields
 *    - Results in NoDataException being thrown with structured error details
 *    - Contains GraphQLError objects with specific error messages and paths
 *    - Examples: Field-level validation failures, authorization errors
 *
 * 3. Successful or Partial Response (else case):
 *    - Server returns data (may include some errors for specific fields)
 *    - Results in RawResponse containing both data and any associated errors
 *    - Allows handling of partial successes where some fields resolve and others fail
 *    - Examples: Successful queries with warnings, partial data retrieval
 */
@SuppressWarnings("LoggingSimilarMessage")
public class HandleOperationException {

    /** Logger for tracking exception scenarios and error details */
    private static final Logger logger = LoggerFactory.getLogger(HandleOperationException.class);

    /** Standard GraphQL client for normal operations */
    private static final ExemplarGraphQLClient exemplarClient = new ExemplarGraphQLClient();

    /*
     * Main entry point for demonstrating GraphQL exception handling.
     */
    public static void main(String[] args) {
        logger.info("=== Starting GraphQL Exception Handling Demonstration ===");

        // Scenario 1: Demonstrate network exceptions
        demonstrateHttpException();

        // Scenario 2: Demonstrate GraphQL error response (no data)
        demonstrateNoDataException();

        // Scenario 3: Demonstrate partial response (success with errors)
        demonstratePartialResponse();

        logger.info("=== GraphQL Exception Handling Demonstration Completed ===");

        exemplarClient.dispose();
    }

    /*
     * Demonstrates Scenario 1: Transport/Network Exception Handling
     *
     * SDK Behavior:
     * - Throws ExpediaGroupServiceException with requestId and underlying cause
     * - No GraphQL payload processing occurs
     * - Exception contains the original server-side error for debugging
     */
    private static void demonstrateHttpException() {
        logger.info("\n--- Scenario 1: Http Exception ---");

        try {
            // Use the custom resolver that throws a RuntimeException
            DemoHttpExceptionQuery query = new DemoHttpExceptionQuery();

            logger.info("Executing query that will trigger server-side exception...");
            exemplarClient.execute(query);

            logger.warn("Expected transport exception did not occur - check server implementation");

        } catch (ExpediaGroupServiceException e) {
            logger.info("✓ Caught expected ExpediaGroupServiceException");
            logger.info("✓ Request ID: {}", e.getRequestId());
            logger.info("✓ Message: {}", e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected exception type: {}", e.getClass().getSimpleName(), e);
        }
    }

    /*
     * Demonstrates Scenario 2: GraphQL Error Response (No Data)
     *
     * SDK Behavior:
     * - Throws NoDataException with structured error information
     * - Exception includes List of GraphQLError objects with specific messages and paths
     */
    private static void demonstrateNoDataException() {
        logger.info("\n--- Scenario 2: GraphQL Error Response (No Data) ---");

        try {
            // Use the custom resolver that returns null data with errors
            DemoNoDataErrorQuery query = new DemoNoDataErrorQuery();

            logger.info("Executing query that will return no data with errors...");
            exemplarClient.execute(query);

            logger.warn("Expected NoDataException did not occur - check server error handling");

        } catch (NoDataException e) {
            logger.info("✓ Caught expected NoDataException");
            logger.info("✓ Request ID: {}", e.getRequestId());
            logger.info("✓ Message: {}", e.getMessage());
            logger.info("✓ Errors: {}", e.getErrors());
        } catch (Exception e) {
            logger.error("Unexpected exception type: {}", e.getClass().getSimpleName(), e);
        }
    }

    /*
     * Demonstrates Scenario 3: Partial Response (Success with Errors)
     *
     * SDK Behavior:
     * - Returns RawResponse containing both data and error list
     * - Allows access to successfully processed data
     * - Provides error details for fields that had issues
     */
    private static void demonstratePartialResponse() {
        logger.info("\n--- Scenario 3: Partial Response (Success with Errors) ---");

        try {
            // Use the custom resolver that returns data with accompanying errors
            DemoPartialResponseQuery query = new DemoPartialResponseQuery();

            logger.info("Executing query that will return data with warnings...");
            RawResponse<DemoPartialResponseQuery.Data> response = exemplarClient.execute(query);

            logger.info("✓ Received RawResponse (partial success)");
            logger.info("✓ Data: {}", response.getData());
            logger.info("✓ Errors: {}", response.getErrors());

        } catch (Exception e) {
            logger.error("Unexpected exception during partial response test: {}", e.getClass().getSimpleName(), e);
        }
    }
}
