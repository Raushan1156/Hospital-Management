package com.HospitalManagement.filter;

import com.HospitalManagement.entity.Users;
import com.HospitalManagement.repository.UsersRepository;
import com.HospitalManagement.service.Auth.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final UsersRepository usersRepository;
    private final JwtService jwtService;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getServletPath();
        return path.startsWith("/auth/");
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String requestHeader = request.getHeader("Authorization"); // it will be in form of Bearer sdfasd8s7d8f54s5dfs8
        if(!requestHeader.startsWith("Bearer ") || requestHeader.isEmpty()){
            System.out.println("Token is invalid. Your token is: "+requestHeader);
            filterChain.doFilter(request, response);
            return ;
        }

        String token = requestHeader.split("Bearer ")[1];
        String username = jwtService.getUserIdFromToken(token);
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            Users user = usersRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found with username: " + username));
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(user, null, null);
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(request, response);
    }
}
