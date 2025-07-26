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
package com.expediagroup.sdk.exemplar.playground.graphql;

import com.expediagroup.sdk.exemplar.graphql.client.ExemplarAsyncGraphQLClient;
import com.expediagroup.sdk.exemplar.graphql.generated.*;
import com.expediagroup.sdk.exemplar.graphql.generated.type.BookingInput;
import com.expediagroup.sdk.exemplar.graphql.generated.type.BookingUpdateInput;
import com.expediagroup.sdk.exemplar.graphql.generated.type.GuestInfoInput;
import com.expediagroup.sdk.graphql.model.RawResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Async Full Exemplar GraphQL SDK Scenario -  Hotel Booking Workflow with Asynchronous GraphQL Operations
 * <p>
 * This class demonstrates a simple example of how to use the Expedia Group SDK's asynchronous
 * GraphQL capabilities to interact with the exemplar GraphQL API for hotel booking operations. It showcases
 * the complete workflow from hotel search to booking management using CompletableFuture-based async operations
 * with Apollo Kotlin generated clients.
 * <p>
 * Workflow Overview:
 * 1. Hotel Search: Asynchronously search for all hotels using GraphQL queries
 * 2. Filtered Search: Search hotels by location and price with GraphQL variables
 * 3. Booking Creation: Create bookings using GraphQL mutations asynchronously
 * 4. Booking Retrieval: Fetch all existing bookings via GraphQL queries
 * 5. Booking Updates: Modify existing bookings through GraphQL mutations
 *
 * @see ExemplarAsyncGraphQLClient
 * @see CompletableFuture
 */
public class AsyncFullExemplarScenario {
    /**
     * Logger for tracking scenario execution and debugging
     */
    private static final Logger logger = LoggerFactory.getLogger(AsyncFullExemplarScenario.class);

    /**
     * Async Exemplar GraphQL SDK client instance for making non-blocking GraphQL API calls.
     */
    private static final ExemplarAsyncGraphQLClient exemplarGraphQLClient = new ExemplarAsyncGraphQLClient();

    /**
     * Main entry point for the async full GraphQL exemplar scenario demonstration.
     */
    public static void main(String[] args) {
        logger.info("=== Starting Async Full Exemplar GraphQL SDK Scenario ===");

        try {
            executeAsyncGraphQLWorkflow()
                .thenRun(() -> logger.info("=== Async Full Exemplar GraphQL SDK Scenario Completed Successfully ==="))
                .exceptionally(throwable -> {
                    logger.error("GraphQL scenario failed with exception: {}", throwable.getMessage(), throwable);
                    return null;
                }).join();

        } catch (Exception e) {
            logger.error("Unexpected error in main execution: {}", e.getMessage(), e);
        } finally {
            exemplarGraphQLClient.dispose();
        }
    }

    /**
     * Executes the complete async GraphQL workflow by chaining all operations together.
     * <p>
     * This method demonstrates how to compose multiple asynchronous GraphQL operations
     * into a single workflow using Apollo Kotlin generated operations,
     * handling dependencies between operations and managing the overall execution flow.
     *
     * @return A CompletableFuture that completes when the entire GraphQL workflow finishes
     */
    private static CompletableFuture<Void> executeAsyncGraphQLWorkflow() {
        return searchAllHotels()
            .thenCompose(ignore -> {
                // Step 2: Search for specific hotels concurrently using GraphQL variables
                CompletableFuture<SearchHotelsQuery.Hotel> nyHotelFuture = searchHotelByCityAndMaxPrice("New York", BigDecimal.valueOf(300.00));
                CompletableFuture<SearchHotelsQuery.Hotel> miamiHotelFuture = searchHotelByCityAndMaxPrice("Miami", BigDecimal.valueOf(400.00));

                return CompletableFuture.allOf(nyHotelFuture, miamiHotelFuture)
                    .thenCompose(hotels -> {
                        // Step 3: Create bookings for selected hotels concurrently using GraphQL mutations
                        CompletableFuture<CreateBookingMutation.CreateBooking> nyBookingFuture = makeBookingAsync(nyHotelFuture.join());
                        CompletableFuture<CreateBookingMutation.CreateBooking> miamiBookingFuture = makeBookingAsync(miamiHotelFuture.join());

                        return CompletableFuture.allOf(nyBookingFuture, miamiBookingFuture)
                            .thenCompose(bookings -> {
                                CreateBookingMutation.CreateBooking nyBooking = nyBookingFuture.join();
                                CreateBookingMutation.CreateBooking miamiBooking = miamiBookingFuture.join();

                                logger.info("Created bookings: NY={}, Miami={}", nyBooking.getConfirmationNumber(), miamiBooking.getConfirmationNumber());

                                // Step 4: Update the booking (extend NY stay for 5 days)
                                return getBooking(nyBooking.getConfirmationNumber()).thenCompose((it) -> {
                                    GuestInfoInput nyGuestInput = new GuestInfoInput.Builder()
                                        .firstName(nyBooking.getGuestInfo().getFirstName())
                                        .lastName(nyBooking.getGuestInfo().getLastName())
                                        .email(nyBooking.getGuestInfo().getEmail())
                                        .build();

                                    BookingUpdateInput updatedNyBooking = new BookingUpdateInput.Builder()
                                        .checkInDate(nyBooking.getCheckInDate())
                                        .checkOutDate(LocalDate.now().plusDays(5)) // Extend the stay
                                        .guestInfo(nyGuestInput)
                                        .guests(nyBooking.getGuests())
                                        .build();

                                    return updateBooking(nyBooking.getConfirmationNumber(), updatedNyBooking);
                                });
                            });
                    });
            });
    }

    private static CompletableFuture<RawResponse<GetBookingQuery.Data>> getBooking(String confirmationNumber) {
        GetBookingQuery getBookingQuery = new GetBookingQuery(confirmationNumber);
        return exemplarGraphQLClient.execute(getBookingQuery);
    }

    /**
     * Demonstrates asynchronous basic hotel search functionality using GraphQL queries.
     *
     * @return CompletableFuture that completes when the GraphQL search operation finishes
     */
    private static CompletableFuture<Void> searchAllHotels() {
        logger.info("1. Searching All Hotels");

        SearchHotelsQuery searchHotelsQuery = new SearchHotelsQuery();

        return exemplarGraphQLClient.execute(searchHotelsQuery)
            .thenAccept(response -> {
                List<SearchHotelsQuery.Hotel> hotels = response.getData().getHotels();
                logger.info("Hotels search completed successfully. Found {} hotels.", hotels.size());
            }).exceptionally(throwable -> {
                logger.error("Hotel search failed: {}", throwable.getMessage(), throwable);
                return null;
            });
    }

    /**
     * Demonstrates asynchronous filtered hotel search with GraphQL variables and response processing.
     *
     * @param city     the city to search for hotels in
     * @param maxPrice the maximum price per night filter
     * @return CompletableFuture containing the first hotel from the GraphQL search results
     */
    private static CompletableFuture<SearchHotelsQuery.Hotel> searchHotelByCityAndMaxPrice(String city, BigDecimal maxPrice) {
        logger.info("2. Searching Hotels in City: {} with max price ${}", city, maxPrice);

        SearchHotelsQuery searchHotelsQuery = new SearchHotelsQuery.Builder()
            .city(city)
            .maxPrice(maxPrice)
            .build();

        return exemplarGraphQLClient.execute(searchHotelsQuery)
            .thenApply(response -> {
                List<SearchHotelsQuery.Hotel> hotels = response.getData().getHotels();

                if (hotels.isEmpty()) {
                    throw new RuntimeException("No hotels found for city: " + city + " with max price: $" + maxPrice);
                }

                SearchHotelsQuery.Hotel firstHotel = hotels.get(0);
                logger.info("Search completed successfully for city: {} and max price ${}. Found hotel: {}", city, maxPrice, firstHotel.getName());
                return firstHotel;
            }).exceptionally(throwable -> {
                logger.error("Hotel search failed for city {}: {}", city, throwable.getMessage(), throwable);
                throw new RuntimeException("Hotel search failed", throwable);
            });
    }

    /**
     * Demonstrates the complete asynchronous booking creation workflow using GraphQL mutations.
     *
     * @param hotel the hotel from GraphQL search to create a booking for
     * @return CompletableFuture containing the created booking with GraphQL mutation response
     */
    private static CompletableFuture<CreateBookingMutation.CreateBooking> makeBookingAsync(SearchHotelsQuery.Hotel hotel) {
        logger.info("3. Making a Booking for hotel: {}", hotel.getName());

        GuestInfoInput guestInput = new GuestInfoInput.Builder()
            .firstName("Adam")
            .lastName("Doe")
            .email("example@email.com")
            .build();

        BookingInput bookingInput = new BookingInput.Builder()
            .hotelId(hotel.getId())
            .checkInDate(LocalDate.now())
            .checkOutDate(LocalDate.now().plusDays(3))
            .guestInfo(guestInput)
            .guests(3)
            .build();

        CreateBookingMutation createBookingMutation = new CreateBookingMutation(bookingInput);

        return exemplarGraphQLClient.execute(createBookingMutation)
            .thenApply(response -> {
                CreateBookingMutation.CreateBooking booking = response.getData().getCreateBooking();
                logger.info("Booking made successfully. Confirmation Number: {}", booking.getConfirmationNumber());
                return booking;
            })
            .exceptionally(throwable -> {
                logger.error("Booking creation failed for hotel {}: {}", hotel.getName(), throwable.getMessage(), throwable);
                throw new RuntimeException("Booking creation failed", throwable);
            });
    }

    /**
     * Helper method to update a single booking asynchronously using GraphQL mutations.
     *
     * @param confirmationNumber the confirmation number of the booking to update
     * @param bookingUpdateInput the updated booking information as GraphQL input
     * @return CompletableFuture that completes when the GraphQL update mutation finishes
     */
    private static CompletableFuture<Void> updateBooking(String confirmationNumber, BookingUpdateInput bookingUpdateInput) {
        logger.info("Updating booking: {}", confirmationNumber);

        UpdateBookingMutation updateBookingMutation = new UpdateBookingMutation.Builder()
            .confirmationNumber(confirmationNumber)
            .input(bookingUpdateInput)
            .build();

        return exemplarGraphQLClient.execute(updateBookingMutation)
            .thenAccept(response -> logger.info("Booking {} updated successfully}", confirmationNumber))
            .exceptionally(throwable -> {
                logger.error("Failed to update booking {}: {}", confirmationNumber, throwable.getMessage(), throwable);
                return null;
            });
    }
}
