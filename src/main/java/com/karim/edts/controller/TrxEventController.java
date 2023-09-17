package com.karim.edts.controller;

import com.karim.edts.entity.TrxEvent;
import org.springframework.http.ResponseEntity;

public interface TrxEventController {

    ResponseEntity<?> insertTrxEvent(TrxEvent trxEvent);

    ResponseEntity<?> findByEventId(Long id);

    ResponseEntity<?> findByUserId(Long id);

}
