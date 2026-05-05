package com.bernardomecabo.ticket_hub.infrastructure.messaging.consumers;

import com.bernardomecabo.ticket_hub.infrastructure.messaging.events.BookingCreatedEvent;
import com.bernardomecabo.ticket_hub.infrastructure.persistence.mongo.documents.BookingProjection;
import com.bernardomecabo.ticket_hub.infrastructure.persistence.mongo.repositories.MongoBookingRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class BookingStreamConfig {

    @Bean
    public Consumer<BookingCreatedEvent> syncBooking(MongoBookingRepository repository) {
        return event -> {
            BookingProjection projection = new BookingProjection(event);
            repository.save(projection);
        };
    }
}
