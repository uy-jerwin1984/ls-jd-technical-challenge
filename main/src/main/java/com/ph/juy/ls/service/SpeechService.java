package com.ph.juy.ls.service;

import com.ph.juy.ls.mappers.SpeechMapper;
import com.ph.juy.ls.model.Speech;
import com.ph.juy.ls.repository.SpeechRepository;
import com.ph.juy.ls.repository.entity.SpeechEntity;
import com.ph.juy.ls.repository.specifications.SpeechSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpeechService {

    @Autowired
    private SpeechRepository speechRepository;

    @Autowired
    private SpeechMapper speechMapper;

    public Speech create(final Speech speech) {
        final SpeechEntity speechEntity = speechMapper.modelToEntity(speech);
        speechRepository.save(speechEntity);
        return speech;
    }

    public Speech findById(final String id) {
        final SpeechEntity speechEntity = speechRepository.findById(id).orElse(new SpeechEntity());
        return speechMapper.entityToModel(speechEntity);
    }

    public List<Speech> listAll() {
        final List<SpeechEntity> result = speechRepository.findAll();
        return speechMapper.entitiesToModel(result);
    }

    public List<Speech> query(final Speech speech) {
        final Specification<SpeechEntity> spec = Specification
                .where(SpeechSpecification.author(speech.getAuthor()))
                        .and(SpeechSpecification.content(speech.getContent()));

        final List<SpeechEntity> result = speechRepository.findAll(spec);
        return speechMapper.entitiesToModel(result);
    }

}
