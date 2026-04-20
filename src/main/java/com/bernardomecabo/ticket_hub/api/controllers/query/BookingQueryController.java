package com.bernardomecabo.ticket_hub.api.controllers.query;

import com.bernardomecabo.ticket_hub.api.DTOs.responses.booking.BookingListResponse;
import com.bernardomecabo.ticket_hub.application.queries.booking.GetBookingsByCustomerId;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/bookings")
@Tag(name = "Booking", description = "")
public class BookingQueryController {

    private final GetBookingsByCustomerId getBookingsByCustomerId;

    public BookingQueryController(GetBookingsByCustomerId getBookingsByCustomerId) {
        this.getBookingsByCustomerId = getBookingsByCustomerId;
    }

    @GetMapping
    @Operation(summary = "Get all bookings by customer ID", description = "")
    public ResponseEntity<List<BookingListResponse>> getBookingsByCustomerId(@RequestParam UUID customerId){
        List<BookingListResponse> responses = getBookingsByCustomerId.ProcessTask(customerId);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

}
