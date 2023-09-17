package com.karim.edts.controller.impl;

import com.karim.edts.controller.MstEventController;
import com.karim.edts.entity.MstArtist;
import com.karim.edts.entity.MstEvent;
import com.karim.edts.service.MstEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event")
public class MstEventControllerImpl  implements MstEventController {

    @Autowired
    MstEventService mstEventService;

    @Override
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(mstEventService.findAll());
    }

    @Override
    @GetMapping("/findByStatus")
    public ResponseEntity<?> findAllByStatus() {
        return ResponseEntity.ok().body(mstEventService.findAll());
    }

    @Override
    @GetMapping("findByEventName/{eventName}")
    public ResponseEntity<?> findByEventName(@PathVariable(value = "eventName") String eventName) {
        return new ResponseEntity<>(mstEventService.findByEventName(eventName), HttpStatus.OK);
    }

    @Override
    @PostMapping("/insertEvent")
    public ResponseEntity<?> insertEvent(@RequestBody MstEvent mstEvent) {
        System.out.println("karim");
        return new ResponseEntity<>(mstEventService.insertEvent(mstEvent), HttpStatus.OK);
    }
}
