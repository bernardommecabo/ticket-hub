package com.bernardomecabo.ticket_hub.application.commands.booking;

import com.bernardomecabo.ticket_hub.api.DTOs.requests.booking.DeleteBookingRequest;

import java.util.UUID;

public record DeleteBookingCommand(
        UUID id,
        UUID eventId,
        UUID customerId
) {
    public DeleteBookingCommand(DeleteBookingRequest request){
        this(request.id(),request.eventId(),request.customerId());
    }
}
