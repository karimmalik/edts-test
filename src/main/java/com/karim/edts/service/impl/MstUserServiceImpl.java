package com.karim.edts.service.impl;

import com.karim.edts.entity.MstUser;
import com.karim.edts.repository.MstUserRepository;
import com.karim.edts.service.MstUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MstUserServiceImpl implements MstUserService {

    @Autowired
    MstUserRepository mstUserRepository;

    @Override
    public List<MstUser> getAllUser() {
        List<MstUser> mstUserList = mstUserRepository.findAll();
        return mstUserList;
    }

    @Override
    public MstUser createUser(MstUser mstUser) {
        mstUser.setStatus(1);
        mstUser.setCreatedBy("system");
        mstUser.setCreatedDate(new Date());
        mstUser.setLastUpdatedBy("system");
        mstUser.setLastUpdatedDate(new Date());
        return mstUserRepository.save(mstUser);
    }
}
