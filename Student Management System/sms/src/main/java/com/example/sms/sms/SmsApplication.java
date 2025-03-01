package com.example.sms.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.sms.sms.entity.Student;
import com.example.sms.sms.repository.StudentRepository;

@SuppressWarnings("unused")
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.sms.sms.repository")
@EntityScan(basePackages = "com.example.sms.sms.entity")
public class SmsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SmsApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {

		// Student student1 = new Student("Cristiano", "Ronaldo", "cr@gmail.com");
		// studentRepository.save(student1);

		// Student student2 = new Student("Toni", "Kroos", "tk@gmail.com");
		// studentRepository.save(student2);

		// Student student3 = new Student("Luka", "Modrich", "lk@gmail.com");
		// studentRepository.save(student3);

	}

}
