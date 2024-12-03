package com.generation.sito1.controller;

import com.generation.sito1.controller.helper.ControllerHelper;
import com.generation.sito1.model.entities.Article;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dettaglioArticolo")
public class DettaglioArticolo
{

    @Autowired
    ControllerHelper helper;

    @GetMapping("/dettaglioArticolo/{id}")
    public String mostraDettaglioArticolo(Model model, @PathVariable int id)
    {
        Article articoloSelezionato = helper.getArticle(id);
        model.addAttribute("articoloSelezionato", articoloSelezionato);
        return "dettaglioArticolo";
    }


}
