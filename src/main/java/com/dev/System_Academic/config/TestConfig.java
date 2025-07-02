package com.dev.System_Academic.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dev.System_Academic.Entities.Course;
import com.dev.System_Academic.Entities.Enrollment;
import com.dev.System_Academic.Entities.Student;
import com.dev.System_Academic.Entities.Subject;
import com.dev.System_Academic.Repositories.CourseRepository;
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
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Course co1 = new Course(null, "Computer engineering", 170.0, 0.2, Instant.parse("2023-10-27T10:00:00Z"));
		Course co2 = new Course(null, "Marketing digital", 150.0, 0.15, Instant.parse("2023-10-27T10:00:00Z"));
		courseRepository.saveAll(Arrays.asList(co1, co2));		
		Student stu1 = new Student(null, "mell", Instant.parse("2023-10-28T10:00:00Z"));
		Student stu2 = new Student(null, "nicolle", Instant.parse("2023-10-30T10:00:00Z"));
		Student stu3 = new Student(null, "lisa", Instant.parse("2023-10-26T10:00:00Z"));
		Student stu4 = new Student(null, "jennie", Instant.parse("2023-10-26T10:00:00Z"));    
		
		studentRepository.saveAll(Arrays.asList(stu1, stu2, stu3));		 
		
		
		Subject sub1 = new Subject(null, "computing networks", 16, 5.0, co1);
		Subject sub2 = new Subject(null, "algorithms and logic", 22, 4.5, co1);
		Subject sub3 = new Subject(null, "POO programming", 33, 4.5, co1);
		Subject sub4 = new Subject(null, "advanced calculation", 30, 8.0, co1);
		Subject sub5 = new Subject(null, "database", 19, 5.0, co1);
		
		Subject sub6 = new Subject(null, "Online Media", 16, 5.0, co2);
		Subject sub7 = new Subject(null, "User Experience", 22, 4.5, co2);
		Subject sub8 = new Subject(null, "Paid Media", 33, 4.5, co2);
		subjectRepository.saveAll(Arrays.asList(sub1, sub2, sub3, sub4, sub5,sub6,sub7,sub8));
			
		Enrollment en1 = new Enrollment(null, stu1, sub7);
		en1.getStudentGrade().addAll(Arrays.asList(3.5,6.4,4.2));
		Enrollment en2 = new Enrollment(null, stu2, sub5);
		en2.getStudentGrade().addAll(Arrays.asList(7.1,3.8,2.3));
		Enrollment en3 = new Enrollment(null, stu1, sub6);
		en3.getStudentGrade().addAll(Arrays.asList(8.3,7.5,2.2));
		Enrollment en4 = new Enrollment(null, stu3, sub3);
		en4.getStudentGrade().addAll(Arrays.asList(10.0,2.9,3.0));
		Enrollment en5 = new Enrollment(null ,stu2, sub1);
		en5.getStudentGrade().addAll(Arrays.asList(9.5,1.2,8.7));
		Enrollment en6 = new Enrollment(null, stu3, sub5);
		en6.getStudentGrade().addAll(Arrays.asList(2.1,0.4,2.6));
		Enrollment en7 = new Enrollment(null, stu3, sub2);
		en7.getStudentGrade().addAll(Arrays.asList(3.9,5.0,4.3));
		Enrollment en8 = new Enrollment(null, stu4, sub7);
		en8.getStudentGrade().addAll(Arrays.asList(5.0,6.7,3.1));
		Enrollment en9 = new Enrollment(null, stu4, sub8);
		en9.getStudentGrade().addAll(Arrays.asList(3.9,5.0,2.9));


		enrollmentRepository.saveAll(Arrays.asList(en1, en2, en3, en4, en5, en6, en7,en8,en9));

	}	
}
