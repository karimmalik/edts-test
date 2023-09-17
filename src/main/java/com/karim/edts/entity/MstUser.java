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
public class MstUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String userPassword;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date userBirthdate;

    private int status;
    private Date createdDate;
    private String createdBy;
    private Date lastUpdatedDate;
    private String lastUpdatedBy;


}
