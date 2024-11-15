package com.tayssir.cosmetique.security;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.cors().configurationSource(new CorsConfigurationSource() {
					@Override
					public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
						CorsConfiguration config = new CorsConfiguration();

						config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
						config.setAllowedMethods(Collections.singletonList("*"));
						config.setAllowCredentials(true);
						config.setAllowedHeaders(Collections.singletonList("*"));
						config.setExposedHeaders(Arrays.asList("Authorization"));
						config.setMaxAge(3600L);
						return config;
					}
				}).and().authorizeHttpRequests()
				.anyRequest().permitAll();
		/*
		 * .requestMatchers("/api/all/**").hasAnyAuthority("ADMIN", "USER")
		 * .requestMatchers(HttpMethod.GET, "/api/getbyid/**").hasAnyAuthority("ADMIN",
		 * "USER") .requestMatchers(HttpMethod.POST,
		 * "/api/addcos/**").hasAnyAuthority("ADMIN") .requestMatchers(HttpMethod.PUT,
		 * "/api/updatecos/**").hasAuthority("ADMIN")
		 * .requestMatchers(HttpMethod.DELETE, "/api/delcos/**").hasAuthority("ADMIN")
		 * .requestMatchers(HttpMethod.GET,
		 * "/api/cosmetiqueClas/**").hasAnyAuthority("ADMIN", "USER")
		 * .requestMatchers("/clas/**").hasAnyAuthority("ADMIN",
		 * "USER").anyRequest().authenticated().and() .addFilterBefore(new
		 * JWTAuthorizationFilter(), BasicAuthenticationFilter.class);
		 */

		return http.build();
	}

}
