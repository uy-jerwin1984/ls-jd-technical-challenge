package com.ph.juy.ls.repository.specifications;

import com.ph.juy.ls.repository.entity.SpeechEntity;
import com.ph.juy.ls.repository.entity.SpeechEntity_;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class SpeechSpecification {

    public static Specification<SpeechEntity> author(final String author) {
        return (root, query, builder) -> builder.like(root.get(SpeechEntity_.AUTHOR), "%" + author + "%");
    }

    public static Specification<SpeechEntity> content(final String content) {
        return (root, query, builder) -> builder.like(root.get(SpeechEntity_.CONTENT), "%" + content + "%");
    }

    public static Specification<SpeechEntity> keyword(final String keyword) {
        return (root, query, builder) -> builder.like(root.get(SpeechEntity_.KEYWORD), "%" + keyword + "%");
    }

    public static Specification<SpeechEntity> authorDate(final LocalDate authorDate) {
        return (root, query, builder) -> builder.equal(root.get(SpeechEntity_.AUTHOR_DATE), authorDate);
    }

}
