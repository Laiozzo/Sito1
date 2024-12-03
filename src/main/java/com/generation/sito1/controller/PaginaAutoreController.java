package com.generation.sito1.controller;

import com.generation.sito1.controller.helper.ControllerHelper;
import com.generation.sito1.model.entities.Article;
import com.generation.sito1.model.entities.Author;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/paginaAutore")
public class PaginaAutoreController
{
    @Autowired
    ControllerHelper helper;

    @GetMapping
    public String mostraSchedaAutore(Model model, HttpSession session){
        Integer id = (Integer)session.getAttribute("id");

        //Recuperiamo le info dell'utente:
        Author author = helper.getAuthor(id);

        model.addAttribute("author", author);
        session.setAttribute("author", author);
        session.setAttribute("id",id);
        return "paginaAutore";
    }

    @PostMapping("/write")
    public String write(Model model, HttpSession session, @RequestParam("titolo")String titolo, @RequestParam("synopsis")String synopsis, @RequestParam("contenuto")String contenuto, @RequestParam("tags") String tags)
    {
        Article article = new Article();
        article.setTitle(titolo);
        article.setSynopsis(synopsis);
        article.setContent(contenuto);
        article.setTags(tags);
        Author author = (Author)session.getAttribute("author");
        article.setAuthor(author);

        return "redirect:/paginaAutore";
    }







}
