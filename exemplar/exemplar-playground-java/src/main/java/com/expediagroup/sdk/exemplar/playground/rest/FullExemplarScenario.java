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

import com.expediagroup.sdk.exemplar.rest.client.ExemplarClient;
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

/**
 * Full Exemplar SDK Scenario - A Complete Hotel Booking Workflow
 * <p>
 * This class demonstrates a comprehensive example of how to use the Expedia Group SDK
 * to interact with the exemplar REST API for hotel booking operations. It showcases
 * the complete workflow from hotel search to booking management.
 * <p>
 * Workflow Overview:
 * 1. Hotel Search: Search for all hotels and filter by location and price
 * 2. Hotel Selection: Select specific hotels from search results
 * 3. Booking Creation: Create bookings for selected hotels
 * 4. Booking Retrieval: Fetch all existing bookings
 * 5. Booking Updates: Modify existing bookings (dates, status, etc.)
 * <p>
 * Key SDK Features Demonstrated:
 * - Client initialization and configuration
 * - Operation parameter building with builder pattern
 * - Request execution and response handling
 * - Model object manipulation and updates
 * - Error handling and logging
 * <p>
 * Prerequisites: The exemplar-server must be running on localhost:8080
 * before executing this scenario.
 *
 * @see ExemplarClient
 * @see Hotel
 * @see Booking
 * @see BookingRequest
 */
public class FullExemplarScenario {
    /** Logger for tracking scenario execution and debugging */
    private static final Logger logger = LoggerFactory.getLogger(FullExemplarScenario.class);

    /**
     * Exemplar SDK client instance for making API calls.
     */
    private static final ExemplarClient exemplarClient = new ExemplarClient();

    /**
     * Main entry point for the full exemplar scenario demonstration.
     * <p>
     * Executes a complete hotel booking workflow that includes:
     * - Searching for all available hotels
     * - Filtering hotels by city and maximum price
     * - Creating bookings for selected hotels
     * - Retrieving all bookings
     * - Updating booking details
     */
    public static void main(String[] args) {
        logger.info("=== Starting Full Exemplar SDK Scenario ===");

        try {
            // Step 1: Discover available hotels
            searchAllHotels();

            // Step 2: Search and select hotels by specific criteria
            Hotel nyHotel = searchHotelByCityAndMaxPrice("New York", BigDecimal.valueOf(300.00));
            Hotel miamiHotel = searchHotelByCityAndMaxPrice("Miami", BigDecimal.valueOf(400.00));

            // Step 3: Create bookings for selected hotels
            Booking nyBooking = makeBooking(nyHotel);
            Booking miamiBooking = makeBooking(miamiHotel);

            // Step 4: Retrieve and review all bookings
            getAllBookings();

            // Step 5: Demonstrate booking modifications
            Booking updatedNyBooking = nyBooking.toBuilder()
                .checkOutDate(LocalDate.now().plusDays(5))
                .build();

            // Cancel Miami booking
            Booking updatedMiamiBooking = miamiBooking.toBuilder()
                .status(Booking.Status.CANCELLED)
                .build();

            // Step 6: Apply booking updates
            updateBooking(updatedNyBooking);
            updateBooking(updatedMiamiBooking);

            logger.info("=== Full Exemplar SDK Scenario Completed Successfully ===");
        } catch (Exception e) {
            logger.error("Error during scenario execution: {}", e.getMessage(), e);
            throw new RuntimeException("Scenario failed", e);
        } finally {
            exemplarClient.dispose();
        }
    }

    /**
     * Demonstrates basic hotel search functionality without filters.
     * <p>
     * This method shows how to:
     * - Create operation parameters using the builder pattern
     * - Instantiate and execute a search operation
     * - Handle the response (though results are not processed in this example)
     * <p>
     * SDK Pattern: Parameter Builder → Operation → Client Execution
     */
    private static void searchAllHotels() {
        logger.info("1. Search All Hotels");

        // Build parameters for the search operation (empty = no filters)
        SearchHotelOperationParams params = SearchHotelOperationParams.builder().build();

        // Create the operation instance with parameters
        SearchHotelOperation operation = new SearchHotelOperation(params);

        // Execute the operation through the client
        // Note: Response data is available via .getData() but not used here
        exemplarClient.execute(operation);

        logger.info("Search completed successfully.");
    }

    /**
     * Demonstrates filtered hotel search with specific criteria and response processing.
     * <p>
     * This method showcases:
     * - Setting query parameters (city and maximum price filters)
     * - Processing response data to extract specific results
     * - Returning domain objects for further use
     *
     * @param city the city to search for hotels in
     * @param maxPrice the maximum price per night filter
     * @return the first hotel from the search results
     */
    private static Hotel searchHotelByCityAndMaxPrice(String city, BigDecimal maxPrice) {
        logger.info("2. Search Hotels in City: {} with max price ${}", city, maxPrice);

        // Build parameters with specific filters
        SearchHotelOperationParams params = SearchHotelOperationParams.builder()
            .city(city)           // Filter by city name
            .maxPrice(maxPrice)   // Filter by maximum price per night
            .build();

        // Execute the search operation
        SearchHotelOperation operation = new SearchHotelOperation(params);

        // Extract and return the first hotel from results
        // In a real application, you would handle empty results gracefully
        Hotel firstHotel = exemplarClient.execute(operation).getData().get(0);

        logger.info("Search completed successfully for city: {} and max price ${}. Found hotel: {}",
                   city, maxPrice, firstHotel.getName());

        return firstHotel;
    }

    /**
     * Demonstrates the complete booking creation workflow.
     * <p>
     * This method illustrates:
     * - Creating complex model objects (GuestInfo) using builder pattern
     * - Building booking requests with required and optional fields
     * - Executing POST operations with request bodies
     * - Handling successful booking responses
     * <p>
     * Key SDK Concepts:
     * - Builder Pattern: All model objects support fluent building
     * - Request Bodies: Operations can include complex request payloads
     * - Type Safety: Strong typing ensures correct data structure
     *
     * @param hotel the hotel to create a booking for
     * @return the created booking with confirmation details
     */
    private static Booking makeBooking(Hotel hotel) {
        logger.info("3. Make a Booking for hotel: {}", hotel.getName());

        // Step 1: Create guest information
        GuestInfo guestInfo = GuestInfo.builder()
            .firstName("John")
            .lastName("Doe")
            .email("example@email.com")
            .build();

        // Step 2: Build the booking request
        BookingRequest bookingRequest = BookingRequest.builder()
            .hotelId(hotel.getId())                    // Reference the selected hotel
            .checkInDate(LocalDate.now())              // Start booking today
            .checkOutDate(LocalDate.now().plusDays(3)) // 3-night stay
            .guestInfo(guestInfo)                      // Attach guest information
            .guests(3)                                 // Number of guests
            .build();

        // Step 3: Execute the booking creation operation
        CreateBookingOperation operation = new CreateBookingOperation(bookingRequest);

        // Step 4: Process the response and extract the created booking
        Booking booking = exemplarClient.execute(operation).getData();

        logger.info("Booking made successfully. Confirmation Number: {}, Total Price: ${}",
                   booking.getConfirmationNumber(), booking.getTotalPrice());

        return booking;
    }

    /**
     * Demonstrates retrieving collections of data from the API.
     * <p>
     * This method shows:
     * - Executing operations that return collections (List)
     * - Processing collection responses
     * - Working with parameterless operations
     * <p>
     * Collection Handling: The SDK automatically deserializes
     * JSON arrays into strongly-typed Java collections.
     */
    private static void getAllBookings() {
        logger.info("4. Get All Bookings");

        // Create operation without parameters (no filters)
        GetAllBookingsOperation operation = new GetAllBookingsOperation();

        // Execute and extract the list of bookings
        List<? extends Booking> bookings = exemplarClient.execute(operation).getData();

        logger.info("Retrieved {} bookings.", bookings.size());

        bookings.forEach(booking ->
            logger.debug("Booking {}: {} - Status: {}",
                        booking.getConfirmationNumber(),
                        booking.getHotel().getName(),
                        booking.getStatus())
        );
    }

    /**
     * Demonstrates updating existing resources via PUT operations.
     * <p>
     * This method showcases:
     * - Using path parameters (confirmation number) in operations
     * - Sending complete object updates via PUT requests
     * - Handling update operations that modify server state
     * <p>
     * Update Pattern: The SDK uses PUT semantics for updates,
     * requiring the complete updated object to be sent.
     *
     * @param booking the booking object with updated information
     */
    private static void updateBooking(Booking booking) {
        logger.info("5. Update Booking: {}", booking.getConfirmationNumber());

        // Build parameters with the confirmation number for the path
        UpdateBookingOperationParams params = UpdateBookingOperationParams.builder()
            .confirmationNumber(booking.getConfirmationNumber()) // Path parameter
            .build();

        // Create update operation with both path params and request body
        UpdateBookingOperation operation = new UpdateBookingOperation(params, booking);

        // Execute the update operation
        exemplarClient.execute(operation);

        logger.info("Booking updated successfully. New status: {}, Check-out date: {}",
                   booking.getStatus(), booking.getCheckOutDate());
    }
}
