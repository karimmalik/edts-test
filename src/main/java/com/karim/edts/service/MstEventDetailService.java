package com.karim.edts.service;

import com.karim.edts.entity.MstEventDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface MstEventDetailService {
    ResponseEntity<?> findByEventId(Long id);
    ResponseEntity<?> findByEventDetailId(Long id);

    ResponseEntity<?> insertMstEventDetail(MstEventDetail trxEvent);
}
