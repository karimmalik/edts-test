package com.karim.edts.repository;

import com.karim.edts.entity.MstUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MstUserRepository extends JpaRepository<MstUser, Long> {
}
