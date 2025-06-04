package com.smart_physio_therapy.booking_service.respository;

import com.smart_physio_therapy.booking_service.model.OutboxEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutboxEventRepository extends JpaRepository<OutboxEvent, Long> {
}
