package com.postgrado.ecommerce.exception.response;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ValidationErrorResponse {
    private String message;
    private List<FieldErrorModel> errors;

    public ValidationErrorResponse() {
        this.errors = new ArrayList<>();
    }
}
