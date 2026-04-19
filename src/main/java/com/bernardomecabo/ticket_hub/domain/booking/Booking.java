package com.bernardomecabo.ticket_hub.domain.booking;

import com.bernardomecabo.ticket_hub.application.commands.booking.CreateBookingCommand;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
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

    @Column(name = "price", nullable = false, precision = 19, scale = 2)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    private LocalDateTime createdAt;

    protected Booking() {}

    public static Booking reserve(CreateBookingCommand command){
        Booking booking = new Booking();
        booking.id = UUID.randomUUID();
        booking.eventId = command.eventId();
        booking.customerId = command.customerId();
        booking.seatId = command.seatId();
        booking.price = command.price(); // !! todo: learn safer ways
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
