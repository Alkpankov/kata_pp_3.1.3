package ru.kataacademy.preproject.SpringBootSecurity.services;

import ru.kataacademy.preproject.SpringBootSecurity.models.Role;

import java.util.List;

public interface RoleService {
    public List<Role> listRole();
    public List<Role> findAllById(List<Long> roles);
    public Role findById(Long id);
}
