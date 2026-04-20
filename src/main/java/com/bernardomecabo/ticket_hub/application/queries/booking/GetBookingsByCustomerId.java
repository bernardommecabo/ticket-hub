package com.bernardomecabo.ticket_hub.application.queries.booking;

import com.bernardomecabo.ticket_hub.api.DTOs.responses.booking.BookingListResponse;
import com.bernardomecabo.ticket_hub.infrastructure.persistence.mongo.repositories.booking.MongoBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GetBookingsByCustomerId {

    @Autowired
    private final MongoBookingRepository mongoRepository;

    public GetBookingsByCustomerId(MongoBookingRepository mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    public List<BookingListResponse> ProcessTask(UUID customerId){
        return mongoRepository.findByCustomerId(customerId)
                .stream()
                .map(BookingListResponse::new)
                .toList();
    }
}
