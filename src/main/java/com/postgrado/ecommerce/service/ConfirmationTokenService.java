package com.postgrado.ecommerce.service;

import com.postgrado.ecommerce.entity.ConfirmationToken;

public interface ConfirmationTokenService {

  ConfirmationToken save(ConfirmationToken confirmationToken);

  ConfirmationToken getByToken(String token);

  void setConfirmedAt(ConfirmationToken confirmationToken);

}
