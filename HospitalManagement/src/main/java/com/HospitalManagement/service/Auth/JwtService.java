package com.HospitalManagement.service.Auth;

import com.HospitalManagement.entity.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

@Service
public class JwtService {

    @Value("${spring.jwt.secretKey}")
    private String storedToken;

    // create a jwt token
    public String generateToken(Users users){
        String token = Jwts.builder()
//                .subject(users.getId().toString())
                .subject(users.getUsername())
                .claim("username", users.getUsername())
                .claim("role", List.of("Admin", "User"))
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000*60*5))
                .signWith(getSecretKey())
                .compact();
        System.out.println("Token is:\n"+token);
        return token;
    }

    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(storedToken.getBytes(StandardCharsets.UTF_8));
    }

    public String getUserIdFromToken(String token){
        Claims claims = Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

//        if(claims.getId()==null)
//            System.out.print("Id is null. see the value: \n"+claims.getId());
        System.out.print("\n\nhiiiii\n\n");
        System.out.println(claims);


        return (claims.getSubject());
    }
}
