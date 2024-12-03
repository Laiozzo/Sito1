package com.generation.sito1.controller.helper;

import com.generation.sito1.controller.helper.exception.InvalidCredentialsException;
import com.generation.sito1.model.entities.*;
import com.generation.sito1.model.repository.ArticleRepository;
import com.generation.sito1.model.repository.AuthorRepository;
import com.generation.sito1.model.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ControllerHelperImp implements ControllerHelper {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private ReaderRepository readerRepository;


    @Override
    public void saveReader(Reader reader) {
        readerRepository.save(reader);
    }

    @Override
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void saveArticle(Article article) {

    }

    @Override
    public Reader getReader(int id) {
        return readerRepository.findById(id).get();
    }

    @Override
    public Author getAuthor(int id) {
        return authorRepository.findById(id).get();
    }

    @Override
    public Article getArticle(int id) {
        return articleRepository.findById(id).get();
    }

    @Override
    public Article getArticle(String id) {
        return null;
    }

    @Override
    public Article getArticleTags(String tags) {
        return null;
    }

    @Override
    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public User getUserbyUP(String username, String password) {
        List<Author> allAuthors = authorRepository.findAll();
        for (Author a : allAuthors) {
            if(a.getUsername().equals(username) && a.getPassword().equals(password)) {
                return a;
            }
        }
        List<Reader> allReader = readerRepository.findAll();
        for (Reader r : allReader) {
            if(r.getUsername().equals(username) && r.getPassword().equals(password)) {
                return r;
            }
        }
        return null;
    }

    @Override
    public Reader getReaderByUP(String username, String password) {
        Reader reader = null;
        List<Reader> all = readerRepository.findAll();
        for (Reader r : all) {
            if(r.getUsername().equals(username) && r.getPassword().equals(password)) {
                reader = r;
            }
        }
        if(reader == null) {
            throw new InvalidCredentialsException("Username or password is incorrect");
        }
        return reader;
    }

    @Override
    public Author getAuthorByUP(String username, String password) {
        Author author = null;
        List<Author> all = authorRepository.findAll();
        for (Author a : all) {
            if(a.getUsername().equals(username) && a.getPassword().equals(password)) {
                author = a;
            }
        }
        if(author == null) {
            throw new InvalidCredentialsException("Username or password is incorrect");
        }
        return author;
    }

    @Override
    public void saveReader(String username, String password) {
        Reader reader = new Reader();
        reader.setUsername(username);
        reader.setPassword(password);
        reader.setSubscriptionType(SubscriptionType.FREE);
    }
}
