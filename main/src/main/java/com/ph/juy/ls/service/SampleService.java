package com.ph.juy.ls.service;

import com.ph.juy.ls.repository.SampleRepository;
import com.ph.juy.ls.repository.entity.SampleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SampleService {

    @Autowired
    private SampleRepository sampleRepository;

    public SampleEntity create() {
        final SampleEntity sampleEntity = new SampleEntity();
        sampleEntity.setName(UUID.randomUUID().toString());
        sampleEntity.setValue(UUID.randomUUID().toString());
        sampleRepository.save(sampleEntity);
        return sampleEntity;
    }

}
