package com.bernardomecabo.ticket_hub.application.commands.booking;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateBookingCommand(
        UUID eventId,
        UUID userId,
        String seatNumber,
        BigDecimal price
) {
}
