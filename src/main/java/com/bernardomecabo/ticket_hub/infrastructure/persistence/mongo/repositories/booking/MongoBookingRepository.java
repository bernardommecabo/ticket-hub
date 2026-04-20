package com.bernardomecabo.ticket_hub.infrastructure.persistence.mongo.repositories.booking;

import com.bernardomecabo.ticket_hub.infrastructure.persistence.mongo.documents.BookingProjection;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface MongoBookingRepository extends MongoRepository<BookingProjection, String > {
    BookingProjection findById(UUID id);
    List<BookingProjection> findByCustomerId(UUID customerId);
}
