package br.com.fiap.SmartSecurity.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private VerificarToken verificarToken;

    @Bean
    public SecurityFilterChain filtrarCadeiaDeSeguranca(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.csrf(csrf -> csrf.disable())
                .sessionManagement(
                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize ->
                        authorize
                                //USUARIO
                                .requestMatchers(HttpMethod.POST, "/auth/registro").permitAll()
                                .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                                .requestMatchers(HttpMethod.GET, "/api/usuario").hasAnyRole("ADMIN", "USER")
                                .requestMatchers(HttpMethod.PUT, "/api/usuario").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/api/usuario").hasRole("ADMIN")
                                //CRIME
                                .requestMatchers(HttpMethod.GET, "/api/crime").hasAnyRole("ADMIN", "USER")
                                .requestMatchers(HttpMethod.POST, "/api/crime").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/crime").hasRole("ADMIN")
                                //PATRULHA
                                .requestMatchers(HttpMethod.GET, "/api/patrulha").hasAnyRole("ADMIN", "USER")
                                .requestMatchers(HttpMethod.POST, "/api/patrulha").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/patrulha").hasRole("ADMIN")
                                //POLICIA
                                .requestMatchers(HttpMethod.GET, "/api/policia").hasAnyRole("ADMIN", "USER")
                                .requestMatchers(HttpMethod.POST, "/api/policia").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/policia").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE, "/policia/excluir").hasRole("ADMIN")
                                //SUSPEITO
                                .requestMatchers(HttpMethod.GET, "/api/suspeito").hasAnyRole("ADMIN", "USER")
                                .requestMatchers(HttpMethod.POST, "/api/suspeito").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.PUT, "/api/suspeito").hasRole("ADMIN")
                                .anyRequest()
                                .authenticated())
                .addFilterBefore(
                        verificarToken,
                        UsernamePasswordAuthenticationFilter.class
                )
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception{

        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
