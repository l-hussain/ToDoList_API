package com.example.todo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configure security: CSRF disabled, and "/api/**" endpoints require authentication with basic auth
        http.csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers("/api/**").authenticated() // Use requestMatchers instead of antMatchers
            .and()
            .httpBasic(); // Enable HTTP Basic authentication

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // In-memory user for testing (user: "user", password: "password")
        var user = User.withUsername("user")
                       .password("{noop}password") // NoOpPasswordEncoder for simplicity
                       .roles("USER")
                       .build();
        return new InMemoryUserDetailsManager(user);
    }
}
