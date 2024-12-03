package com.generation.sito1.controller;

import com.generation.sito1.controller.helper.ControllerHelper;
import com.generation.sito1.model.entities.Author;
import com.generation.sito1.model.entities.Reader;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalTime;

@Controller
@RequestMapping("/loginAuthor")
public class AuthorController
{
    @Autowired
    ControllerHelper helper;

    @PostMapping
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session){
        Author author = helper.getAuthorByUP(username, password);
        if(author != null)
            session.setAttribute("author", author);
        session.setAttribute("loginHour", LocalTime.now());
        return "loginSucess";
    }
}
