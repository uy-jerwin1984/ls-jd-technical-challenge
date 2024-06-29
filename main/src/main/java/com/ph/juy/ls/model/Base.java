package com.ph.juy.ls.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Id;
import java.time.Instant;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Base {

    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    protected String id;
    @JsonProperty("created_time")
    protected Instant createdTime;
    @JsonProperty("updated_time")
    protected Instant updatedTime;

}
