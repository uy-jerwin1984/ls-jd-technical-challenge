package com.ph.juy.ls.model;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Response<T> {

    private T data;
    private List<T> items = new ArrayList<>();
    private Instant timestamp = Instant.now();

    public static <T> Response<T> wrapObject(T data) {
        final Response<T> response = new Response<>();
        response.setData(data);
        return response;
    }

    public static <T> Response<T> wrapList(List<T> items) {
        final Response<T> response = new Response<>();
        response.setItems(items);
        return response;
    }
}
