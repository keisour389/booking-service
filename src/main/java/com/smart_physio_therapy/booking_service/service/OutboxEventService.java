package com.smart_physio_therapy.booking_service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.smart_physio_therapy.booking_service.helper.OutboxEventHelper;
import com.smart_physio_therapy.booking_service.model.Booking;
import com.smart_physio_therapy.booking_service.respository.OutboxEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OutboxEventService {
    private final OutboxEventRepository outboxEventRepository;

    private final OutboxEventHelper outboxEventHelper;

    public void saveOutboxEvent(Booking booking) throws JsonProcessingException {
        outboxEventRepository.save(outboxEventHelper.createOutboxEvent(booking));
    }
}
