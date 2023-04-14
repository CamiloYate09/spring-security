package com.yate.springsecurity.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig {


//    @Bean
//    public UserDetailsService userDetailsService() {
//        var user = User.withUsername("camilo").password("camilo").roles("read").build();
//        return new InMemoryUserDetailsManager(user);
//    }

    /**
     * Quien maneja las contraseñas
     */

    @Bean
    public PasswordEncoder passwordEncoder() {
//        -- 1 opción cuando se usa por primera vez, el ingreso de usuarios y contraseñas
        return new BCryptPasswordEncoder();
        //   -- 2 opción cuando el usuario tiene una contraseña encriptada y otra  no, entonces debe el sistema validar ambos casos
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
