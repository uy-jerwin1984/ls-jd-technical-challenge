package com.ph.juy.ls.repository;

import com.ph.juy.ls.repository.entity.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleRepository extends JpaRepository<SampleEntity, Integer> {

}
