package com.bernardomecabo.ticket_hub.application.commands.booking;

import com.bernardomecabo.ticket_hub.api.DTOs.requests.booking.UpdateBookingRequest;

import java.util.UUID;

public record UpdateBookingCommand(
        UUID id,
        UUID eventId,
        UUID customerId,
        String seatId
) {
    public UpdateBookingCommand(UpdateBookingRequest request){
        this(request.id(), request.eventId(),request.customerId(),request.seatId());
    }
}
