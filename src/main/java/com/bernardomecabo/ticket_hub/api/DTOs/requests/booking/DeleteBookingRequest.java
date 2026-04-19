package com.bernardomecabo.ticket_hub.api.DTOs.requests.booking;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DeleteBookingRequest(
        @NotNull UUID id,
        @NotNull UUID eventId,
        @NotNull UUID customerId
) {
}
