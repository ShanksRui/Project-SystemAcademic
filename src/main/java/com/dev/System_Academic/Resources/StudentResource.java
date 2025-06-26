package com.dev.System_Academic.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.System_Academic.Entities.Student;
import com.dev.System_Academic.Services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentResource {

	@Autowired
	private StudentService service;
	
	@GetMapping()
	public ResponseEntity<List<Student>> findAll(){
		List<Student> students = service.findAll();
		return ResponseEntity.ok().body(students);
	}
	
}
