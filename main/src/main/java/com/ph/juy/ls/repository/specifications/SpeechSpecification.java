package com.ph.juy.ls.repository.specifications;

import com.ph.juy.ls.repository.entity.SpeechEntity;
import org.springframework.data.jpa.domain.Specification;

import java.time.Instant;

public class SpeechSpecification {

    public static Specification<SpeechEntity> author(final String author) {
        return (root, query, builder) -> builder.like(root.get("author"), "%" + author + "%");
    }

    public static Specification<SpeechEntity> content(final String content) {
        return (root, query, builder) -> builder.like(root.get("content"), "%" + content + "%");
    }

    public static Specification<SpeechEntity> authorDate(final Instant authorDate) {
        return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get("authorDate"), authorDate);
    }

    public static Specification<SpeechEntity> keyword(final String keyword) {
        return (root, query, builder) -> builder.like(root.get("keyword"), "%" + keyword + "%");
    }


}
