package com.karim.edts.controller;

import com.karim.edts.entity.MstArtist;
import org.springframework.http.ResponseEntity;

public interface MstArtistController {

    ResponseEntity<?> getAllArtist();

    ResponseEntity<?> insertArtist(MstArtist mstArtist);

    ResponseEntity<?> findByArtistName(String artistName);
}
