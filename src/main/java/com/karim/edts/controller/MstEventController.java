package com.karim.edts.controller;

import com.karim.edts.entity.MstEvent;
import org.springframework.http.ResponseEntity;

public interface MstEventController {
    ResponseEntity<?> findAll();

    ResponseEntity<?> findAllByStatus();

    ResponseEntity<?> findByEventName(String eventName);

    ResponseEntity<?> insertEvent(MstEvent mstEvent);
}
