package com.example.test.service;

import com.example.test.entity.User;
import com.example.test.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LoginService {
    @Autowired
    private UserMapper userMapper;

    //登录
    public User authenticate(String username, String password) {
        return userMapper.findByUsernameAndPassword(username, password);
    }

    public String generateToken(User user) {
        // 这里可以使用 JWT 生成 Token
        return UUID.randomUUID().toString().replace("-", "");
    }
}
