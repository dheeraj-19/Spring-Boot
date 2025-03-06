package com.email.email.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.email.email.model.User;
import com.email.email.service.UserService;

import com.email.email.model.HTTPResponse;
import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

        private final UserService userService;

        @PostMapping
        public ResponseEntity<HTTPResponse> createUser(@RequestBody User user) {
                User newUser = userService.saveUser(user);

                return ResponseEntity.created(URI.create("")).body(
                                HTTPResponse.builder()
                                                .timeStamp(LocalDateTime.now().toString())
                                                .data(Map.of("user", newUser))
                                                .message("User created")
                                                .status(HttpStatus.CREATED)
                                                .statusCode(HttpStatus.CREATED.value())
                                                .build());
        }

        @GetMapping
        public ResponseEntity<HTTPResponse> confirmUserAccount(@RequestParam("token") String token) {
                Boolean isSuccess = userService.verifyToken(token);

                HTTPResponse response = HTTPResponse.builder()
                                .timeStamp(LocalDateTime.now().toString())
                                .data(Map.of("Success", isSuccess))
                                .message(isSuccess ? "Account Verified" : "Invalid Token")
                                .status(HttpStatus.OK)
                                .statusCode(HttpStatus.OK.value())
                                .build();

                return ResponseEntity.ok().body(response);
        }

}
