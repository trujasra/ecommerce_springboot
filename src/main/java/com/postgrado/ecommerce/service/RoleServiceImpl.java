package com.postgrado.ecommerce.service;

import com.postgrado.ecommerce.entity.Role;
import com.postgrado.ecommerce.exception.EmailAlreadyTakenException;
import com.postgrado.ecommerce.exception.EntityRegisteredException;
import com.postgrado.ecommerce.repository.RoleRepository;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    RoleRepository roleRepository;

    @Override
    public Role getByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role saveRole(Role role) {
        Role findRole = roleRepository.findByName(role.getName());
        if (findRole != null) {
            Throwable cause = new Throwable("Role with name " + role.getName() + " already exists.");
            throw new EntityRegisteredException("Role Name", cause);
        }
        return roleRepository.save(role);
    }
}
