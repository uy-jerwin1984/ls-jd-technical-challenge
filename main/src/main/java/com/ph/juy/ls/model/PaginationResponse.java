package com.ph.juy.ls.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PaginationResponse<T> {

    private final List<T> items;
    private final Integer offset;
    private final Integer limit;
    @JsonProperty("total_pages")
    private final Integer totalPages;

    public static <T> PaginationResponse<T> wrap(final List<T> items,
                                                 Integer offset,
                                                 Integer limit,
                                                 Integer totalPages) {
        return new PaginationResponse<>(items, offset, limit, totalPages);
    }

}
