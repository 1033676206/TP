package com.example.test.controller;

import com.example.test.dto.LoginRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import com.example.test.entity.User;
import com.example.test.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api")

public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "Login";  // 返回 login.html 页面
    }
    @GetMapping("/Welcome")
    public String showWelcomePage() {
        return "Welcome";  // 返回 Welcome.html 页面
    }


    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest loginRequest) {
        User user = loginService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        if (user != null) {
            String token = loginService.generateToken(user);

            Map<String, Object> response = new HashMap<>();
            response.put("code", 200);

            Map<String, Object> data = new HashMap<>();
            data.put("token", token);

            Map<String, Object> userInfo = new HashMap<>();
            userInfo.put("id", user.getId());
            userInfo.put("account", user.getAccount());
            userInfo.put("username", user.getUsername());
            userInfo.put("gender", user.getGender());
            userInfo.put("age", user.getAge());
            userInfo.put("phone", user.getPhone());
            userInfo.put("avatar", user.getAvatar());

            data.put("userInfo", userInfo);
            response.put("data", data);

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("code", 401, "message", "Invalid username or password"));
        }
    }



}
