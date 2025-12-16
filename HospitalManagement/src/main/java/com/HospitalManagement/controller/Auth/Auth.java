package com.HospitalManagement.controller.Auth;

import com.HospitalManagement.dto.SignUpDto;
import com.HospitalManagement.dto.UserDto;
import com.HospitalManagement.service.Auth.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class Auth {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> newSignUp(@RequestBody SignUpDto signUpDto){
        UserDto userDto = userService.newSignUp(signUpDto);
        return ResponseEntity.ok(userDto);
    }
}
