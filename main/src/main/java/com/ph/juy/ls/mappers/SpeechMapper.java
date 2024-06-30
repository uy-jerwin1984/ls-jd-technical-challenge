package com.ph.juy.ls.mappers;

import com.ph.juy.ls.model.Speech;
import com.ph.juy.ls.repository.entity.SpeechEntity;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface SpeechMapper {

    @Mapping(target = "id", expression = "java(mapId(source))")
    SpeechEntity modelToEntity(final Speech source);

    Speech entityToModel(final SpeechEntity source);

    List<Speech> entitiesToModel(final List<SpeechEntity> source);

    default String mapId(Speech source) {
        if (StringUtils.isNotBlank(source.getId())) {
            return source.getId();
        }
        return UUID.randomUUID().toString();
    }

}
