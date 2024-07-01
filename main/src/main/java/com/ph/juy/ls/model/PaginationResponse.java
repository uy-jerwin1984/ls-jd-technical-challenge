package com.ph.juy.ls.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PaginationResponse<T> {

    private final List<T> items;
    private final Integer page;
    private final Integer size;
    @JsonProperty("total_pages")
    private final Integer totalPages;

    public static <T> PaginationResponse<T> wrap(final List<T> items,
                                                 final Integer page,
                                                 final Integer size,
                                                 final Integer totalPages) {
        return new PaginationResponse<>(items, page, size, totalPages);
    }

}
