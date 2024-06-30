package com.ph.juy.ls.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

    private final T data;
    private final Instant timestamp;

    public static <T> Response<T> wrapObject(T data) {
        return new Response<>(data, Instant.now());
    }

}
