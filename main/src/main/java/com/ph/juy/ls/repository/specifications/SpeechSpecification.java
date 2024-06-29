package com.ph.juy.ls.repository.specifications;

import com.ph.juy.ls.repository.entity.SpeechEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class SpeechSpecification {

    public static Specification<SpeechEntity> author(final String author) {
        if (StringUtils.isBlank(author)) {
            return null;
        }
        return (root, query, builder) -> builder.like(root.get("author"), author);
    }

    public static Specification<SpeechEntity> content(final String content) {
        if (StringUtils.isBlank(content)) {
            return null;
        }
        return (root, query, builder) -> builder.like(root.get("content"), content);
    }

}
