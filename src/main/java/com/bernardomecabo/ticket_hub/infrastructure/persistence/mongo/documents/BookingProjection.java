package com.bernardomecabo.ticket_hub.infrastructure.persistence.mongo.documents;

import com.bernardomecabo.ticket_hub.domain.booking.Booking;
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
}
