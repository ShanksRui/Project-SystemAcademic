package com.dev.System_Academic.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.System_Academic.Entities.Student;
import com.dev.System_Academic.Repositories.StudentRepository;
import com.dev.System_Academic.Services.Exception.DataIntegrityViolationException;
import com.dev.System_Academic.Services.Exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;
	
	public List<Student> findAll() {
		return repository.findAll();
	}
	
	public Student findById(Long id) {
		Optional<Student> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
}	
	public Student insert(Student student) {
		return repository.save(student);
	}
	
	public void deleteById(Long id) {
      if(!repository.existsById(id)){
    	   throw new ResourceNotFoundException(id);
      }try {
    	  repository.deleteById(id);
      }catch(DataIntegrityViolationException e) {
    	  throw new DataIntegrityViolationException(e.getMessage());
      }
	}
	public Student Update(Long id,Student student) {
		try {
		Student entity = repository.getReferenceById(id);
		updateStudent(entity,student);
		return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);	
		}
	}

	private void updateStudent(Student entity, Student student) {
		entity.setName(student.getName());
		entity.setDatePayment(student.getdatePayment());
		
	}
}
