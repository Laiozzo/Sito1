package com.generation.sito1.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Data
public class Article extends BaseEntity
{

    String title;
    String synopsis;
    String content;
    LocalDate wroteOn;
    String tags;

    @ManyToOne
            @JoinColumn(name= "author_id")
    Author author;

    public String getCsv() {
        return tags;
    }

    public void setCsv(String csv) {
        this.tags = csv;
    }

}
