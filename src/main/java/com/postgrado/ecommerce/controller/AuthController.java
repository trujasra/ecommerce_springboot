package com.postgrado.ecommerce.controller;

import com.postgrado.ecommerce.dto.AuthenticationRequest;
import com.postgrado.ecommerce.dto.AuthenticationResponse;
import com.postgrado.ecommerce.dto.RegistrationRequest;
import com.postgrado.ecommerce.service.AuthenticationService;
import com.postgrado.ecommerce.service.EmailService;
import com.postgrado.ecommerce.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

  private RegistrationService registrationService;
  //private EmailService emailService;

  private AuthenticationService authenticationService;

  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody RegistrationRequest request) {
    String token = registrationService.register(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(token);
  }

  @GetMapping("/confirm")
  public ResponseEntity<String> confirm(@RequestParam String token) {
    String message = registrationService.confirm(token);
    return ResponseEntity.ok(message);
  }

  /*@PostMapping("/sendemail/{email}")
  public String senEmail(@PathVariable String email) {
    emailService.sendText(email, "TEST", "Holas");
    emailService.sendTemplate(email, "TEST_HTML", "<h1>Holas</h1>");
    return "Success";
  }*/

  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request) {
    AuthenticationResponse response = authenticationService.authenticate(request);
    return ResponseEntity.ok(response);
  }

}
