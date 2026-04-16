package com.bernardomecabo.ticket_hub.api.controllers.bookingController.command;

import com.bernardomecabo.ticket_hub.api.DTOs.requests.booking.CreateBookingRequest;
import com.bernardomecabo.ticket_hub.api.DTOs.responses.booking.CreateBookingResponse;
import com.bernardomecabo.ticket_hub.application.commands.booking.CreateBookingCommand;
import com.bernardomecabo.ticket_hub.application.commands.handlers.bookingHandler.CreateBookingHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/bookings")
@Tag(name = "",description = "")
public class BookingCommandController {

    private final CreateBookingHandler createBookingHandler;

    public BookingCommandController(CreateBookingHandler createBookingHandler) {
        this.createBookingHandler = createBookingHandler;
    }

    @PostMapping
    @Operation(summary = "", description = "")
    public ResponseEntity<CreateBookingResponse> createBooking(@RequestBody @Valid CreateBookingRequest request){
        CreateBookingCommand command = new CreateBookingCommand(request.eventId(),request.userId(),request.seatNumber(),request.price());
        CreateBookingResponse bookingResponse = createBookingHandler.ProcessTask(command);
        return new ResponseEntity<>(bookingResponse, HttpStatus.CREATED);
    }
}
