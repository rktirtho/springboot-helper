package com.rktirtho.securitydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails userDetails1 = User.withUsername("rktirtho")
                .password(passwordEncoder.encode("qwert"))
                .roles("ADMIN").build();
        UserDetails userDetails2 = User.withUsername("rktirtho2")
                .password(passwordEncoder.encode("qwert"))
                .roles("ADMIN").build();

        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf()
                .disable()
                    .authorizeHttpRequests()
                    .requestMatchers("/")
                    .permitAll().
                and()
                    .authorizeHttpRequests()
                    .requestMatchers("/products")
                    .authenticated().
                and()
                    .authorizeHttpRequests()
                    .requestMatchers("/products/**")
                    .hasAuthority("USER")
                .and()
                    .formLogin()
                .and()
                    .build();
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
