package com.expediagroup.sdk.exemplar.playground;

import com.expediagroup.sdk.exemplar.client.ExemplarClient;
import com.expediagroup.sdk.exemplar.model.*;
import com.expediagroup.sdk.exemplar.model.exception.CreateBooking400Exception;
import com.expediagroup.sdk.exemplar.operation.CreateBookingOperation;
import com.expediagroup.sdk.exemplar.operation.SearchHotelOperation;
import com.expediagroup.sdk.exemplar.operation.SearchHotelOperationParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class HandleOperationException {
    private static final Logger logger = LoggerFactory.getLogger(HandleOperationException.class);

    private static final ExemplarClient exemplarClient = new ExemplarClient();

    public static void main(String[] args) {

        SearchHotelOperationParams searchHotelOperationParams = SearchHotelOperationParams.builder()
            .city("New York")
            .build();

        SearchHotelOperation searchHotelOperation = new SearchHotelOperation(searchHotelOperationParams);

        Hotel hotel = exemplarClient.execute(searchHotelOperation).getData().get(0);

        BookingRequest bookingRequest = BookingRequest.builder()
            .hotelId(hotel.getId())
            .checkInDate(LocalDate.now())
            .checkOutDate(LocalDate.now().minusDays(1)) // Intentionally set to a past date to trigger an error
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

        try {
            exemplarClient.execute(operation);
        } catch (CreateBooking400Exception e) {
            logger.info(e.getMessage());
            ProblemDetail problemDetail = e.getErrorResponse();

            logger.info("Problem detail: {}", problemDetail);
        }
    }
}
