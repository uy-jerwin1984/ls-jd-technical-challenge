package com.ph.juy.ls.repository.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@MappedSuperclass
@EqualsAndHashCode
@Data
@NoArgsConstructor
public abstract class BaseEntity {
    
    @Id
    @EqualsAndHashCode.Include
    @ToString.Include
    protected String id;
    @CreationTimestamp
    @Column(name = "created_time", updatable = false)
    protected Instant createdTime;
    @UpdateTimestamp
    @Column(name = "updated_time")
    protected Instant updatedTime;

}
