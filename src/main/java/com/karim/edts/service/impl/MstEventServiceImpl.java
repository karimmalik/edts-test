package com.karim.edts.service.impl;

import com.karim.edts.Enum.Response;
import com.karim.edts.entity.MstEvent;
import com.karim.edts.repository.MstEventRepository;
import com.karim.edts.service.MstEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Service
public class MstEventServiceImpl implements MstEventService {

    @Autowired
    MstEventRepository mstEventRepository;

    @Override
    public ResponseEntity<?> findAll() {
        List<MstEvent> mstEventList = mstEventRepository.findAll();
        if (mstEventList.size() > 0) {
            return ResponseEntity.ok().body(mstEventList);
        } else {
            return ResponseEntity.ok().body(Response.NO_DATA);
        }
    }

    @Override
    public ResponseEntity<?> findAllByStatus() {
        List<MstEvent> mstEventList = mstEventRepository.findAllByStatus(1);
        if (mstEventList.size() > 0) {
            return ResponseEntity.ok().body(mstEventList);
        } else {
            return ResponseEntity.ok().body(Response.NO_DATA);
        }
    }

    @Override
    public ResponseEntity<?> findByEventName(String eventName) {
        List<MstEvent> mstEventList = mstEventRepository.findByEventName(eventName);
        if (mstEventList.size() > 0) {
            return ResponseEntity.ok().body(mstEventList);
        } else {
            return ResponseEntity.ok().body(Response.NO_DATA);
        }
    }

    @Override
    public ResponseEntity<?> insertEvent(MstEvent mstEvent) {
        mstEvent.setStatus(true);
        mstEvent.setCreatedBy("system");
        mstEvent.setCreatedDate(new Date());
        mstEvent.setLastUpdatedBy("system");
        mstEvent.setLastUpdatedDate(new Date());
        mstEvent = mstEventRepository.save(mstEvent);
        return ResponseEntity.ok().body(mstEvent);
    }
}
