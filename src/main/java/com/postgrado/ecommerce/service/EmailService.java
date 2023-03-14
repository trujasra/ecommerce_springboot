package com.postgrado.ecommerce.service;

public interface EmailService {

  void sendText(String to, String subject, String body);

  void sendTemplate(String to, String subject, String body);

}
