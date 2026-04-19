package com.bernardomecabo.ticket_hub.api.DTOs.responses.booking;

import com.bernardomecabo.ticket_hub.domain.booking.Booking;

public record UpdateBookingResponse(
        String seatId
) {
    public UpdateBookingResponse(Booking booking){
        this("Seat updated to " + booking.getSeatId());
    }
}
