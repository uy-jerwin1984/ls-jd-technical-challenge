package com.ph.juy.ls.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Speech extends Base {

    @NotBlank
    private String author;
    @NotBlank
    private String content;
    @NotBlank
    private String keyword;
    @NotNull
    @JsonProperty("author_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    // TODO how will bean validation know this annotation versus property path based on reflection?
    private LocalDate authorDate;

}
