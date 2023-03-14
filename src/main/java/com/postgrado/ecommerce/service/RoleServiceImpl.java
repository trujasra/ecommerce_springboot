package com.postgrado.ecommerce.service;

import com.postgrado.ecommerce.entity.Role;
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
}
