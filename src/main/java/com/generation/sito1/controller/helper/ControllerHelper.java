package com.generation.sito1.controller.helper;

import com.generation.sito1.model.entities.Article;
import com.generation.sito1.model.entities.Author;
import com.generation.sito1.model.entities.Reader;
import com.generation.sito1.model.entities.User;

import java.util.List;

public interface ControllerHelper
{
    void saveReader(Reader reader);
    void saveAuthor(Author author);
    void saveArticle(Article article);

    Reader getReader(int id);
    Author getAuthor(int id);
    Article getArticle(int id);
    Article getArticle(String id);
    Article getArticleTags(String tags);

    List<Reader> getAllReaders();
    List<Author> getAllAuthors();
    List<Article> getAllArticles();

    User getUserbyUP(String username, String password);
    Reader getReaderByUP(String username, String password);
    Author getAuthorByUP(String username, String password);

    void saveReader(String username, String password);
}
