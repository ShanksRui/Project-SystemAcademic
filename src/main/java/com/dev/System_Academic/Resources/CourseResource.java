package com.dev.System_Academic.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.System_Academic.Entities.Course;
import com.dev.System_Academic.Services.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseResource {

	@Autowired
	private CourseService service;
	
	@GetMapping()
	public ResponseEntity<List<Course>> findAll(){
		List<Course> courses = service.findAll();
		return ResponseEntity.ok().body(courses);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Course> findById(@PathVariable Long id){
		Course obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
