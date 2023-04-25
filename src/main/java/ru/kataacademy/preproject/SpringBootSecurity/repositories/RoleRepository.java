package ru.kataacademy.preproject.SpringBootSecurity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kataacademy.preproject.SpringBootSecurity.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
