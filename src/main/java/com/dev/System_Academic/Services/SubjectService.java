package com.dev.System_Academic.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.System_Academic.Entities.Subject;
import com.dev.System_Academic.Repositories.SubjectRepository;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepository repository;
	
	public List<Subject> findAll() {
		return repository.findAll();
	}
	
	public Subject findById(Long id) {
		Optional<Subject> obj = repository.findById(id);
		return obj.get();
	}
	
	public Subject insert(Subject subject) {
		return repository.save(subject);
	}
}
