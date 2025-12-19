package com.HospitalManagement.Exception;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiErrorResponse {

    LocalDateTime timestamp;
    int status;
    String errorMessage;
    HttpStatus errorType;
    Object className;
    String path;
}
