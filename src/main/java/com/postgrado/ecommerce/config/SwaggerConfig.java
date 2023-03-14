package com.postgrado.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

  public static final String VERSION = "1.0.0";
  public static final String TITLE = "Ecommerce API";
  public static final String DESCRIPCION_API = "Api Ecommerce Posgrado";
  public static final String API_OWNER = "Ramiro";
  public static final String OWNER_WEB_SITE = "www.mundotrujas.com";
  public static final String OWNER_EMAIL = "trujasra@gmail.com";
  public static final String API_BASE_PACKAGE = "com.postgrado.ecommerce.controller";

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage(API_BASE_PACKAGE))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo(){
   return new ApiInfoBuilder()
       .version(VERSION)
       .title(TITLE)
       .description(DESCRIPCION_API)
       .contact(new Contact(API_OWNER, OWNER_WEB_SITE, OWNER_EMAIL))
       .build();
  }

}
