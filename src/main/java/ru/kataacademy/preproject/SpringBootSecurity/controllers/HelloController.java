package ru.kataacademy.preproject.SpringBootSecurity.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kataacademy.preproject.SpringBootSecurity.models.Person;
//import ru.kataacademy.preproject.SpringBootSecurity.security.PersonDetails;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/user")
    /** Получение объекта из сессии */
    public String showUser(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
//        model.addAttribute("person", personDetails.getPerson());
        Person person = (Person) authentication.getPrincipal();
        model.addAttribute("person", person);
        return "person/user";
    }
}
