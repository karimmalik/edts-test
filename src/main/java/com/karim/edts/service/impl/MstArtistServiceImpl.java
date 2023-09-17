package com.karim.edts.service.impl;

import com.karim.edts.entity.MstArtist;
import com.karim.edts.repository.MstArtistRepository;
import com.karim.edts.service.MstArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MstArtistServiceImpl implements MstArtistService {

    @Autowired
    MstArtistRepository mstArtistRepository;

    @Override
    public List<MstArtist> getAllArtist() {
        List<MstArtist> mstArtistList = mstArtistRepository.findAll();
        return mstArtistList;
    }

    @Override
    public List<MstArtist> findByArtistName(String artistName) {
        List<MstArtist> mstArtistList = mstArtistRepository.findByArtistName(artistName);
        return mstArtistList;
    }

    @Override
    public MstArtist insertArtist(MstArtist mstArtist) {
        Date date = new Date();
        mstArtist.setStatus(1);
        mstArtist.setCreatedBy("system");
        mstArtist.setCreatedDate(date);
        mstArtist.setLastUpdatedBy("system");
        mstArtist.setLastUpdatedDate(date);
        mstArtist = mstArtistRepository.save(mstArtist);
        return mstArtist;
    }

}
