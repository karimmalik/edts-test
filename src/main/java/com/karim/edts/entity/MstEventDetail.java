package com.karim.edts.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class MstEventDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventDetailId;
    private Long eventId;
    private int eventPrice;
    private String eventCategoryName;
    private Long eventQuote;
    private int status;
    private Date createdDate;
    private String createdBy;
    private Date lastUpdatedDate;
    private String lastUpdatedBy;
}
