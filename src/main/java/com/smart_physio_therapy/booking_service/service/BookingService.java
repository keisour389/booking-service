package com.smart_physio_therapy.booking_service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.smart_physio_therapy.booking_service.model.Booking;
import com.smart_physio_therapy.booking_service.respository.BookingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;

    private final OutboxEventService outboxEventService;

    @Transactional
    public Booking createBooking(Booking booking) throws JsonProcessingException {
        booking.setStatus("CREATED");
        Booking bookingSaved = bookingRepository.save(booking);

        outboxEventService.saveOutboxEvent(bookingSaved);

        return bookingSaved;
    }
}
