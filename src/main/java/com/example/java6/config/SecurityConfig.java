package com.example.java6.config;

import com.example.java6.Service.DaoUserDetailsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {



        @Autowired
        DaoUserDetailsManager userDetailsService;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers("/poly/url1").authenticated()
                            .requestMatchers("/poly/url2").hasRole("USER")
                            .requestMatchers("/poly/url3").hasRole("ADMIN")
                            .requestMatchers("/poly/url4").hasAnyRole("USER", "ADMIN")
                            .anyRequest().permitAll()
                    )
                    .formLogin(form -> form
                            .loginPage("/login")
                            .permitAll()
                    )
                    .exceptionHandling(ex -> ex
                            .accessDeniedPage("/access-denied.html")
                    );

            return http.build();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return NoOpPasswordEncoder.getInstance(); // Hoặc dùng BCrypt nếu muốn
        }

        @Bean
        public UserDetailsService userDetailsService() {
            return userDetailsService;
        }
    }


