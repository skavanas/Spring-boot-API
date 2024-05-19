package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	@Bean
	CommandLineRunner commandelinerunner(StudentRepository repo) {
		return args ->{
			Student mariam = new Student("mariam","mariam@gmail.com",1,LocalDate.of(12, 4, 2003));
			repo.saveAll(List.of(mariam));
		};
		
	}
	
	
	
}
