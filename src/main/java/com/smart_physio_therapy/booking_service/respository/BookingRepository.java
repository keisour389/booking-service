package com.smart_physio_therapy.booking_service.respository;

import com.smart_physio_therapy.booking_service.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
