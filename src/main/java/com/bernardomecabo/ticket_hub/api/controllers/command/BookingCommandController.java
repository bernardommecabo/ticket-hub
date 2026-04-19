package com.bernardomecabo.ticket_hub.api.controllers.command;

import com.bernardomecabo.ticket_hub.api.DTOs.requests.booking.CreateBookingRequest;
import com.bernardomecabo.ticket_hub.api.DTOs.requests.booking.DeleteBookingRequest;
import com.bernardomecabo.ticket_hub.api.DTOs.requests.booking.UpdateBookingRequest;
import com.bernardomecabo.ticket_hub.api.DTOs.responses.booking.CreateBookingResponse;
import com.bernardomecabo.ticket_hub.api.DTOs.responses.booking.UpdateBookingResponse;
import com.bernardomecabo.ticket_hub.application.commands.booking.CreateBookingCommand;
import com.bernardomecabo.ticket_hub.application.commands.booking.DeleteBookingCommand;
import com.bernardomecabo.ticket_hub.application.commands.booking.UpdateBookingCommand;
import com.bernardomecabo.ticket_hub.application.commands.booking.handlers.CreateBookingHandler;
import com.bernardomecabo.ticket_hub.application.commands.booking.handlers.DeleteBookingHandler;
import com.bernardomecabo.ticket_hub.application.commands.booking.handlers.UpdateBookingHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/bookings")
@Tag(name = "Booking",description = "")
public class BookingCommandController {

    private final CreateBookingHandler createBookingHandler;
    private final DeleteBookingHandler deleteBookingHandler;
    private final UpdateBookingHandler updateBookingHandler;

    public BookingCommandController(CreateBookingHandler createBookingHandler, DeleteBookingHandler deleteBookingHandler, UpdateBookingHandler updateBookingHandler) {
        this.createBookingHandler = createBookingHandler;
        this.deleteBookingHandler = deleteBookingHandler;
        this.updateBookingHandler = updateBookingHandler;
    }

    @PostMapping
    @Operation(summary = "Create a Booking", description = "")
    public ResponseEntity<CreateBookingResponse> createBooking(@RequestBody @Valid CreateBookingRequest request){
        CreateBookingCommand command = new CreateBookingCommand(request);
        CreateBookingResponse bookingResponse = createBookingHandler.ProcessTask(command);
        return new ResponseEntity<>(bookingResponse, HttpStatus.CREATED);
    }

    @PutMapping
    @Operation(summary = "Update a Booking", description = "Change the seat")
    public ResponseEntity<?> updateBooking(@RequestBody @Valid UpdateBookingRequest request){
        UpdateBookingCommand command = new UpdateBookingCommand(request);
        UpdateBookingResponse bookingResponse = updateBookingHandler.ProcessTask(command);
        return new ResponseEntity<>(bookingResponse, HttpStatus.OK);
    }

    @DeleteMapping
    @Operation(summary = "Delete a Booking", description = "")
    public ResponseEntity<?> deleteBooking(@RequestBody @Valid DeleteBookingRequest request){
        DeleteBookingCommand command = new DeleteBookingCommand(request);
        return deleteBookingHandler.ProcessTask(command);
    }
}
