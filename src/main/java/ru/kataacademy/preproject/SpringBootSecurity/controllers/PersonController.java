package ru.kataacademy.preproject.SpringBootSecurity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kataacademy.preproject.SpringBootSecurity.models.Person;
import ru.kataacademy.preproject.SpringBootSecurity.services.PersonService;

@Controller
@RequestMapping("/admin/users")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String printPerson(Model model) {
        model.addAttribute("list", personService.listPerson());
        return "person/users";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("person", personService.get(id));
        return "person/user";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "person/new";
    }

    @PostMapping
    public String createPerson(@ModelAttribute("person") Person person) {
        personService.add(person);
        return "redirect:/admin/users";
    }

    @PatchMapping("/{id}")
    public String updatePerson(@ModelAttribute("person") Person person, @PathVariable("id") long id) {
        personService.update(id, person);
        return "redirect:/admin/users";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") long id) {
        personService.delete(id);
        return "redirect:/admin/users";
    }

    @GetMapping("/{id}/edit")
    public String editPerson(Model model, @PathVariable("id") long id) {
        model.addAttribute("person", personService.get(id));
        return "person/edit";
    }

    @GetMapping("search")
    public String searchByPersonId(@RequestParam("keyword") long id, Model model) {
        Person person = personService.get(id);
        if (person != null) {
            model.addAttribute("person", person);
            return "person/user";
        }
        return "person/search_error";
    }
}
