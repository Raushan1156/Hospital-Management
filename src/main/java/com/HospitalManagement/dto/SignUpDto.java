package com.HospitalManagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SignUpDto {
    @Size(min = 3, message = "name length can be less than 3.")
    String name;
    @Email
    String username;

    @NotEmpty
    @Size(min = 6, message = "Password must have at least 6 character")
    String password;
}
