package com.bernardomecabo.ticket_hub.api.DTOs.requests.booking;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateBookingRequest(
        @NotNull UUID eventId,
        @NotNull UUID userId,
        @NotBlank String seatNumber,
        @Positive BigDecimal price
        ) {
}
