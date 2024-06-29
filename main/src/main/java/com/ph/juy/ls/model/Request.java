package com.ph.juy.ls.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class Request<T> {

    @NotNull
    @Valid
    private T data;

}
