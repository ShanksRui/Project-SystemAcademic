package com.dev.System_Academic.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.System_Academic.Entities.Enrollment;
import com.dev.System_Academic.Repositories.EnrollmentRepository;

@Service
public class EnrollmentService {

	@Autowired
	private EnrollmentRepository repository;
	
	public List<Enrollment> findAll() {
		return repository.findAll();
	}
	
	public Enrollment findById(Long id) {
		Optional<Enrollment> obj = repository.findById(id);
		return obj.get();
	}
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
}
