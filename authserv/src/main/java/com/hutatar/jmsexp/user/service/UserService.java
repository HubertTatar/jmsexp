package com.hutatar.jmsexp.user.service;

import com.hutatar.jmsexp.entity.User;

import java.util.Optional;

public interface UserService {
    public Optional<User> getByUsername(String username);
}