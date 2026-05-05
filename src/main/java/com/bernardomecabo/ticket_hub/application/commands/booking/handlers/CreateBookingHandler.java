package com.bernardomecabo.ticket_hub.application.commands.booking.handlers;

import com.bernardomecabo.ticket_hub.api.DTOs.responses.booking.CreateBookingResponse;
import com.bernardomecabo.ticket_hub.application.commands.booking.CreateBookingCommand;
import com.bernardomecabo.ticket_hub.domain.booking.Booking;
import com.bernardomecabo.ticket_hub.infrastructure.messaging.events.BookingCreatedEvent;
import com.bernardomecabo.ticket_hub.infrastructure.persistence.mongo.repositories.MongoBookingRepository;
import com.bernardomecabo.ticket_hub.infrastructure.persistence.postgre.repositories.booking.BookingRepository;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreateBookingHandler {

    private final BookingRepository repository;
    private final MongoBookingRepository mongoRepository;
    private final StreamBridge streamBridge;

    public CreateBookingHandler(BookingRepository repository, MongoBookingRepository mongoRepository, StreamBridge streamBridge){
        this.repository = repository;
        this.mongoRepository = mongoRepository;
        this.streamBridge = streamBridge;
    }

    public CreateBookingResponse ProcessTask(CreateBookingCommand command){
        Booking booking = Booking.reserve(command);
        repository.save(booking);

        streamBridge.send("syncBooking-out-0", new BookingCreatedEvent(booking));
        return new CreateBookingResponse(booking);
    }
}
