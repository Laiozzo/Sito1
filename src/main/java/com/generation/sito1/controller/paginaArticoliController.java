package com.generation.sito1.controller;

import com.generation.sito1.controller.helper.ControllerHelper;
import com.generation.sito1.model.entities.Article;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/paginaArticoli")
public class paginaArticoliController
{
    @Autowired
    ControllerHelper helper;

    //Visualizziamo la paginaArticoli:
    @GetMapping
    public String mostraPaginaArticoli(Model model, HttpSession session)
    {
        return "paginaArticoli";
    }

    @GetMapping("/articoli")
    public String ListaArticoli(Model model)
    {
        List<Article> articoli = helper.getAllArticles();
        model.addAttribute("articoli", articoli);
        return "paginaArticoli";
    }
}
