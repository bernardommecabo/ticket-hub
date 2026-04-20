package com.bernardomecabo.ticket_hub.api.DTOs.responses.booking;

import com.bernardomecabo.ticket_hub.infrastructure.persistence.mongo.documents.BookingProjection;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record BookingListResponse(
        String seatId,
        String status,
        BigDecimal price,
        LocalDateTime createdAt,
        LocalDateTime lastUpdated
) {
    public BookingListResponse(BookingProjection projection){
        this(projection.getSeatId(),projection.getStatus(),projection.getPrice(),projection.getCreatedAt(),projection.getLastUpdated());
    }
}
