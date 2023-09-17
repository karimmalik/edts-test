package com.karim.edts.service;

import com.karim.edts.entity.TrxEvent;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface TrxEventservice {

    ResponseEntity<?> findByEventId(Long id);

    ResponseEntity<?> findByUserId(Long id);

    ResponseEntity<?> insertTrxEvent(TrxEvent trxEvent);


}
