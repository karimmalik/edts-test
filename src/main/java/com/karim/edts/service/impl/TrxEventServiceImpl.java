package com.karim.edts.service.impl;

import com.karim.edts.Enum.Response;
import com.karim.edts.entity.*;
import com.karim.edts.repository.*;
import com.karim.edts.service.TrxEventservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TrxEventServiceImpl implements TrxEventservice {

    @Autowired
    TrxEventRepository trxEventRepository;

    @Autowired
    MstUserRepository mstUserRepository;

    @Autowired
    MstArtistRepository mstArtistRepository;

    @Autowired
    MstEventDetailRepository mstEventDetailRepository;

    @Autowired
    MstEventRepository mstEventRepository;

    @Override
    public ResponseEntity<?> findByEventId(Long id) {
        Optional<TrxEvent> optionalTrxEvent = trxEventRepository.findById(id);
        if (optionalTrxEvent.isPresent()) {
            TrxEvent trxEvent = optionalTrxEvent.get();
            return new ResponseEntity<>(trxEvent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Response.NO_DATA, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> findByUserId(Long id) {
        List<TrxEvent> trxEventList = trxEventRepository.findTrxEventByUserId(id);
        if (trxEventList != null) {
            return new ResponseEntity<>(trxEventList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Response.NO_DATA, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<?> insertTrxEvent(TrxEvent trxEvent) {

        // check validity event
        MstEvent mstEvent = null;
        Optional<MstEvent> optionalMstEvent = mstEventRepository.findById(trxEvent.getEventId());
        if (!optionalMstEvent.isPresent()) {
            return new ResponseEntity<>("invalid event id", HttpStatus.BAD_REQUEST);
        } else {
            mstEvent = optionalMstEvent.get();
        }

        // check availability
        MstEventDetail mstEventDetail = null;
        Optional<MstEventDetail> optionalMstEventDetail = mstEventDetailRepository.findById(trxEvent.getEventDetailId());
        if (optionalMstEventDetail.isPresent()) {
            mstEventDetail = optionalMstEventDetail.get();
            if (mstEventDetail.getEventQuote() < trxEvent.getNumberOfPurchase()) {
                return new ResponseEntity<>("number of ticket purchase is more than ticket availability", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("invalid event detail id", HttpStatus.BAD_REQUEST);

        }

        // check explicit
        Optional<MstArtist> optionalMstArtist = mstArtistRepository.findById(trxEvent.getArtistId());
        if (optionalMstArtist.isPresent()) {
            MstArtist mstArtist = optionalMstArtist.get();
            if (mstArtist.getArtistExplicit()) {
                Optional<MstUser> optionalMstUser = mstUserRepository.findById(trxEvent.getUserId());
                if (optionalMstUser.isPresent()) {
                    MstUser mstUser = optionalMstUser.get();

                    DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
                    int d1 = Integer.parseInt(formatter.format(mstUser.getUserBirthdate()));
                    int d2 = Integer.parseInt(formatter.format(new Date()));
                    int age = (d2 - d1) / 10000;

                    if (age < 17) {
                        return new ResponseEntity<>("user age is below 17", HttpStatus.BAD_REQUEST);
                    }
                }
            }
        } else {
            return new ResponseEntity<>("invalid artist detail id", HttpStatus.BAD_REQUEST);
        }

        // update the remaining ticket
        mstEventDetail.setEventQuote(mstEventDetail.getEventQuote() - trxEvent.getNumberOfPurchase());
        if (mstEventDetail.getEventQuote() - trxEvent.getNumberOfPurchase() <= 0) {
            mstEventDetail.setStatus(0);
        } else {
            mstEventDetail.setStatus(1);
        }
        mstEventDetailRepository.save(mstEventDetail);

        // check and update if all detail id status is 0
        List<MstEventDetail> optionalMstEventDetail1 = mstEventDetailRepository.findByStatus();
        if (optionalMstEventDetail1.size() <= 0) {
            mstEvent.setStatus(false);
            mstEventRepository.save(mstEvent);
        }

        // all validate passed. proceed to purchase ticket
        trxEvent.setPurchaseDate(new Date());
        trxEvent.setCreatedBy("system");
        trxEvent.setCreatedDate(new Date());
        trxEvent.setLastUpdatedBy("system");
        trxEvent.setLastUpdatedDate(new Date());
        trxEvent = trxEventRepository.save(trxEvent);
        return new ResponseEntity<>(trxEvent, HttpStatus.OK);
    }

}
