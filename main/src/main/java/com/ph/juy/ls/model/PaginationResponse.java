package com.ph.juy.ls.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PaginationResponse<T> {

    private final List<T> items;
    private final Integer current;
    private final Integer size;
    private final Integer totalPages;
    private final Long totalSize;

    public static <T> PaginationResponse<T> wrap(final List<T> items,
                                                 Integer current,
                                                 Integer size,
                                                 Integer totalPages,
                                                 Long totalSize) {
        return new PaginationResponse<>(items, current, size, totalPages, totalSize);
    }

}
