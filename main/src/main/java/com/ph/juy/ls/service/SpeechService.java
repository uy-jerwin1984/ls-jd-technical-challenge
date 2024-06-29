package com.ph.juy.ls.service;

import com.ph.juy.ls.mappers.SpeechMapper;
import com.ph.juy.ls.model.Speech;
import com.ph.juy.ls.repository.SpeechRepository;
import com.ph.juy.ls.repository.entity.SpeechEntity;
import com.ph.juy.ls.repository.specifications.SpeechSpecification;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Speech> query(final Speech speech) {
        Specification<SpeechEntity> spec = Specification.where(null);
        if (StringUtils.isNotBlank(speech.getAuthor())) {
            spec = spec.and(SpeechSpecification.author(speech.getAuthor()));
        }
        if (StringUtils.isNotBlank(speech.getContent())) {
            spec = spec.and(SpeechSpecification.content(speech.getContent()));
        }
        if (speech.getAuthorDate() != null) {
            spec = spec.and(SpeechSpecification.authorDate(speech.getAuthorDate()));
        }
        if (StringUtils.isNotBlank(speech.getKeyword())) {
            spec = spec.and(SpeechSpecification.keyword(speech.getKeyword()));
        }
        final List<SpeechEntity> result = speechRepository.findAll(spec);
        return speechMapper.entitiesToModel(result);
    }

}
