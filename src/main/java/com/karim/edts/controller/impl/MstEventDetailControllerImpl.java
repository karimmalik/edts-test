package com.karim.edts.controller.impl;

import com.karim.edts.controller.MstEventDetailController;
import com.karim.edts.entity.MstEventDetail;
import com.karim.edts.service.MstEventDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eventDetail")
public class MstEventDetailControllerImpl implements MstEventDetailController {

    @Autowired
    MstEventDetailService mstEventDetailService;

    @PostMapping("/insertMstEventDetail")
    @Override
    public ResponseEntity<?> insertMstEventDetail(@RequestBody MstEventDetail mstEventDetail) {
        return ResponseEntity.ok().body(mstEventDetailService.insertMstEventDetail(mstEventDetail));
    }

    @Override
    @GetMapping("/findByEventDetailId/{id}")
    public ResponseEntity<?> findByEventDetailId(@PathVariable Long id) {
        return ResponseEntity.ok().body(mstEventDetailService.findByEventDetailId(id));

    }

    @Override
    public ResponseEntity<?> findByEventId(Long id) {
        return ResponseEntity.ok().body(mstEventDetailService.findByEventId(id));

    }

}
