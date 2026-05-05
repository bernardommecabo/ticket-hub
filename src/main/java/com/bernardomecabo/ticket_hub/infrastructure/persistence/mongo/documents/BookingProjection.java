package com.bernardomecabo.ticket_hub.infrastructure.persistence.mongo.documents;

import com.bernardomecabo.ticket_hub.domain.booking.Booking;
import com.bernardomecabo.ticket_hub.infrastructure.messaging.events.BookingCreatedEvent;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Document(collection = "bookings")
public class BookingProjection{
    @Id
    private UUID id;

    private UUID eventId;
    private UUID customerId;
    private String seatId;
    private String status;
    private BigDecimal price;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdated;

    @PersistenceCreator
    public BookingProjection() {}

    public BookingProjection(Booking booking){
        this.id = booking.getId();
        this.eventId = booking.getEventId();
        this.customerId = booking.getCustomerId();
        this.seatId = booking.getSeatId();
        this.status = booking.getStatus().toString();
        this.price = booking.getPrice();
        this.createdAt = booking.getCreatedAt();
        this.lastUpdated = LocalDateTime.now();
    }

    public BookingProjection(BookingCreatedEvent event) {
        this.id = event.id();
        this.eventId = event.eventId();
        this.customerId = event.customerId();
        this.seatId = event.seatId();
        this.status = event.status();
        this.price = event.price();
        this.createdAt = event.createdAt();
        this.lastUpdated = event.lastUpdated();
    }


}
