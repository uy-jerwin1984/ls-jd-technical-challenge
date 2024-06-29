package com.ph.juy.ls.service;

import com.ph.juy.ls.exceptions.SpeechNotFoundException;
import com.ph.juy.ls.mappers.SpeechMapper;
import com.ph.juy.ls.model.Speech;
import com.ph.juy.ls.repository.SpeechRepository;
import com.ph.juy.ls.repository.entity.SpeechEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class SpeechServiceTest {

    @Mock
    private SpeechMapper speechMapper;
    @Mock
    private SpeechRepository speechRepository;
    @InjectMocks
    private SpeechService speechService;

    @Test
    public void should_invoke_methods_on_save() {

        final Speech speech = new Speech();
        speech.setId(UUID.randomUUID().toString());
        final SpeechEntity speechEntity = new SpeechEntity();
        speechEntity.setId(speech.getId());

        Mockito.when(speechMapper.modelToEntity(Mockito.any(Speech.class))).thenReturn(speechEntity);
        Mockito.when(speechRepository.findById(Mockito.any(String.class))).thenReturn(Optional.of(speechEntity));
        Mockito.when(speechMapper.entityToModel(Mockito.any(SpeechEntity.class))).thenReturn(speech);

        final Speech result = speechService.create(speech);
        Assertions.assertEquals(speech.getId(), result.getId());
    }

    @Test
    public void should_invoke_methods_on_update_with_id() {

        final Speech speech = new Speech();
        speech.setId(UUID.randomUUID().toString());
        final SpeechEntity speechEntity = new SpeechEntity();
        speechEntity.setId(speech.getId());

        Mockito.when(speechMapper.modelToEntity(Mockito.any(Speech.class))).thenReturn(speechEntity);
        Mockito.when(speechRepository.findById(Mockito.any(String.class))).thenReturn(Optional.of(speechEntity));
        Mockito.when(speechMapper.entityToModel(Mockito.any(SpeechEntity.class))).thenReturn(speech);

        final Speech result = speechService.update(speech);
        Assertions.assertEquals(speech.getId(), result.getId());
    }

    @Test
    public void should_invoke_methods_on_update_without_id() {
        final Speech speech = new Speech();
        Assertions.assertThrows(SpeechNotFoundException.class, () -> speechService.update(speech));
    }

    @Test
    public void should_invoke_methods_on_delete_with_id() {

        final Speech speech = new Speech();
        speech.setId(UUID.randomUUID().toString());
        final SpeechEntity speechEntity = new SpeechEntity();
        speechEntity.setId(speech.getId());

        Mockito.when(speechRepository.findById(Mockito.any(String.class))).thenReturn(Optional.of(speechEntity));
        Mockito.when(speechMapper.entityToModel(Mockito.any(SpeechEntity.class))).thenReturn(speech);

        final Speech result = speechService.delete(speech.getId());
        Assertions.assertEquals(speech.getId(), result.getId());
    }

    @Test
    public void should_invoke_methods_on_delete_without_id() {
        Mockito.when(speechRepository.findById(Mockito.any(String.class))).thenReturn(Optional.empty());
        Assertions.assertThrows(SpeechNotFoundException.class, () -> speechService.delete(UUID.randomUUID().toString()));
    }
    
}
