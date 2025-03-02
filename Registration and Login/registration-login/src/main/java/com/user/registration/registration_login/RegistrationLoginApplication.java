package com.user.registration.registration_login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.user.registration.registration_login.repository")
@EntityScan(basePackages = "com.user.registration.registration_login.model")

public class RegistrationLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationLoginApplication.class, args);
	}

}
