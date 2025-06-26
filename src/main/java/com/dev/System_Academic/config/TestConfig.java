package com.dev.System_Academic.config;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dev.System_Academic.Entities.Student;
import com.dev.System_Academic.Repositories.StudentRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private StudentRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
     Student stu1 = new Student(null, "mell", Instant.now(), 150.0);
     repository.save(stu1);
		
		
		
		
	}

	
	
}
