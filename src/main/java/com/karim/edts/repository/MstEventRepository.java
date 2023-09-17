package com.karim.edts.repository;

import com.karim.edts.entity.MstEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MstEventRepository extends JpaRepository<MstEvent, Long> {

    @Query("select e from MstEvent e where e.status = ?1 ")
    List<MstEvent> findAllByStatus(int status);

    @Query("select e from MstEvent e where e.eventName like %?1% or e.eventDescription like %?1% ")
    List<MstEvent> findByEventName(String eventName);
}
