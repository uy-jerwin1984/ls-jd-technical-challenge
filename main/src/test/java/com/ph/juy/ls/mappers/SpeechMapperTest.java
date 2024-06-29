package com.ph.juy.ls.mappers;

import com.ph.juy.ls.model.Speech;
import com.ph.juy.ls.repository.entity.SpeechEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.util.UUID;

public class SpeechMapperTest {

    private final SpeechMapper mapper = Mappers.getMapper(SpeechMapper.class);

    @Test
    public void should_map_speech_with_id() {
        final Speech speech = new Speech();
        speech.setId(UUID.randomUUID().toString());
        speech.setAuthor(UUID.randomUUID().toString());
        speech.setContent(UUID.randomUUID().toString());
        speech.setKeyword(UUID.randomUUID().toString());
        speech.setAuthorDate(LocalDate.now());

        final SpeechEntity speechEntity = mapper.modelToEntity(speech);
        Assertions.assertEquals(speechEntity.getId(), speech.getId());
        Assertions.assertEquals(speechEntity.getAuthor(), speech.getAuthor());
        Assertions.assertEquals(speechEntity.getContent(), speech.getContent());
        Assertions.assertEquals(speechEntity.getKeyword(), speech.getKeyword());
        Assertions.assertEquals(speechEntity.getAuthorDate(), speech.getAuthorDate());
    }

    @Test
    public void should_map_speech_without_id() {
        final Speech speech = new Speech();
        speech.setAuthor(UUID.randomUUID().toString());
        speech.setContent(UUID.randomUUID().toString());
        speech.setKeyword(UUID.randomUUID().toString());
        speech.setAuthorDate(LocalDate.now());

        final SpeechEntity speechEntity = mapper.modelToEntity(speech);
        Assertions.assertNotNull(speechEntity.getId());
        Assertions.assertEquals(speechEntity.getAuthor(), speech.getAuthor());
        Assertions.assertEquals(speechEntity.getContent(), speech.getContent());
        Assertions.assertEquals(speechEntity.getKeyword(), speech.getKeyword());
        Assertions.assertEquals(speechEntity.getAuthorDate(), speech.getAuthorDate());
    }

}
