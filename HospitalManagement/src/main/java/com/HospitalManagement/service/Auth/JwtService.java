package com.HospitalManagement.service.Auth;

import com.HospitalManagement.entity.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

@Service
public class JwtService {

    private final String storedToken = "asfsad4f5sd4fsd4f5sd4f6sd4fs54df6sdf7g8sd4fgsdf54gs";

    // create a jwt token
    public String generateToken(Users users){
        String token = Jwts.builder()
                .subject(users.getId().toString())
                .claim("username", users.getUsername())
                .claim("role", List.of("Admin", "User"))
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000*60))
                .signWith(getSecretKey())
                .compact();
        return token;
    }

    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(storedToken.getBytes(StandardCharsets.UTF_8));
    }

    public Long getUserIdFromToken(String token){
        Claims claims = Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

//        if(claims.getId()==null)
//            System.out.print("Id is null. see the value: \n"+claims.getId());
        System.out.print("\n\nhiiiii");
        System.out.print(claims);


        return Long.valueOf(claims.getSubject());
    }
}
