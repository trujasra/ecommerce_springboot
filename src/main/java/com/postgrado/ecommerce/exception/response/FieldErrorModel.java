package com.postgrado.ecommerce.exception.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldErrorModel {
    private String field;
    private String message;
    private String code;
}
