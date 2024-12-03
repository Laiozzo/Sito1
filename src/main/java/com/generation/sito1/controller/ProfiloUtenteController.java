package com.generation.sito1.controller;

import com.generation.sito1.controller.helper.ControllerHelper;
import com.generation.sito1.model.entities.Reader;
import com.generation.sito1.model.entities.SubscriptionType;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/profiloUtente")
public class ProfiloUtenteController {

    @Autowired
    ControllerHelper helper;

    //Visualizziamo la scheda dell'utente:
    @GetMapping
    public String mostraSchedaUtente(Model model, HttpSession session) {
        Integer id = (Integer) session.getAttribute("id");

        //RECUPERIAMO LE INFO DELL'UTENTE:
        Reader reader = helper.getReader(id);

        model.addAttribute("reader", reader);
        model.addAttribute("username", reader.getUsername());
        model.addAttribute("password", reader.getPassword());

        return "profiloUtente";
    }

    //Cambiamo la password dell'utente:

    @PostMapping("/cambiaPassword")
    public String cambiaPassword(@RequestParam("nuovaPassword") String nuovaPassword, Model model, HttpSession session) {
        Integer id = (Integer) session.getAttribute("id");
        //Aggiorna la password nel database:
        Reader reader = helper.getReader(id);
        reader.setPassword(nuovaPassword);
        helper.saveReader(reader);

        model.addAttribute("success", "Password cambiata con successo!");
        return "redirect:/profiloUtente";

    }

    @PostMapping("/cambiaAbbonamento")
    public String cambiaAbbonamento(Model model, HttpSession session, @RequestParam("nuovoAbbonamento") String nuovoAbbonamento)
    {
        Integer id = (Integer) session.getAttribute("id");

        //Aggiorna l'abbonamento nel database:
        Reader reader = helper.getReader(id);
        reader.setSubscriptionType(SubscriptionType.valueOf(nuovoAbbonamento));
        helper.saveReader(reader);

        model.addAttribute("success", "Abbonamento cambiato con successo!");
        return "redirect:/profiloUtente";
    }


}
