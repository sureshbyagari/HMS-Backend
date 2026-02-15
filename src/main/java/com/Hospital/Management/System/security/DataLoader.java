package com.Hospital.Management.System.security;

import com.Hospital.Management.System.security.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(UserRepository userRepository,
                      PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        if (userRepository.findByUsername("admin").isEmpty()) {
            userRepository.save(new User(
                    "admin",
                    passwordEncoder.encode("admin123"),
                    Role.ADMIN
            ));
        }

        if (userRepository.findByUsername("doctor").isEmpty()) {
            userRepository.save(new User(
                    "doctor",
                    passwordEncoder.encode("doctor123"),
                    Role.DOCTOR
            ));
        }
    }
}