package ru.kataacademy.preproject.SpringBootSecurity.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kataacademy.preproject.SpringBootSecurity.models.Person;
import ru.kataacademy.preproject.SpringBootSecurity.models.Role;
import ru.kataacademy.preproject.SpringBootSecurity.repositories.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class RoleService {
    private final RoleRepository roleRepository;
    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> listRole() {
        return roleRepository.findAll();
    }

    public List<Role> findAllById(List<Long> roles) {
        return roleRepository.findAllById(roles);
    }
    public Role findById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        return role.orElse(null);
    }
}
