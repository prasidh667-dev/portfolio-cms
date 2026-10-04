package com.portfolio.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.portfolio.model.AdminUser;
import com.portfolio.repository.AdminUserRepository;

@Configuration
public class SeedConfig {

    @Bean
    CommandLineRunner seed(
            AdminUserRepository repo,
            PasswordEncoder encoder,
            @Value("${app.admin.username}") String username,
            @Value("${app.admin.password}") String password) {

        return args -> {
            if (repo.findByUsername(username).isEmpty()) {
                var u = new AdminUser();
                u.setUsername(username);
                u.setPassword(encoder.encode(password));
                repo.save(u);
            }
        };
    }
}