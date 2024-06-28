package com.ph.juy.ls.model;

import com.ph.juy.ls.repository.entity.KeywordEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Speech extends Base {

    private String author;
    private String content;
    private List<KeywordEntity> keywords;
}
