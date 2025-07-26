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
package com.expediagroup.sdk.exemplar.playground.rest;

import com.expediagroup.sdk.exemplar.rest.client.AsyncExemplarClient;
import com.expediagroup.sdk.exemplar.rest.model.Booking;
import com.expediagroup.sdk.exemplar.rest.model.BookingRequest;
import com.expediagroup.sdk.exemplar.rest.model.GuestInfo;
import com.expediagroup.sdk.exemplar.rest.model.Hotel;
import com.expediagroup.sdk.exemplar.rest.operation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Async Full Exemplar SDK Scenario - Simple Hotel Booking Workflow with Asynchronous Operations
 * <p>
 * This class demonstrates simple example of how to use the Expedia Group SDK's asynchronous
 * capabilities to interact with the exemplar REST API for hotel booking operations. It showcases the
 * complete workflow from hotel search to booking management using CompletableFuture-based async operations.
 * <p>
 * Workflow Overview:
 * 1. Hotel Search: Asynchronously search for all hotels and filter by location and price
 * 2. Hotel Selection: Select specific hotels from search results
 * 3. Booking Creation: Create bookings for selected hotels asynchronously
 * 4. Booking Retrieval: Fetch all existing bookings asynchronously
 * 5. Booking Updates: Modify existing bookings (dates, status, etc.) asynchronously
 *
 * @see AsyncExemplarClient
 * @see CompletableFuture
 */
public class AsyncFullExemplarScenario {
    /**
     * Logger for tracking scenario execution and debugging
     */
    private static final Logger logger = LoggerFactory.getLogger(AsyncFullExemplarScenario.class);

    /**
     * Async Exemplar SDK client instance for making non-blocking API calls
     */
    private static final AsyncExemplarClient exemplarClient = new AsyncExemplarClient();

    /**
     * Main entry point for the async full exemplar scenario demonstration
     */
    public static void main(String[] args) {
        logger.info("=== Starting Async Full Exemplar SDK Scenario ===");

        try {
            executeAsyncWorkflow()
                .thenRun(() -> logger.info("=== Async Full Exemplar SDK Scenario Completed Successfully ==="))
                .exceptionally(throwable -> {
                    logger.error("Scenario failed with exception: {}", throwable.getMessage(), throwable);
                    return null;
                })
                .join();

        } catch (Exception e) {
            logger.error("Unexpected error in main execution: {}", e.getMessage(), e);
        } finally {
            exemplarClient.dispose();
        }
    }

    /**
     * Executes the complete async workflow by chaining all operations together.
     *
     * @return A CompletableFuture that completes when the entire workflow finishes
     */
    private static CompletableFuture<Void> executeAsyncWorkflow() {
        return searchAllHotelsAsync()
            .thenCompose(ignore -> {
                // Step 2: Search for specific hotels
                CompletableFuture<Hotel> nyHotelFuture = searchHotelByCityAndMaxPriceAsync("New York", BigDecimal.valueOf(300.00));
                CompletableFuture<Hotel> miamiHotelFuture = searchHotelByCityAndMaxPriceAsync("Miami", BigDecimal.valueOf(400.00));

                return CompletableFuture.allOf(nyHotelFuture, miamiHotelFuture)
                    .thenCompose(hotels -> {
                        // Step 3: Create bookings for selected hotels
                        CompletableFuture<Booking> nyBookingFuture = makeBookingAsync(nyHotelFuture.join());
                        CompletableFuture<Booking> miamiBookingFuture = makeBookingAsync(miamiHotelFuture.join());

                        // Update the booking
                        // 4.1: cancel Miami booking
                        miamiBookingFuture.thenAccept(booking -> {
                            Booking updatedMiamiBooking = booking.toBuilder()
                                .checkOutDate(LocalDate.now().plusDays(3))
                                .build();

                            updateBooking(updatedMiamiBooking.getConfirmationNumber(), updatedMiamiBooking);
                        });

                        // 4.2: Update the booking (extend NY stay)
                        return nyBookingFuture.thenCompose(nyBooking -> {
                            Booking updatedNyBooking = nyBooking.toBuilder()
                                .checkOutDate(LocalDate.now().plusDays(3))
                                .build();

                            return updateBooking(nyBooking.getConfirmationNumber(), updatedNyBooking);
                        });
                    });
            });
    }

    /**
     * Demonstrates asynchronous basic hotel search functionality without filters.
     *
     * @return CompletableFuture that completes when the search operation finishes
     */
    private static CompletableFuture<Void> searchAllHotelsAsync() {
        logger.info("1. Searching All Hotels");

        SearchHotelOperationParams params = SearchHotelOperationParams.builder().build();
        SearchHotelOperation operation = new SearchHotelOperation(params);

        return exemplarClient.execute(operation)
            .thenAccept(response -> logger.info("Search completed successfully. Found {} hotels.", response.getData().size()))
            .exceptionally(throwable -> {
                logger.error("Hotel search failed: {}", throwable.getMessage(), throwable);
                return null;
            });
    }

    /**
     * Demonstrates asynchronous filtered hotel search with specific criteria and response processing.
     *
     * @param city     the city to search for hotels in
     * @param maxPrice the maximum price per night filter
     * @return CompletableFuture containing the first hotel from the search results
     */
    private static CompletableFuture<Hotel> searchHotelByCityAndMaxPriceAsync(String city, BigDecimal maxPrice) {
        logger.info("2. Searching Hotels in City: {} with max price ${} (Async)", city, maxPrice);

        SearchHotelOperationParams params = SearchHotelOperationParams.builder()
            .city(city)
            .maxPrice(maxPrice)
            .build();

        SearchHotelOperation operation = new SearchHotelOperation(params);

        return exemplarClient.execute(operation)
            .thenApply(response -> {
                List<? extends Hotel> hotels = response.getData();

                if (hotels.isEmpty()) {
                    throw new RuntimeException("No hotels found for city: " + city + " with max price: $" + maxPrice);
                }

                Hotel firstHotel = hotels.get(0);
                logger.info("Search completed successfully for city: {} and max price ${}. Found hotel: {}", city, maxPrice, firstHotel.getName());
                return firstHotel;
            }).exceptionally(throwable -> {
                logger.error("Hotel search failed for city {}: {}", city, throwable.getMessage(), throwable);
                throw new RuntimeException("Hotel search failed", throwable);
            });
    }

    /**
     * Demonstrates the complete asynchronous booking creation workflow.
     *
     * @param hotel the hotel to create a booking for
     * @return CompletableFuture containing the created booking with confirmation details
     */
    private static CompletableFuture<Booking> makeBookingAsync(Hotel hotel) {
        logger.info("3. Making a Booking for hotel: {} (Async)", hotel.getName());

        GuestInfo guestInfo = GuestInfo.builder()
            .firstName("John")
            .lastName("Foo")
            .email("example@email.com")
            .build();

        BookingRequest bookingRequest = BookingRequest.builder()
            .hotelId(hotel.getId())                    // Reference the selected hotel
            .checkInDate(LocalDate.now())              // Start booking today
            .checkOutDate(LocalDate.now().plusDays(3)) // 3-night stay
            .guestInfo(guestInfo)                      // Attach guest information
            .guests(3)                                 // Number of guests
            .build();

        CreateBookingOperation operation = new CreateBookingOperation(bookingRequest);

        return exemplarClient.execute(operation)
            .thenApply(response -> {
                Booking booking = response.getData();
                logger.info("Booking made successfully. Confirmation Number: {}", booking.getConfirmationNumber());
                return booking;
            }).exceptionally(throwable -> {
                logger.error("Booking creation failed for hotel {}: {}", hotel.getName(), throwable.getMessage(), throwable);
                throw new RuntimeException("Booking creation failed", throwable);
            });
    }

    /**
     * Helper method to update a single booking asynchronously.
     *
     * @param confirmationNumber the confirmation number of the booking to update
     * @param booking            the updated booking information
     * @return CompletableFuture that completes when the update finishes
     */
    private static CompletableFuture<Void> updateBooking(String confirmationNumber, Booking booking) {
        logger.info("Updating booking: {}", confirmationNumber);

        UpdateBookingOperationParams params = UpdateBookingOperationParams.builder()
            .confirmationNumber(confirmationNumber)
            .build();

        UpdateBookingOperation operation = new UpdateBookingOperation(params, booking);

        return exemplarClient.execute(operation)
            .thenAccept(response -> logger.info("Booking {} updated successfully.", confirmationNumber))
            .exceptionally(throwable -> {
                logger.error("Failed to update booking {}: {}", confirmationNumber, throwable.getMessage(), throwable);
                return null;
            });
    }
}
