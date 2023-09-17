package com.karim.edts.repository;

import com.karim.edts.entity.MstEventDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MstEventDetailRepository extends JpaRepository<MstEventDetail, Long> {

    @Query("select e from MstEventDetail e where e.status = 1")
    List<MstEventDetail> findByStatus();

}
