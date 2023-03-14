package com.postgrado.ecommerce.service;

import com.postgrado.ecommerce.dto.UserDTO;
import com.postgrado.ecommerce.entity.User;
import com.postgrado.ecommerce.exception.EntityNotFoundException;
import com.postgrado.ecommerce.mapper.UserMapper;
import com.postgrado.ecommerce.repository.UserRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;
  private UserMapper userMapper;

  @Override
  public UserDTO getById(UUID id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("User", id));

    UserDTO dto = userMapper.convertToUserDto(user);
    return dto;
  }

  @Override
  public boolean existByEmail(String email) {
    return userRepository.findByEmail(email).isPresent();
  }

  @Override
  public User getByEmail(String email) {
    return userRepository.findByEmail(email)
        .orElseThrow(() -> new EntityNotFoundException("User not found"));
  }

  @Override
  public User save(User user) {
    return userRepository.save(user);
  }

  @Override
  public void enabled(UUID id) {
    User user = userRepository.findById(id).get();
    user.setEnable(true);
    userRepository.save(user);
  }

}
