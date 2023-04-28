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


public interface PersonService {
    public List<Person> listPerson();
    public void add(Person person, List<Long> roles);
    public void update(long id, Person updatedPerson, List<Long> roles);
    public void delete(long id);
    public Person get(long id);
}
