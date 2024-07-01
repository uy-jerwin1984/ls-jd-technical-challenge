package com.ph.juy.ls.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaginationRequest {

    private final Integer page;
    private final Integer size;

}
