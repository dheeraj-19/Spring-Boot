package com.user.registration.registration_login.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.user.registration.registration_login.controller.dto.UserRegistrationDto;
import com.user.registration.registration_login.model.User;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);

}
