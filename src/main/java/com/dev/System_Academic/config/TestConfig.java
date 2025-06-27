package com.dev.System_Academic.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dev.System_Academic.Entities.Enrollment;
import com.dev.System_Academic.Entities.Student;
import com.dev.System_Academic.Entities.Subject;
import com.dev.System_Academic.Entities.Enum.StatusSubject;
import com.dev.System_Academic.Repositories.EnrollmentRepository;
import com.dev.System_Academic.Repositories.StudentRepository;
import com.dev.System_Academic.Repositories.SubjectRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
     Student stu1 = new Student(null, "mell", Instant.parse("2023-10-27T10:00:00Z"), 124.0);
     Student stu2 = new Student(null, "nicolle", Instant.parse("2023-10-27T10:00:00Z"), 119.0);
     Student stu3 = new Student(null, "lisa", Instant.parse("2023-10-27T10:00:00Z"), 110.0);
     studentRepository.saveAll(Arrays.asList(stu1,stu2,stu3));
     			 	 
	 Subject sub1 = new Subject(null, "computing networks",16,8.0);
	 Subject sub2 = new Subject(null, "algorithms and logic",22,7.0);
	 Subject sub3 = new Subject(null, "POO programming",33,5.0);		 
	 Subject sub4 = new Subject(null, "advanced calculation",30,8.0);
	 Subject sub5 = new Subject(null, "database",19,6.0);
	 
	 Enrollment en1 = new Enrollment(null, StatusSubject.INPROGRESS,stu1,sub2);
	 Enrollment en2 = new Enrollment(null, StatusSubject.COMPLETED,stu1,sub1);
	 Enrollment en3 = new Enrollment(null, StatusSubject.FAILED,stu3,sub3);
	 Enrollment en4 = new Enrollment(null, StatusSubject.INPROGRESS,stu2,sub5);
	 Enrollment en5 = new Enrollment(null, StatusSubject.COMPLETED,stu3,sub4);
	 Enrollment en6 = new Enrollment(null, StatusSubject.INPROGRESS,stu1,sub3);
	 Enrollment en7 = new Enrollment(null, StatusSubject.COMPLETED,stu2,sub1);
	 
	 subjectRepository.saveAll(Arrays.asList(sub1,sub2,sub3,sub4,sub5));
	 enrollmentRepository.saveAll(Arrays.asList(en1,en2,en3,en4,en5,en6,en7)); 
	 
	 
	}

	
	
}
