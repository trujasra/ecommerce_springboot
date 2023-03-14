package com.postgrado.ecommerce.security;

import com.postgrado.ecommerce.security.jwt.JwtAuthenticationProvider;
import com.postgrado.ecommerce.security.jwt.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
@Configuration
public class AuthenticationConfig {

  private UserDetailsService userDetailsService;
  private PasswordEncoder passwordEncoder;
  private JwtService jwtService;

  @Bean
  public AuthenticationManager authenticationManager() {
    return new ProviderManager(daoAuthenticationProvider(), jwtAuthenticationProvider());
  }

  public DaoAuthenticationProvider daoAuthenticationProvider() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setUserDetailsService(userDetailsService);
    provider.setPasswordEncoder(passwordEncoder);
    return provider;
  }

  public JwtAuthenticationProvider jwtAuthenticationProvider() {
    JwtAuthenticationProvider provider = new JwtAuthenticationProvider(jwtService);
    return provider;
  }

}
