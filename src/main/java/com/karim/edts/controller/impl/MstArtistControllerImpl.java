package com.karim.edts.controller.impl;

import com.karim.edts.controller.MstArtistController;
import com.karim.edts.entity.MstArtist;
import com.karim.edts.entity.MstEventDetail;
import com.karim.edts.service.MstArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/artist")
public class MstArtistControllerImpl implements MstArtistController {

    @Autowired
    MstArtistService mstArtistService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<?> getAllArtist() {
        List<MstArtist> mstArtistList = mstArtistService.getAllArtist();
        return new ResponseEntity<>(mstArtistList, HttpStatus.OK);
    }

    @PostMapping(value = "/insertArtist")
    public ResponseEntity<?> insertArtist(@RequestBody MstArtist mstArtist) {
        mstArtist = mstArtistService.insertArtist(mstArtist);
        return new ResponseEntity<>(mstArtist, HttpStatus.OK);
    }

    @GetMapping(value = "/findByArtistName/{artistName}")
    @Override
    public ResponseEntity<?> findByArtistName(@PathVariable(value = "artistName") String artistName) {
        List<MstArtist> mstArtist = mstArtistService.findByArtistName(artistName);
        return new ResponseEntity<>(mstArtist, HttpStatus.OK);
    }

}
