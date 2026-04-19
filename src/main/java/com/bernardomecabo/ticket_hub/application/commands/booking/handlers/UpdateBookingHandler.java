package com.bernardomecabo.ticket_hub.application.commands.booking.handlers;

import com.bernardomecabo.ticket_hub.api.DTOs.responses.booking.UpdateBookingResponse;
import com.bernardomecabo.ticket_hub.application.commands.booking.UpdateBookingCommand;
import com.bernardomecabo.ticket_hub.domain.booking.Booking;
import com.bernardomecabo.ticket_hub.infrastructure.persistence.mongo.documents.BookingProjection;
import com.bernardomecabo.ticket_hub.infrastructure.persistence.mongo.repositories.booking.MongoBookingRepository;
import com.bernardomecabo.ticket_hub.infrastructure.persistence.postgre.repositories.booking.BookingRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UpdateBookingHandler {

    @Autowired
    private final BookingRepository repository;

    @Autowired
    private final MongoBookingRepository mongoRepository;

    public UpdateBookingHandler(BookingRepository repository, MongoBookingRepository mongoRepository) {
        this.repository = repository;
        this.mongoRepository = mongoRepository;
    }

    public UpdateBookingResponse ProcessTask(UpdateBookingCommand command){
        Booking booking = repository.findById(command.id())
                .orElseThrow(() -> new EntityNotFoundException("Booking with id " + command.id() + " was not found."));

        if (booking.getEventId().equals(command.eventId()) && booking.getCustomerId().equals(command.customerId())){
            BookingProjection projection = mongoRepository.findById(command.id());
            booking.setSeatId(command.seatId());
            repository.save(booking);
            projection.setSeatId(command.seatId());
            mongoRepository.save(projection);

            return new UpdateBookingResponse(booking);
        }
        throw new SecurityException("This booking do not belong to this customer or event.");
    }
}
