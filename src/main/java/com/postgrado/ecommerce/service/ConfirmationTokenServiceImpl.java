package com.postgrado.ecommerce.service;

import com.postgrado.ecommerce.entity.ConfirmationToken;
import com.postgrado.ecommerce.exception.EntityNotFoundException;
import com.postgrado.ecommerce.repository.ConfirmationTokenRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {

  private ConfirmationTokenRepository confirmationTokenRepository;

  @Override
  public ConfirmationToken save(ConfirmationToken confirmationToken) {
    return confirmationTokenRepository.save(confirmationToken);
  }

  @Override
  public ConfirmationToken getByToken(String token) {

    ConfirmationToken confirmationToken = confirmationTokenRepository.findByToken(token)
        .orElseThrow(() -> new EntityNotFoundException("Token not found"));
    return confirmationToken;
  }

  @Override
  public void setConfirmedAt(ConfirmationToken confirmationToken) {
    confirmationToken.setConfirmedAt(LocalDateTime.now());
    confirmationTokenRepository.save(confirmationToken);
  }
}
