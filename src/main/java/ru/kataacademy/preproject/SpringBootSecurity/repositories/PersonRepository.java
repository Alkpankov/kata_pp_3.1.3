package ru.kataacademy.preproject.SpringBootSecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kataacademy.preproject.SpringBootSecurity.models.Person;

import java.util.Optional;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByEmail(String email);
}
