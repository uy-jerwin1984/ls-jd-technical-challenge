package com.ph.juy.ls.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Keyword extends Base {

    private String value;

}
