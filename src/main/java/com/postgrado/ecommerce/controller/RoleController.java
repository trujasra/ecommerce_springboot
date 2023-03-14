package com.postgrado.ecommerce.controller;

import com.postgrado.ecommerce.entity.Role;
import com.postgrado.ecommerce.service.RoleService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/roles")
public class RoleController {

  private RoleService roleService;

  @GetMapping("/name/{name}")
  public ResponseEntity<Role> getByName(@PathVariable String name) {
    Role role = roleService.getByName(name);
    return ResponseEntity.ok(role);
  }

  @GetMapping
  public ResponseEntity<List<Role>> getAll() {
    return ResponseEntity.ok(roleService.getAll());
  }
}
