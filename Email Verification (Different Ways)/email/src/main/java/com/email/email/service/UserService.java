package com.email.email.service;

import com.email.email.model.User;

public interface UserService {
    User saveUser(User user);

    Boolean verifyToken(String token);
}
