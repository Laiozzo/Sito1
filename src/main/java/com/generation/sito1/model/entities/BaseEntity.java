package com.generation.sito1.model.entities;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class  BaseEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
