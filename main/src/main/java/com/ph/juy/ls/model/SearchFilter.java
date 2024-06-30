package com.ph.juy.ls.model;

import lombok.Data;

@Data
public final class SearchFilter<T> {

    private final T data;
    private final PaginationRequest page;

}
