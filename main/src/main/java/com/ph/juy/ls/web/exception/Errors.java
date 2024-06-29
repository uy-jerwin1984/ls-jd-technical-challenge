package com.ph.juy.ls.web.exception;

import lombok.Getter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Errors {

    private final List<Error> errors = new ArrayList<>();
    private final Instant timestamp = Instant.now();

    public void addError(Error error) {
        errors.add(error);
    }
    
}
