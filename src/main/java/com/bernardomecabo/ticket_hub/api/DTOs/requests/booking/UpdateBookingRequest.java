package com.bernardomecabo.ticket_hub.api.DTOs.requests.booking;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UpdateBookingRequest(
        @NotNull UUID id,
        @NotNull UUID eventId,
        @NotNull UUID customerId,
        @NotEmpty String seatId
) {
}
