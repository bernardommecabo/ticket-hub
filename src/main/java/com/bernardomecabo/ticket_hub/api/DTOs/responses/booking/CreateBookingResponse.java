package com.bernardomecabo.ticket_hub.api.DTOs.responses.booking;

import com.bernardomecabo.ticket_hub.domain.booking.Booking;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateBookingResponse(
        UUID eventId,
        String seatId,
        BigDecimal price
) {
    public CreateBookingResponse(Booking booking) {
        this(booking.getEventId(), booking.getSeatId(), booking.getPrice());
    }
}
