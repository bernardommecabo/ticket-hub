package com.bernardomecabo.ticket_hub.application.commands.booking.handlers;

import com.bernardomecabo.ticket_hub.application.commands.booking.DeleteBookingCommand;
import com.bernardomecabo.ticket_hub.domain.booking.Booking;
import com.bernardomecabo.ticket_hub.infrastructure.persistence.mongo.documents.BookingProjection;
import com.bernardomecabo.ticket_hub.infrastructure.persistence.mongo.repositories.MongoBookingRepository;
import com.bernardomecabo.ticket_hub.infrastructure.persistence.postgre.repositories.booking.BookingRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeleteBookingHandler {

    private final BookingRepository repository;
    private final MongoBookingRepository mongoRepository;

    public DeleteBookingHandler(BookingRepository repository, MongoBookingRepository mongoRepository) {
        this.repository = repository;
        this.mongoRepository = mongoRepository;
    }

    public ResponseEntity<?> ProcessTask(DeleteBookingCommand command){
        Booking exists = repository.findById(command.id())
                .orElseThrow(() -> new EntityNotFoundException("Booking with id " + command.id() + " was not found"));

        if (exists.getEventId().equals(command.eventId()) && exists.getCustomerId().equals(command.customerId())){
            BookingProjection projection = mongoRepository.findById(command.id());
            mongoRepository.delete(projection);
            repository.delete(exists);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>("This booking does not belong to the provided event.", HttpStatus.FORBIDDEN);
    }
}
