package com.postgrado.ecommerce.security.jwt;

import java.util.Collection;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

  private String token;
  private Object principal;

  public JwtAuthenticationToken(String token) {
    super(null);
    this.token = token;
  }

  public JwtAuthenticationToken(
      Object principal,
      String token,
      Collection<? extends GrantedAuthority> authorities
  ) {
    super(authorities);
    this.token = token;
    this.principal = principal;
  }

  @Override
  public Object getCredentials() {
    return null;
  }

  @Override
  public Object getPrincipal() {
    return principal;
  }

  public String getToken() {
    return token;
  }
}
