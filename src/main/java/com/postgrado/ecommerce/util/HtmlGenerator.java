package com.postgrado.ecommerce.util;

public class HtmlGenerator {

  public static String generateConfirmationTemplate(String name, String url) {
    return "<html>" +
        "<body>" +
        "<h1> Hola " + name + ",</h1>" +
        "<p>Por favor haga click en el boton para confirmar la cuenta:</p>" +
        "<a href='" + url + "'>" +
        "<button> Confirmar cuenta</button>" +
        "</a>" +
        "</body>" +
        "</html>";
  }

}
