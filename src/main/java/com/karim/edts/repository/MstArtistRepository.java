package com.karim.edts.repository;

import com.karim.edts.entity.MstArtist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MstArtistRepository extends JpaRepository<MstArtist, Long> {
    List<MstArtist> findByArtistName(String artistName);
}
