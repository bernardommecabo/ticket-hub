package com.bernardomecabo.ticket_hub.application.commands.handlers.bookingHandler;

import com.bernardomecabo.ticket_hub.api.DTOs.responses.booking.CreateBookingResponse;
import com.bernardomecabo.ticket_hub.application.commands.booking.CreateBookingCommand;
import com.bernardomecabo.ticket_hub.domain.booking.BookingRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreateBookingHandler {

    private final BookingRepository repository;

    public CreateBookingHandler(BookingRepository repository){
        this.repository = repository;
    }

    public CreateBookingResponse ProcessTask(CreateBookingCommand command){
        return new CreateBookingResponse(command.eventId(),command.seatNumber(),command.price());
    }
}
