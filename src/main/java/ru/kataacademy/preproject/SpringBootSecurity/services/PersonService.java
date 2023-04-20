package ru.kataacademy.preproject.SpringBootSecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kataacademy.preproject.SpringBootSecurity.models.Person;
import ru.kataacademy.preproject.SpringBootSecurity.repositories.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonService {

    private final PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> listPerson() {
        return personRepository.findAll();
    }

    @Transactional
    public void add(Person person) {
        personRepository.save(person);
    }

    @Transactional
    public void update(long id, Person updatedPerson) {
        updatedPerson.setId(id);
        personRepository.save(updatedPerson);
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
