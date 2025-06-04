package com.smart_physio_therapy.booking_service.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.smart_physio_therapy.booking_service.model.Booking;
import com.smart_physio_therapy.booking_service.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bookings")
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) throws JsonProcessingException {
        Booking saved = bookingService.createBooking(booking);
        return ResponseEntity.ok(saved);
    }
}
