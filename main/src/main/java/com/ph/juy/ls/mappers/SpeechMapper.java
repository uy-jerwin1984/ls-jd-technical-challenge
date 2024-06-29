package com.ph.juy.ls.mappers;

import com.ph.juy.ls.model.Speech;
import com.ph.juy.ls.repository.entity.SpeechEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SpeechMapper {

    SpeechEntity modelToEntity(Speech source);

    Speech entityToModel(SpeechEntity source);

}
