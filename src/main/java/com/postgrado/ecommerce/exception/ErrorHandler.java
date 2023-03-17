package com.postgrado.ecommerce.exception;

import com.postgrado.ecommerce.exception.response.ErrorConflict;
import com.postgrado.ecommerce.exception.response.ErrorResponse;
import com.postgrado.ecommerce.exception.response.FieldErrorModel;
import com.postgrado.ecommerce.exception.response.ValidationErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleEntityNotFoundException(Exception ex) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ErrorResponse response = new ErrorResponse(httpStatus.value(), httpStatus.name(), ex.getMessage());
        return ResponseEntity.status(httpStatus).body(response);
    }

    @ExceptionHandler(EmailAlreadyTakenException.class)
    public ResponseEntity<ErrorResponse> handleEmailReadyTakenException(Exception ex) {
        HttpStatus httpStatus = HttpStatus.CONFLICT;
        ErrorResponse response = new ErrorResponse(httpStatus.value(), httpStatus.name(), ex.getMessage());
        return ResponseEntity.status(httpStatus).body(response);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleBadCredentialsException(Exception ex) {
        HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
        ErrorResponse response = new ErrorResponse(httpStatus.value(), httpStatus.name(), ex.getMessage());
        return ResponseEntity.status(httpStatus).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<FieldErrorModel> errors = ex.getBindingResult().getAllErrors().stream().map(
                fieldError -> {
                    FieldErrorModel fieldErrorModel = new FieldErrorModel();
                    fieldErrorModel.setField(((FieldError) fieldError).getField());
                    fieldErrorModel.setMessage(((FieldError) fieldError).getDefaultMessage());
                    fieldErrorModel.setCode(((FieldError) fieldError).getCode());
                    return fieldErrorModel;
                }).toList();

        ValidationErrorResponse response = new ValidationErrorResponse();
        response.setErrors(errors);
        response.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(EntityRegisteredException.class)
    public ResponseEntity<ErrorConflict> handleEntityRegisteredException(EntityRegisteredException ex) {
        HttpStatus httpStatus = HttpStatus.CONFLICT;
        ErrorConflict response = new ErrorConflict(ex.getMessage(), ex.getCause().getMessage(), httpStatus.value());
        return ResponseEntity.status(httpStatus).body(response);
    }
}
