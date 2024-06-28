package com.ph.juy.ls.repository.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "keyword")
public class KeywordEntity extends BaseEntity {

    @Column
    private String value;
    @ManyToOne
    @JoinColumn(name = "speech_id", nullable = false)
    private SpeechEntity speech;
}
