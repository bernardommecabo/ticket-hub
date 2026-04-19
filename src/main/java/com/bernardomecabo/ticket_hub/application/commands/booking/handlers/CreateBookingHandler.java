package com.bernardomecabo.ticket_hub.application.commands.booking.handlers;

import com.bernardomecabo.ticket_hub.api.DTOs.responses.booking.CreateBookingResponse;
import com.bernardomecabo.ticket_hub.application.commands.booking.CreateBookingCommand;
import com.bernardomecabo.ticket_hub.domain.booking.Booking;
import com.bernardomecabo.ticket_hub.infrastructure.persistence.mongo.documents.BookingProjection;
import com.bernardomecabo.ticket_hub.infrastructure.persistence.mongo.repositories.booking.MongoBookingRepository;
import com.bernardomecabo.ticket_hub.infrastructure.persistence.postgre.repositories.booking.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreateBookingHandler {

    @Autowired
    private final BookingRepository repository;

    @Autowired
    private final MongoBookingRepository mongoRepository;

    public CreateBookingHandler(BookingRepository repository, MongoBookingRepository mongoRepository){
        this.repository = repository;
        this.mongoRepository = mongoRepository;
    }

    public CreateBookingResponse ProcessTask(CreateBookingCommand command){
        Booking booking = Booking.reserve(command);
        repository.save(booking);
        BookingProjection projection = new BookingProjection(booking);
        mongoRepository.save(projection);
        return new CreateBookingResponse(booking);
    }
}
