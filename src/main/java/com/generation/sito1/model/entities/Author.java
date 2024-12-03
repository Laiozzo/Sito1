package com.generation.sito1.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Author extends User
{
    @OneToMany(mappedBy = "author")
    private Set<Article> articleSet;

    public Set<Article> getArticleSet() {
        return articleSet;
    }

    public void setArticleSet(Set<Article> articleSet) {
        this.articleSet = articleSet;
    }
}
