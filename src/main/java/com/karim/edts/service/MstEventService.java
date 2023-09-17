package com.karim.edts.service;

import com.karim.edts.entity.MstEvent;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface MstEventService {

    ResponseEntity<?> findAll();

    ResponseEntity<?> findAllByStatus();

    ResponseEntity<?> findByEventName(String eventName);

    ResponseEntity<?> insertEvent(MstEvent mstEvent);

}
