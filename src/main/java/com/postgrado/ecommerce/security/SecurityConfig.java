package com.postgrado.ecommerce.security;

import com.postgrado.ecommerce.security.jwt.JwtAuthenticationFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
          .antMatchers(RUTAS_PERMITIDAS).permitAll()
          .antMatchers("/auth/**").permitAll()
          .antMatchers(HttpMethod.GET, "/categories/**").permitAll()
          .antMatchers(HttpMethod.GET, "/products/**").permitAll()
          .antMatchers(HttpMethod.POST, "/orders").hasAuthority("USER")
          .antMatchers(HttpMethod.POST, "/products").hasAuthority("ADMIN")
          .antMatchers(HttpMethod.GET, "/roles/**").hasAuthority("ADMIN")
          .antMatchers(HttpMethod.GET, "/users/**").hasAuthority("ADMIN")
          .antMatchers(HttpMethod.GET, "/orders/**").hasAuthority("ADMIN")
          .anyRequest().authenticated(); //Esto pone la seguridad a cualquier ruta
    });
    http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }

}
