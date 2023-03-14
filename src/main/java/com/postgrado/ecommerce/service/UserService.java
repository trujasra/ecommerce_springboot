package com.postgrado.ecommerce.service;

import com.postgrado.ecommerce.dto.RegistrationRequest;
import com.postgrado.ecommerce.dto.UserDTO;
import com.postgrado.ecommerce.entity.User;
import java.util.UUID;

public interface UserService {

  UserDTO getById(UUID id);

  boolean existByEmail(String email);

  User getByEmail(String email);

  User save(User user);

  void enabled(UUID id);

}
