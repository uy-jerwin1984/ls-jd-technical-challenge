package com.ph.juy.ls.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Speech extends Base {

    @NotBlank
    private String author;
    @NotBlank
    private String content;
    @NotBlank
    private String keyword;
    @NotNull
    @JsonProperty("author_date")
    private Instant authorDate;

}
