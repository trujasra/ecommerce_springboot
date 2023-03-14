package com.postgrado.ecommerce.security.jwt;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@AllArgsConstructor
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private AuthenticationManager authenticationManager;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {

    String authHeader = request.getHeader("Authorization");
    //Authorization Bearer
    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
      filterChain.doFilter(request, response);
    }

    String jwt = authHeader.substring(7);
    JwtAuthenticationToken authentication = new JwtAuthenticationToken(jwt);
    JwtAuthenticationToken authenticationToken = (JwtAuthenticationToken) authenticationManager.authenticate(
        authentication);

    if (SecurityContextHolder.getContext().getAuthentication() == null) {
      SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

    filterChain.doFilter(request, response);
  }
}
