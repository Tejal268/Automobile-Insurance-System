package com.example.demo.controller;

import com.example.demo.Entity.User;
import com.example.demo.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody User user) {
        user.setRole("USER");
        String message = userService.register(user);

        Map<String, String> response = new HashMap<>();
        response.put("message", message);

        return ResponseEntity.ok(response);
    }

}
