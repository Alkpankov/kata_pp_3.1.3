package ru.kataacademy.preproject.SpringBootSecurity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kataacademy.preproject.SpringBootSecurity.models.Person;
import ru.kataacademy.preproject.SpringBootSecurity.services.PersonService;
import ru.kataacademy.preproject.SpringBootSecurity.services.RoleService;


import java.util.List;


@Controller
@RequestMapping("/admin")
public class PersonController {
    private final PersonService personService;
    private final RoleService roleService;

    @Autowired
    public PersonController(PersonService personService, RoleService roleService) {
        this.personService = personService;
        this.roleService = roleService;
    }

    @GetMapping
    public String start(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Person person = (Person) authentication.getPrincipal();
        model.addAttribute("person", person);
        model.addAttribute("persons", personService.listPerson());
        model.addAttribute("edit_person", new Person());
        model.addAttribute("new_person", new Person());
        model.addAttribute("roles", roleService.listRole());
        return "person/admin_page";
    }


    @PostMapping
    public String createPerson(@ModelAttribute("person") Person person,
                               @RequestParam(value = "rol", required = false) List<Long> roles) {
        personService.add(person, roles);
        return "redirect:/admin";
    }

    @PatchMapping("/{id}")
    public String updatePerson(@ModelAttribute("edit_person") Person person,
                               @PathVariable("id") long id,
                               @RequestParam(name = "rol", required = false) List<Long> roles) {

        personService.update(id, person, roles);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") long id) {
        personService.delete(id);
        return "redirect:/admin";
    }
}
