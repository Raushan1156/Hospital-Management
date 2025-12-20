package com.HospitalManagement.controller.Auth;

import com.HospitalManagement.dto.LoginDto;
import com.HospitalManagement.dto.SignUpDto;
import com.HospitalManagement.dto.UserDto;
import com.HospitalManagement.service.Auth.Login;
import com.HospitalManagement.service.Auth.UserService;
import jakarta.validation.Valid;
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
    private final Login loginAuth;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> newSignUp(@Valid @RequestBody SignUpDto signUpDto){
        UserDto userDto = userService.newSignUp(signUpDto);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginDto loginDto){
        System.out.println("Inside Login method of controller...\n"+loginDto.getUsername()+"---"+loginDto.getPassword());

        String jwtToken = loginAuth.login(loginDto);
        return jwtToken;
    }
}
