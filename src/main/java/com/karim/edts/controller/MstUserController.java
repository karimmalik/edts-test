package com.karim.edts.controller;

import com.karim.edts.entity.MstUser;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MstUserController {
    ResponseEntity<?> getUser();
    ResponseEntity<?> createUser(MstUser mstUser);
}
