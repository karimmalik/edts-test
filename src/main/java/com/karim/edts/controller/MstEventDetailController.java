package com.karim.edts.controller;

import com.karim.edts.entity.MstEventDetail;
import org.springframework.http.ResponseEntity;

public interface MstEventDetailController {

    ResponseEntity<?> insertMstEventDetail(MstEventDetail mstEventDetail);

    ResponseEntity<?> findByEventDetailId(Long id);

    ResponseEntity<?> findByEventId(Long id);

}
