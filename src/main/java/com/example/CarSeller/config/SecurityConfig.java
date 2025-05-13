package com.example.CarSeller.config;

import com.example.CarSeller.filters.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

@Autowired
    JwtAuthenticationFilter jwtAuthFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        // Public routes
                        .requestMatchers("/api/auth/**").permitAll()
                        // Routes protected by role
                        .requestMatchers("/api/admin/**").hasRole("MANAGER")
                        .requestMatchers("/api/private/**").hasRole("MANAGER")
                        .requestMatchers("/api/vendor/**").hasAnyRole("VENDOR", "MANAGER")
                        .requestMatchers("/api/client/**").hasAnyRole("CLIENT","MANAGER")
                        .requestMatchers("/api/car/**").hasAnyRole("MANAGER", "VENDOR", "CLIENT")
                        // All other routes require authentication
                        .anyRequest().authenticated()
                )
                // Add our filter before UsernamePasswordAuthenticationFilter
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
