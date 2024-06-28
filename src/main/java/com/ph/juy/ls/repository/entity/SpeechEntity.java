package com.ph.juy.ls.repository.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

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
    @OneToMany(mappedBy = "speech", cascade = CascadeType.ALL)
    private List<KeywordEntity> keywords;

}
