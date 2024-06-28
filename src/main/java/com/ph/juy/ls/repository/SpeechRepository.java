package com.ph.juy.ls.repository;

import com.ph.juy.ls.repository.entity.SpeechEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeechRepository extends JpaRepository<SpeechEntity, String> {

}
