package system.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(csrf -> csrf.disable()) // Desativa CSRF para evitar bloqueios no H2
            .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(req -> req.anyRequest().permitAll()) // 🔥 Libera acesso a tudo temporariamente
            .headers(headers -> headers.defaultsDisabled()
                .frameOptions(frame -> frame.disable())) // Libera H2 Console
            .build();
    }

}

