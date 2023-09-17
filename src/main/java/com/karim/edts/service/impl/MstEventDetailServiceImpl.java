package com.karim.edts.service.impl;

import com.karim.edts.Enum.Response;
import com.karim.edts.entity.MstEvent;
import com.karim.edts.entity.MstEventDetail;
import com.karim.edts.repository.MstEventDetailRepository;
import com.karim.edts.repository.MstEventRepository;
import com.karim.edts.service.MstEventDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class MstEventDetailServiceImpl implements MstEventDetailService {

    @Autowired
    MstEventDetailRepository mstEventDetailRepository;

    @Autowired
    MstEventRepository mstEventRepository;

    @Override
    public ResponseEntity<?> findByEventId(Long id) {
        Optional<MstEventDetail> optionalMstEventDetail = mstEventDetailRepository.findById(id);
        if (optionalMstEventDetail.isPresent()) {
            MstEventDetail mstEventDetail = optionalMstEventDetail.get();
            return new ResponseEntity<>(mstEventDetail, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Response.NO_DATA, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> findByEventDetailId(Long id) {
        Optional<MstEventDetail> optionalMstEventDetail = mstEventDetailRepository.findById(id);
        if (optionalMstEventDetail.isPresent()) {
            MstEventDetail mstEventDetail = optionalMstEventDetail.get();
            return new ResponseEntity<>(mstEventDetail, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Response.NO_DATA, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> insertMstEventDetail(MstEventDetail mstEventDetail) {
        // validate event
        Optional<MstEvent> optionalMstEvent = mstEventRepository.findById(mstEventDetail.getEventId());
        if (!optionalMstEvent.isPresent()) {
            return new ResponseEntity<>(Response.NO_DATA, HttpStatus.BAD_REQUEST);
        }

        mstEventDetail.setStatus(1);
        mstEventDetail.setCreatedBy("system");
        mstEventDetail.setCreatedDate(new Date());
        mstEventDetail.setLastUpdatedBy("system");
        mstEventDetail.setLastUpdatedDate(new Date());
        mstEventDetail = mstEventDetailRepository.save(mstEventDetail);
        return new ResponseEntity<>(mstEventDetail, HttpStatus.OK);
    }
}
