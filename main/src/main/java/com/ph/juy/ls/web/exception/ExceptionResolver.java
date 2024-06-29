package com.ph.juy.ls.web.exception;

import com.ph.juy.ls.exceptions.BusinessException;
import com.ph.juy.ls.exceptions.SpeechNotFoundException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Order
public class ExceptionResolver extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = { SpeechNotFoundException.class })
    protected ResponseEntity<Errors> handleSpeechNotFoundException(final RuntimeException ex,
                                                                   final WebRequest request) {
        final Errors errors = new Errors();
        final SpeechNotFoundException speechNotFoundException = (SpeechNotFoundException) ex;
        errors.addError(new Error("LS-101", speechNotFoundException.getMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(value
            = { BusinessException.class })
    protected ResponseEntity<Errors> handleBusinessException(final RuntimeException ex,
                                                             final WebRequest request) {
        final Errors errors = new Errors();
        errors.addError(new Error("LS-100", ex.getMessage()));
        return ResponseEntity.badRequest().body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            final MethodArgumentNotValidException exception,
            final HttpHeaders httpHeaders, HttpStatus httpStatus,
            final WebRequest webRequest) {
        final Errors errors = new Errors();
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errors.addError(new Error(fieldError.getField(), fieldError.getDefaultMessage()));
        });
        return ResponseEntity.badRequest().body(errors);
    }

}
