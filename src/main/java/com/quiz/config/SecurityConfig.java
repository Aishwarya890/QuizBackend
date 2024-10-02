//package com.quiz.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//            .authorizeRequests()
//            .requestMatchers("/api/register").permitAll() // Allow registration for everyone
//            .requestMatchers("/api/admin/quizzes/**","/api/teacher/quizzes/**").hasRole("ADMIN") // Protect admin routes
//            .anyRequest().authenticated() // All other requests require authentication
//            .and()
//            .httpBasic(); // Enable basic authentication (optional)
//
//        return http.build();
//    }
//}

package com.quiz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors() // Enable CORS
            .and()
            .csrf().disable() // Disable CSRF for now
            .authorizeRequests()
            .requestMatchers("/api/register").permitAll() // Allow registration for everyone
            .requestMatchers("/api/admin/quizzes/**", "/api/teacher/quizzes/**").permitAll()
            .requestMatchers("/api/teacher/quizzes/submit").authenticated()
            //.hasRole("ADMIN") // Protect admin routes
            .anyRequest().authenticated() // All other requests require authentication
            .and()
            .httpBasic(); // Enable basic authentication (optional)

        return http.build();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Arrays.asList("http://localhost:3000")); // Allow requests from this origin
        config.addAllowedHeader("*"); // Allow all headers
        config.addAllowedMethod("*"); // Allow all HTTP methods (GET, POST, etc.)
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}

