package com.HospitalManagement.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//import javax.naming.AuthenticationException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private String extractErrorLocation(Throwable ex){
        StackTraceElement element = ex.getStackTrace()[0];
        String finalPath = element.getClassName()
                +element.getMethodName()
                +" (line"
                + element.getLineNumber()
                +") ";
        return  finalPath;
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiErrorResponse> authenticationException(AuthenticationException ex){
        System.out.println("There is error: "+ex.getClass());
        ApiErrorResponse apiErrorResponse = new ApiErrorResponse(
                LocalDateTime.now(),
                HttpStatus.UNAUTHORIZED.value(),
                ex.getMessage(),
                HttpStatus.UNAUTHORIZED,
                ex.getClass(),
                extractErrorLocation(ex)
        );
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(apiErrorResponse);
    }
}
