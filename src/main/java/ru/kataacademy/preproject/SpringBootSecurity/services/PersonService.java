package ru.kataacademy.preproject.SpringBootSecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kataacademy.preproject.SpringBootSecurity.models.Person;
import ru.kataacademy.preproject.SpringBootSecurity.models.Role;
import ru.kataacademy.preproject.SpringBootSecurity.repositories.PersonRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class PersonService {

    private final PersonRepository personRepository;
    private final RoleService roleService;
    @Autowired
    public PersonService(PersonRepository personRepository, RoleService roleService) {
        this.personRepository = personRepository;
        this.roleService = roleService;
    }

    public List<Person> listPerson() {
        return personRepository.findAll();
    }

    @Transactional
    public void add(Person person, List<Long> roles) {
        personRepository.save(setRoleByListId(person, roles));
    }

    private Person setRoleByListId(Person person, List<Long> roleId){
        Set<Role> role = new HashSet<>(roleService.findAllById(roleId));
        if(role.isEmpty()) {
            person.setRoles(roleService.findById(0L));
        } else {
            person.setRoles(role);
        }
        return person;
    }

    @Transactional
    public void update(long id, Person updatedPerson, List<Long> roles) {
        updatedPerson.setId(id);
        personRepository.save(setRoleByListId(updatedPerson, roles));
    }

    @Transactional
    public void delete(long id) {
        personRepository.deleteById(id);
    }

    public Person get(long id) {
        Optional<Person> person = personRepository.findById(id);
        return person.orElse(null);
    }

}
