package com.karim.edts.controller.impl;

import com.karim.edts.controller.MstUserController;
import com.karim.edts.entity.MstUser;
import com.karim.edts.service.MstUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class MstUserControllerImpl implements MstUserController {

    @Autowired
    MstUserService mstUserService;

    @GetMapping(value = "/")
    public ResponseEntity<?> getUser() {
        List<MstUser> mstUserList = mstUserService.getAllUser();
        return new ResponseEntity<>(mstUserList, HttpStatus.OK);
    }


    @PostMapping(value = "/createUser")
    public ResponseEntity<?> createUser(@RequestBody MstUser mstUser) {
        return new ResponseEntity<>(mstUserService.createUser(mstUser), HttpStatus.OK);
    }

}
