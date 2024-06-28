package com.ph.juy.ls.service;

import com.ph.juy.ls.mappers.SpeechMapper;
import com.ph.juy.ls.model.Speech;
import com.ph.juy.ls.repository.SpeechRepository;
import com.ph.juy.ls.repository.entity.KeywordEntity;
import com.ph.juy.ls.repository.entity.SpeechEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SpeechService {

    @Autowired
    private SpeechRepository speechRepository;

    @Autowired
    private SpeechMapper speechMapper;

    public Speech create(final Speech speech) {
        final SpeechEntity speechEntity = speechMapper.modelToEntity(speech);
        final List<KeywordEntity> keywords = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            final KeywordEntity keywordEntity = new KeywordEntity();
            keywordEntity.setId(UUID.randomUUID().toString());
            keywordEntity.setSpeech(speechEntity);
            keywordEntity.setValue(UUID.randomUUID().toString());
            keywords.add(keywordEntity);
        }
        speechEntity.setKeywords(keywords);
        speechRepository.save(speechEntity);
        return speech;
    }

}
