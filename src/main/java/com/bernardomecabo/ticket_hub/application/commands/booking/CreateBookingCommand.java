package com.bernardomecabo.ticket_hub.application.commands.booking;

import com.bernardomecabo.ticket_hub.api.DTOs.requests.booking.CreateBookingRequest;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateBookingCommand(
        UUID eventId,
        UUID customerId,
        String seatId,
        BigDecimal price
) {
    public CreateBookingCommand(CreateBookingRequest request){
        this(request.eventId(),request.customerId(),request.seatId(),request.price());
    }
}
