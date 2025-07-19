package com.expediagroup.sdk.exemplar.playground;

import com.expediagroup.sdk.exemplar.client.ExemplarClient;
import com.expediagroup.sdk.exemplar.model.Booking;
import com.expediagroup.sdk.exemplar.model.BookingRequest;
import com.expediagroup.sdk.exemplar.model.GuestInfo;
import com.expediagroup.sdk.exemplar.model.Hotel;
import com.expediagroup.sdk.exemplar.operation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class FullExemplarScenario {
    private static final Logger logger = LoggerFactory.getLogger(FullExemplarScenario.class);

    private static final ExemplarClient exemplarClient = new ExemplarClient();

    public static void main(String[] args) {
        searchAllHotels();

        Hotel nyHotel = searchHotelByCityAndMaxPrice("New York", BigDecimal.valueOf(300.00));
        Hotel miamiHotel = searchHotelByCityAndMaxPrice("Miami", BigDecimal.valueOf(400.00));

        Booking nyBooking = makeBooking(nyHotel);
        Booking miamiBooking = makeBooking(miamiHotel);

        getAllBookings();

        Booking updatedNyBooking = nyBooking.toBuilder()
            .checkOutDate(LocalDate.now().plusDays(5))
            .build();

        Booking updatedMiamiBooking = miamiBooking.toBuilder()
            .status(Booking.Status.CANCELLED)
            .build();

        updateBooking(updatedNyBooking);
        updateBooking(updatedMiamiBooking);
    }

    private static void searchAllHotels() {
        logger.info("1. Search All Hotels");

        SearchHotelOperationParams params = SearchHotelOperationParams.builder().build();
        SearchHotelOperation operation = new SearchHotelOperation(params);

        exemplarClient.execute(operation);

        logger.info("Search completed successfully.");
    }

    private static Hotel searchHotelByCityAndMaxPrice(String city, BigDecimal maxPrice) {
        logger.info("2. Search Hotels in City: {} with max price {}$", city, maxPrice);

        SearchHotelOperationParams params = SearchHotelOperationParams.builder()
            .city(city)
            .maxPrice(maxPrice)
            .build();

        SearchHotelOperation operation = new SearchHotelOperation(params);

        Hotel firstHotel = exemplarClient.execute(operation).getData().get(0);

        logger.info("Search completed successfully for city: {} and max price {}$", city, maxPrice);

        return firstHotel;
    }

    private static Booking makeBooking(Hotel hotel) {
        logger.info("3. Make a Booking");

        GuestInfo guestInfo = GuestInfo.builder()
            .firstName("John")
            .lastName("Doe")
            .email("example@email.com")
            .build();

        BookingRequest bookingRequest = BookingRequest.builder()
            .hotelId(hotel.getId())
            .checkInDate(LocalDate.now())
            .checkOutDate(LocalDate.now().plusDays(3))
            .guestInfo(guestInfo)
            .guests(3)
            .build();

        CreateBookingOperation operation = new CreateBookingOperation(bookingRequest);

        Booking booking = exemplarClient.execute(operation).getData();

        logger.info("Booking made successfully.");

        return booking;
    }

    private static void getAllBookings() {
        logger.info("4. Get All Bookings");

        GetAllBookingsOperation operation = new GetAllBookingsOperation();

        List<? extends Booking> bookings = exemplarClient.execute(operation).getData();

        logger.info("Retrieved {} bookings.", bookings.size());
    }

    private static void updateBooking(Booking booking) {
        logger.info("6. Update Booking");

        UpdateBookingOperationParams params = UpdateBookingOperationParams.builder()
            .confirmationNumber(booking.getConfirmationNumber())
            .build();

        UpdateBookingOperation operation = new UpdateBookingOperation(params, booking);

        exemplarClient.execute(operation);

        logger.info("Booking updated successfully.");
    }
}
