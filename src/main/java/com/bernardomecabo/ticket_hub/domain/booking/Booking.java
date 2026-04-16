package com.bernardomecabo.ticket_hub.domain.booking;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "bookings", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"event_id", "seat_id"})
})
public class Booking {

    @Id
    private UUID id;

    @Column(name = "event_id", nullable = false)
    private UUID eventId;

    @Column(name = "customer_id", nullable = false)
    private UUID customerId;

    @Column(name = "seat_id", nullable = false)
    private String seatId;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    private LocalDateTime createdAt;

    protected Booking() {}

    public static Booking reserve(UUID eventId, UUID customerId, String seatId){
        Booking booking = new Booking();
        booking.id = UUID.randomUUID();
        booking.eventId = eventId;
        booking.customerId = customerId;
        booking.status = BookingStatus.PENDING;
        booking.createdAt = LocalDateTime.now();
        return booking;
    }

    public void confirm(){
        if (this.status != BookingStatus.PENDING){
            throw new IllegalStateException("Only pending bookings can be confirmed!");
        }
        this.status = BookingStatus.CONFIRMED;
    }
}
