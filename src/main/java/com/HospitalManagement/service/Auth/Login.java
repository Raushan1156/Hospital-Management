package com.HospitalManagement.service.Auth;

import com.HospitalManagement.dto.LoginDto;
import com.HospitalManagement.entity.Users;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class Login {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    Logger logger = LoggerFactory.getLogger(Login.class);

    public String login(LoginDto loginDto) {

        try {
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
            logger.info("Data returned by Auth Manager:{}", authenticate);
            Users userLoginDetails =(Users) authenticate.getPrincipal();
            logger.info("Details are:\n{}", userLoginDetails);
            return jwtService.generateToken(userLoginDetails);
        } catch (AccountExpiredException ex) {
            throw new AccountExpiredException("Account Expired Exception has been found.");
        }
        catch (BadCredentialsException ex){
            throw new BadCredentialsException("Please verify your username or password.");
        }
        catch (AuthenticationException ex){
            throw ex;
        }
    }
}
