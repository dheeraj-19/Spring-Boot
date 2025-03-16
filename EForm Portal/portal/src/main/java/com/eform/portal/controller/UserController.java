// Controller to handle all user related api requests

package com.eform.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eform.portal.entities.User;
import com.eform.portal.service.user.UserService;

@RestController
@RequestMapping("api/auth")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    // API request to register a new user
    @PostMapping("/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody User user) {

        if (userService.hasUserWithEmail(user.getEmail())) {
            return new ResponseEntity<>("User already exists", HttpStatus.NOT_ACCEPTABLE);
        }

        User createdUser = userService.creatUser(user);
        if (createdUser == null) {
            return new ResponseEntity<>("User Not Created!", HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>(createdUser, HttpStatus.OK);
    }

    // API request to login a user
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User dbUser = userService.login(user);

        if (dbUser == null)
            return new ResponseEntity<>("Invalid Credentials!", HttpStatus.NOT_ACCEPTABLE);

        return new ResponseEntity<>(dbUser, HttpStatus.OK);

    }
}
