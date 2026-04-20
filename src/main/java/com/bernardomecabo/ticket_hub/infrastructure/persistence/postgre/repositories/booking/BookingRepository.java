package com.bernardomecabo.ticket_hub.infrastructure.persistence.postgre.repositories.booking;

import com.bernardomecabo.ticket_hub.domain.booking.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookingRepository extends JpaRepository<Booking, UUID> {
}
