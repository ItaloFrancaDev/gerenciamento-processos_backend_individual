package com.example.gerenciamento_processos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {

	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Desabilita CSRF, se não estiver usando
            .authorizeRequests()
                .requestMatchers("/**").permitAll() // Permite acesso livre a todas as rotas
            .and()
            .headers().frameOptions().disable(); // Desabilita cabeçalho de proteção, se necessário

        return http.build();
    }
}
