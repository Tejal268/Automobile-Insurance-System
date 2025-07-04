package com.example.demo.service;

import com.example.demo.Entity.Officer;
import com.example.demo.Entity.User;
import com.example.demo.repository.OfficerRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.JwtUtil;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Period;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {

    private final UserRepository userRepository;
    private final OfficerRepository officerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil; //nd


    public String register(User user) {
        // Check if email exists
        if (userRepository.existsByEmail(user.getEmail()) || officerRepository.existsByEmail(user.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists");
        }

        // Encode password
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        // Calculate age
        if (user.getDateOfBirth() != null) {
            int age = Period.between(user.getDateOfBirth(), LocalDate.now()).getYears();
            user.setAge(age);
        }

        // Save based on role
        if ("OFFICER".equalsIgnoreCase(user.getRole())) {
            Officer officer = new Officer();
            officer.setName(user.getName());
            officer.setEmail(user.getEmail());
            officer.setPassword(encodedPassword);
            officer.setDesignation("Underwriter"); // or get from input

            officerRepository.save(officer);
            return "Officer registered successfully!";
        } else {
            userRepository.save(user);
            return "User registered successfully!";
        }
    }
    public String login(String email, String rawPassword) {
        // Check User
        User user = userRepository.findByEmail(email).orElse(null);
        if (user != null && passwordEncoder.matches(rawPassword, user.getPassword())) {
            return jwtUtil.generateToken(user.getEmail(), user.getRole());
        }

        // Check Officer
        Officer officer = officerRepository.findByEmail(email).orElse(null);
        if (officer != null && passwordEncoder.matches(rawPassword, officer.getPassword())) {
            return jwtUtil.generateToken(officer.getEmail(), "OFFICER");
        }

        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password");
    }

}
