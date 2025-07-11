package com.dev.System_Academic.Resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	@GetMapping("/{id}")
	public ResponseEntity<Student> findById(@PathVariable Long id){
		Student obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	public ResponseEntity<Student> insert(@RequestBody Student stu){
		Student student = service.insert(stu);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(student.getId()).toUri();
		return ResponseEntity.created(uri).body(student);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student){
		Student obj = service.Update(id, student);
		return ResponseEntity.ok().body(obj);
	}
}
