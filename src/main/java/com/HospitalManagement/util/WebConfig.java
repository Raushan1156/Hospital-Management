package com.HospitalManagement.util;

import com.HospitalManagement.filter.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebConfig{

    private final JwtAuthFilter jwtAuthFilter;
    Logger logger = LoggerFactory.getLogger(WebConfig.class);

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        httpSecurity.authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/auth/**",
                                "/v3/api-docs",
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html").permitAll()
                        .requestMatchers("/actuator/**").permitAll()
                        .anyRequest().authenticated()
        )
                .csrf(csrfConfig -> csrfConfig.disable())
                .sessionManagement(sessionManagement -> sessionManagement
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        logger.info("Security filter chain finished. httpsSecurity data is: {}", httpSecurity);
        return httpSecurity.build();
    }
}
