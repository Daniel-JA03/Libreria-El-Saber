package com.elsaber.config;

import com.elsaber.props.SecurityProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityConfig {
    private final SecurityProperties properties;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        if (!properties.csrf().enabled()) {
            http.csrf(AbstractHttpConfigurer::disable);
        }
        http.authorizeHttpRequests(auth -> auth
                // 📚 Endpoints de Libro
                .requestMatchers(HttpMethod.POST, "/api/libro").hasRole("ADMIN")         // Solo ADMIN puede agregar libros
                .requestMatchers(HttpMethod.DELETE, "/api/libro/**").hasRole("ADMIN")    // Solo ADMIN puede eliminar libros
                .requestMatchers(HttpMethod.GET, "/api/libro/precio/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/libro/**").permitAll()            // Público: ver libros, por ID o por precio

                // 👨‍💼 Endpoints de Autor
                .requestMatchers(HttpMethod.POST, "/api/autor").hasRole("ADMIN")         // Solo ADMIN puede agregar autores
                .requestMatchers(HttpMethod.DELETE, "/api/autor/**").hasRole("ADMIN")    // Solo ADMIN puede eliminar autores
                .requestMatchers(HttpMethod.GET, "/api/autor/**").permitAll()            // Público: ver autores

                // 🧬 Endpoints de Género
                .requestMatchers(HttpMethod.POST, "/api/genero").hasRole("ADMIN")        // Solo ADMIN puede agregar géneros
                .requestMatchers(HttpMethod.DELETE, "/api/genero/**").hasRole("ADMIN")   // Solo ADMIN puede eliminar géneros
                .requestMatchers(HttpMethod.GET, "/api/genero/**").permitAll()
                .anyRequest().authenticated()
        ).httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(PasswordEncoder encoder) {
        List<UserDetails> users = properties.user().memory().users().stream()
                .map(um -> User.builder()
                        .username(um.name())
                        .password(encoder.encode(um.password()))
                        .roles(um.roles().toArray(String[]::new))
                        .build()).toList();
        return new InMemoryUserDetailsManager(users);
    }
}
