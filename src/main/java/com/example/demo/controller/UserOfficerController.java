package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserOfficerController {

    private final UserServiceImpl userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        String jwt = userService.login(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(jwt);
    }
}
