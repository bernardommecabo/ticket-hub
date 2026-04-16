package com.bernardomecabo.ticket_hub.api.DTOs.responses.booking;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateBookingResponse(
        UUID eventId,
        String seatNumber,
        BigDecimal price
) {
}
