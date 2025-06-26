package com.dev.System_Academic.config;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dev.System_Academic.Entities.Enrollment;
import com.dev.System_Academic.Entities.Student;
import com.dev.System_Academic.Entities.Enum.StatusSubject;
import com.dev.System_Academic.Repositories.EnrollmentRepository;
import com.dev.System_Academic.Repositories.StudentRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
     Student stu1 = new Student(null, "mell", Instant.now(), 150.0);
     studentRepository.save(stu1);
		
	 Enrollment en1 = new Enrollment(null, StatusSubject.INPROGRESS, 145.0,stu1);
	 enrollmentRepository.save(en1);
	 
		
	}

	
	
}
