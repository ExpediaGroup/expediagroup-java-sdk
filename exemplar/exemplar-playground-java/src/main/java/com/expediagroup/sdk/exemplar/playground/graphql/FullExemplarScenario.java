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

import com.expediagroup.sdk.exemplar.graphql.client.ExemplarGraphQLClient;
import com.expediagroup.sdk.exemplar.graphql.generated.CreateBookingMutation;
import com.expediagroup.sdk.exemplar.graphql.generated.GetAllBookingsQuery;
import com.expediagroup.sdk.exemplar.graphql.generated.SearchHotelsQuery;
import com.expediagroup.sdk.exemplar.graphql.generated.UpdateBookingMutation;
import com.expediagroup.sdk.exemplar.graphql.generated.type.BookingInput;
import com.expediagroup.sdk.exemplar.graphql.generated.type.BookingStatus;
import com.expediagroup.sdk.exemplar.graphql.generated.type.BookingUpdateInput;
import com.expediagroup.sdk.exemplar.graphql.generated.type.GuestInfoInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class FullExemplarScenario {
    /** Logger for tracking exception handling and error details */
    private static final Logger logger = LoggerFactory.getLogger(FullExemplarScenario.class);

    /** SDK client instance for executing operations and handling exceptions */
    private static final ExemplarGraphQLClient exemplarClient = new ExemplarGraphQLClient();

    public static void main(String[] args) {
        try {
            logger.info("=== Starting Full Exemplar GraphQL SDK Scenario ===");

            // Step 1: Discover available hotels
            searchAllHotels();

            // Step 2: Search and select hotels by specific criteria
            SearchHotelsQuery.Hotel nyHotel = searchHotelByCityAndMaxPrice("New York", BigDecimal.valueOf(300.00));
            SearchHotelsQuery.Hotel miamiHotel = searchHotelByCityAndMaxPrice("Miami", BigDecimal.valueOf(400.00));

            // Step 3: Create bookings for selected hotels
            CreateBookingMutation.CreateBooking nyBooking = makeBooking(nyHotel);
            CreateBookingMutation.CreateBooking miamiBooking = makeBooking(miamiHotel);

            // Step 4: Retrieve and review all bookings
            getAllBookings();

            // Step 5: Demonstrate booking modifications
            // Since the API uses PUT-like updates, we need to copy the previous data
            // Apollo does not generate toBuilder methods
            BookingUpdateInput updatedNyBooking = new BookingUpdateInput.Builder()
                .checkInDate(LocalDate.now())
                .checkOutDate(LocalDate.now().plusDays(5)) // Extend the stay (Update)
                .guestInfo(new GuestInfoInput.Builder()
                    .firstName("John")
                    .lastName("Doe")
                    .email("example@email.com")
                    .build()
                )
                .guests(nyBooking.getGuests())
                .build();

            // Cancel Miami booking
            BookingUpdateInput updatedMiamiBooking = new BookingUpdateInput.Builder()
                .status(BookingStatus.CANCELLED)
                .checkInDate(LocalDate.now())
                .checkOutDate(LocalDate.now().plusDays(5))
                .guestInfo(new GuestInfoInput.Builder()
                    .firstName("John")
                    .lastName("Doe")
                    .email("example@email.com")
                    .build()
                )
                .guests(nyBooking.getGuests())
                .build();

            // Step 6: Apply booking updates
            updateBooking(nyBooking.getConfirmationNumber(), updatedNyBooking);
            updateBooking(miamiBooking.getConfirmationNumber(), updatedMiamiBooking);

            logger.info("=== Full Exemplar GraphQL SDK Scenario Completed Successfully ===");
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
        SearchHotelsQuery query = new SearchHotelsQuery();

        // Execute the operation through the client
        // Note: Response data is available via .getData() but not used here
        exemplarClient.execute(query);

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
    private static SearchHotelsQuery.Hotel searchHotelByCityAndMaxPrice(String city, BigDecimal maxPrice) {
        logger.info("2. Search Hotels in City: {} with max price ${}", city, maxPrice);

        // Build parameters with specific filters
        SearchHotelsQuery query = new SearchHotelsQuery.Builder()
            .city(city)
            .maxPrice(maxPrice)
            .build();

        // Extract and return the first hotel from results
        // In a real application, you would handle empty results gracefully
        SearchHotelsQuery.Hotel firstHotel = exemplarClient.execute(query).getData().getHotels().get(0);

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
    private static CreateBookingMutation.CreateBooking makeBooking(SearchHotelsQuery.Hotel hotel) {
        logger.info("3. Make a Booking for hotel: {}", hotel.getName());

        // Step 1: Create guest information
        GuestInfoInput guestInfo = new GuestInfoInput.Builder()
            .firstName("John")
            .lastName("Doe")
            .email("example@email.com")
            .build();

        BookingInput input = new BookingInput.Builder()
            .hotelId(hotel.getId())                    // Reference the selected hotel
            .checkInDate(LocalDate.now())              // Start booking today
            .checkOutDate(LocalDate.now().plusDays(3)) // 3-night stay
            .guestInfo(guestInfo)                      // Attach guest information
            .guests(3)                                 // Number of guests
            .build();

        CreateBookingMutation mutation = new CreateBookingMutation(input);

        // Step 4: Process the response and extract the created booking
        CreateBookingMutation.CreateBooking booking = exemplarClient.execute(mutation).getData().getCreateBooking();

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

        GetAllBookingsQuery query = new GetAllBookingsQuery();

        // Execute and extract the list of bookings
        List<GetAllBookingsQuery.Booking> bookings = exemplarClient.execute(query).getData().getBookings();

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
     * @param bookingInput the booking object with updated information
     */
    private static void updateBooking(String confNumber, BookingUpdateInput bookingInput) {
        logger.info("5. Update Booking: {}", confNumber);

        // Build parameters with the confirmation number for the path
        UpdateBookingMutation mutation = new UpdateBookingMutation.Builder()
            .confirmationNumber(confNumber)
            .input(bookingInput)
            .build();

        // Execute the update operation
        exemplarClient.execute(mutation);

        logger.info("Booking updated successfully. New status: {}, Check-out date: {}",
            bookingInput.getStatus(), bookingInput.getCheckOutDate());
    }
}
