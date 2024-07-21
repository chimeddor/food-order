package com.example.food_order.Response;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.webjars.NotFoundException;

import java.util.List;

@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrResponse> handlerMethodArgumentNotValidException(MethodArgumentNotValidException inv){
        List<ErrResponse.FieldError> fieldErrors = inv.getBindingResult().getFieldErrors()
                .stream().map(error-> new ErrResponse.FieldError(error.getField(), error.getDefaultMessage()))
                .toList();
        ErrResponse errorResponse = new ErrResponse(HttpStatus.BAD_REQUEST.value(), "Invalid input value", fieldErrors);
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrResponse.NotFound> handlerNotFoundException(NotFoundException nte){
        ErrResponse.NotFound vallErrResponse = new ErrResponse.NotFound();
        vallErrResponse.setStatus(HttpStatus.NOT_FOUND.value());
        vallErrResponse.setMessage(nte.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(vallErrResponse);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrResponse.BadRequest> handlerNotFoundException(BadRequestException bdq){
        ErrResponse.BadRequest badErrResponse = new ErrResponse.BadRequest();
        badErrResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        badErrResponse.setMessage(bdq.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(badErrResponse);
    }
}
