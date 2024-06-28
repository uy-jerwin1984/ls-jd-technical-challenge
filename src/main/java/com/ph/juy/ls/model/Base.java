package com.ph.juy.ls.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.Instant;

@Data
public class Base {

    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    protected String id;
    protected Instant createdTime;
    protected Instant updatedTime;

}
