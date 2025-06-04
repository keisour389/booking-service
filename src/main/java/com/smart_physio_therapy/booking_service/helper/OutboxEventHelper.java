package com.smart_physio_therapy.booking_service.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart_physio_therapy.booking_service.model.Booking;
import com.smart_physio_therapy.booking_service.model.OutboxEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class OutboxEventHelper {
    private final ObjectMapper objectMapper;

    public OutboxEvent createOutboxEvent(Booking booking) throws JsonProcessingException {
        OutboxEvent event = new OutboxEvent();
        event.setAggregateType("Booking");
        event.setAggregateId(String.valueOf(booking.getId()));
        event.setEventType("BOOKING_CREATED");
        event.setPayload(objectMapper.writeValueAsString(booking));
        event.setCreatedAt(LocalDateTime.now());

        return event;
    }
}
