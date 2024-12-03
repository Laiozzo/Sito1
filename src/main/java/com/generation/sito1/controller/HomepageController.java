package com.generation.sito1.controller;

import com.generation.sito1.controller.helper.ControllerHelper;
import com.generation.sito1.model.entities.Author;
import com.generation.sito1.model.entities.Reader;
import com.generation.sito1.model.entities.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalTime;
import java.util.List;

@Controller
public class HomepageController
{

    @Autowired
    ControllerHelper helper;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("reader", new Reader());
        return "homepage";
    }

    @PostMapping("/register")
    public String register(Model model, HttpSession session, @RequestParam("username")String username, @RequestParam("password")String password, @RequestParam("dob")String dob, @RequestParam("name")String name, @RequestParam("surname")String surname, @RequestParam("userType2")String userType2){

        if("reader".equalsIgnoreCase(userType2)){
            Reader reader = new Reader();
            reader.setUsername(username);
            reader.setPassword(password);
            reader.setSurname(surname);
            reader.setName(name);
            helper.saveReader(reader);

        }else if("author".equalsIgnoreCase(userType2)){
            Author author = new Author();
            author.setUsername(username);
            author.setPassword(password);
            author.setSurname(surname);
            author.setName(name);
            helper.saveAuthor(author);
        }
        return "redirect:/homepage";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password,@RequestParam("userType")String userType ,  HttpSession session, Model model) {
        //Cerca l'utente nel DATABASE:
        List<Reader> allReaders = helper.getAllReaders();
        List<Author> allAuthors = helper.getAllAuthors();
        User user = null;

        if ("reader".equalsIgnoreCase(userType)){
            for (Reader readers : allReaders) {
                if (username.equals(readers.getUsername()) && password.equals(readers.getPassword())) {
                    user = readers;
                    break;
                }
            }
        }else if("author".equalsIgnoreCase(userType)){
            for(Author author : allAuthors) {
                if(username.equals(author.getUsername()) && password.equals(author.getPassword())) {
                    user = author;
                    break;
                }
            }
        }
        //Se l'utente non esiste o la password è sbagliata mostra un errore
        if (user == null) {
            model.addAttribute("error", "Username o password non corretti");
            return "homepage"; // Torna alla homepage con un messaggio di errore
        }
        //Salva l'utente nella sessione

        if(user instanceof Reader){
            session.setAttribute("reader",(Reader) user);
            session.setAttribute("loginHour", LocalTime.now());
            session.setAttribute("id",((Reader) user).getId());
            return "redirect:/profiloUtente";
        } else if (user instanceof Author) {
            session.setAttribute("author",(Author) user);
            session.setAttribute("loginHour", LocalTime.now());
            session.setAttribute("id", ((Author) user).getId());
            return "redirect:/profiloAutore";
        }

        return "redirect:/homepage";
    }



}
