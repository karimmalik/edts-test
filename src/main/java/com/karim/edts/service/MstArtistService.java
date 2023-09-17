package com.karim.edts.service;

import com.karim.edts.entity.MstArtist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MstArtistService {

    List<MstArtist> getAllArtist();

    MstArtist insertArtist(MstArtist mstArtist);

    List<MstArtist> findByArtistName(String artistName);


}
