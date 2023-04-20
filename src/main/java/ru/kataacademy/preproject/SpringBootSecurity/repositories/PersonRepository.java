package ru.kataacademy.preproject.SpringBootSecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kataacademy.preproject.SpringBootSecurity.models.Person;

import java.util.Optional;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    @Query("Select p from Person p left join fetch p.roles where p.email=:email")
    Optional<Person> findByEmail(@Param("email") String email);
}
