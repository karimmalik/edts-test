package com.karim.edts.repository;

import com.karim.edts.entity.TrxEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrxEventRepository extends JpaRepository<TrxEvent, Long> {

    @Query("select e from TrxEvent e where e.userId = ?1")
    List<TrxEvent> findTrxEventByUserId(Long userId);

}
