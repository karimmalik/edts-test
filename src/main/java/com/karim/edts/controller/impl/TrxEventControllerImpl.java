package com.karim.edts.controller.impl;

import com.karim.edts.controller.TrxEventController;
import com.karim.edts.entity.TrxEvent;
import com.karim.edts.service.TrxEventservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trx")
public class TrxEventControllerImpl implements TrxEventController {

    @Autowired
    TrxEventservice trxEventservice;

    @GetMapping("/findByUserId/{id}")
    @Override
    public ResponseEntity<?> findByUserId(@PathVariable Long id) {
        return ResponseEntity.ok().body(trxEventservice.findByUserId(id));

    }

    @PostMapping("/insertTrxEvent")
    @Override
    public ResponseEntity<?> insertTrxEvent(@RequestBody TrxEvent trxEvent) {
        return ResponseEntity.ok().body(trxEventservice.insertTrxEvent(trxEvent));

    }

    @GetMapping("/findByEventId")
    @Override
    public ResponseEntity<?> findByEventId(Long id) {
        return ResponseEntity.ok().body(trxEventservice.findByEventId(id));

    }
}
