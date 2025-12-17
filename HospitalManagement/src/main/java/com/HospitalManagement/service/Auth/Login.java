package com.HospitalManagement.service.Auth;

import com.HospitalManagement.dto.LoginDto;
import com.HospitalManagement.dto.SignUpDto;
import com.HospitalManagement.dto.UserDto;
import com.HospitalManagement.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class Login {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public String login(LoginDto loginDto){
        System.out.println("inside login method of auth service...");
        // need a authManager and call authenticate() method ->
        // -> Here our purpose is to take the principal id to generate the token
        Authentication authenticate = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginDto.getUsername(),
                                loginDto.getPassword()
                        )
                );
        Users userLoginDetails = (Users) authenticate.getPrincipal();
        System.out.println("Details are:\n"+userLoginDetails);
        return jwtService.generateToken(userLoginDetails);
    }
}
