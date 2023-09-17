package com.karim.edts.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class MstEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date eventDate;
    private String eventName;
    private String eventLocation;
    private String eventDescription;
    private Boolean status;
    private Date createdDate;
    private String createdBy;
    private Date lastUpdatedDate;
    private String lastUpdatedBy;
    private Long artistId;

}
