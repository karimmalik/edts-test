package com.karim.edts.service;

import com.karim.edts.entity.MstUser;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface MstUserService {

    List<MstUser> getAllUser();
    MstUser createUser(MstUser mstUser);
}
