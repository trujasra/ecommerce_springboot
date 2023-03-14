package com.postgrado.ecommerce.security;

import com.postgrado.ecommerce.security.jwt.JwtAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfig {

  private static final String[] RUTAS_PERMITIDAS = {
      "/auth/**",
      "/v2/api-docs",
      "/swagger-ui/**",
      "/swagger-resources/**",
      "/webjars/**",
      "/configuration/**"
  };

  private JwtAuthenticationFilter jwtAuthenticationFilter;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.authorizeRequests((authz) -> {
      authz
          //.antMatchers("/auth/**").permitAll()
          .antMatchers(RUTAS_PERMITIDAS).permitAll()
          .anyRequest().authenticated(); //Esto pone la seguridad a cualquier ruta
    });
    http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }

}
