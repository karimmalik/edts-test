package com.karim.edts.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class TrxEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trxEventId;
    private Long artistId;
    private Long eventId;
    private Long eventDetailId;
    private Long userId;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date purchaseDate;
    private int numberOfPurchase;
    private String remark;
    private int status;
    private Date createdDate;
    private String createdBy;
    private Date lastUpdatedDate;
    private String lastUpdatedBy;

}
