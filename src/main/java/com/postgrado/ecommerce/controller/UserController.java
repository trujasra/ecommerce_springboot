package com.postgrado.ecommerce.controller;

import com.postgrado.ecommerce.dto.UserDTO;
import com.postgrado.ecommerce.entity.User;
import com.postgrado.ecommerce.service.UserService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

  private UserService userService;

  @GetMapping("/{id}")
  public ResponseEntity<UserDTO> getById(@PathVariable UUID id) {
    return ResponseEntity.ok(userService.getById(id));
  }
}
