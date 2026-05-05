package com.bernardomecabo.ticket_hub.infrastructure.messaging.events;

import com.bernardomecabo.ticket_hub.domain.booking.Booking;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record BookingCreatedEvent(
        UUID id,
        UUID eventId,
        UUID customerId,
        String seatId,
        String status,
        BigDecimal price,
        LocalDateTime createdAt,
        LocalDateTime lastUpdated
) {
    public BookingCreatedEvent(Booking booking){
        this(booking.getId(),booking.getEventId(),booking.getCustomerId(),booking.getSeatId(),booking.getStatus().toString(),booking.getPrice(),booking.getCreatedAt(),LocalDateTime.now());
    }
}
