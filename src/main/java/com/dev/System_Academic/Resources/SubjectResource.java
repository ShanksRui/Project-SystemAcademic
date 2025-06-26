package com.dev.System_Academic.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.System_Academic.Entities.Subject;
import com.dev.System_Academic.Services.SubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectResource {

	@Autowired
	private SubjectService service;
	
	@GetMapping()
	public ResponseEntity<List<Subject>> findAll(){
		List<Subject> subjects = service.findAll();
		return ResponseEntity.ok().body(subjects);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Subject> findById(@PathVariable Long id){
		Subject obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
}
  }
