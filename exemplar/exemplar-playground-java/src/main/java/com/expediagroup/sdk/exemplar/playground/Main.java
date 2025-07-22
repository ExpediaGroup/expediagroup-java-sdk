package com.expediagroup.sdk.exemplar.playground;

import com.expediagroup.sdk.exemplar.graphql.CreateBookingMutation;
import com.expediagroup.sdk.exemplar.graphql.SearchHotelsQuery;
import com.expediagroup.sdk.exemplar.graphql.client.ExemplarGraphQLClient;
import com.expediagroup.sdk.exemplar.graphql.type.BookingInput;
import com.expediagroup.sdk.exemplar.graphql.type.GuestInfoInput;
import com.expediagroup.sdk.graphql.exception.NoDataException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        var client = new ExemplarGraphQLClient();

        var params = new SearchHotelsQuery.Builder()
            .city("New York")
            .maxPrice(BigDecimal.valueOf(300.00))
            .build();

        List<SearchHotelsQuery.Hotel> hotels = client.execute(params).getData().getHotels();

        GuestInfoInput guestInfo = new GuestInfoInput.Builder()
            .firstName("John")
            .lastName("Smith")
            .email("example@email.com")
            .phone("123-456-7890")
            .build();

        BookingInput bookingInput = new BookingInput.Builder()
            .hotelId(hotels.get(0).getId())
            .checkInDate(LocalDate.now())
            .checkOutDate(LocalDate.now().minusDays(2))
            .guestInfo(guestInfo)
            .guests(2)
            .build();

        try {
            CreateBookingMutation createBookingMutation = new CreateBookingMutation(bookingInput);
            client.execute(createBookingMutation);
        } catch (NoDataException e) {
            System.out.println(e.getErrors());
        }
    }
}
