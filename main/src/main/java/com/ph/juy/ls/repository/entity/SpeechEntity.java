package com.ph.juy.ls.repository.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity(name = "speech")
public class SpeechEntity extends BaseEntity {

    @Column
    private String author;
    @Column
    private String content;
    @Column
    private String keyword;

}