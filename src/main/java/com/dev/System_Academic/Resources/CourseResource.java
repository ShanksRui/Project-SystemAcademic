package com.dev.System_Academic.Resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	@PostMapping
	public ResponseEntity<Course> insert(@RequestBody Course course){
	    Course obj = service.insert(course);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
}
