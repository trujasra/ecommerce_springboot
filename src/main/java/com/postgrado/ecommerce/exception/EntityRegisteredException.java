package com.postgrado.ecommerce.exception;

import lombok.Getter;

@Getter
public class EntityRegisteredException extends RuntimeException {
    public static final String ERROR_MESSAGE = "%s Already Exists";

    public EntityRegisteredException(String message, Throwable cause) {
        super(String.format(ERROR_MESSAGE, message), cause);
    }
}
