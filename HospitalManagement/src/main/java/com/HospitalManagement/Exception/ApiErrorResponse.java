package com.HospitalManagement.Exception;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

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
    String path;
}
