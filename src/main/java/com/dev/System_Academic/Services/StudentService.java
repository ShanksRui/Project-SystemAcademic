package com.dev.System_Academic.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.System_Academic.Entities.Student;
import com.dev.System_Academic.Repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;
	
	public List<Student> findAll() {
		return repository.findAll();
	}
	
	public Student findById(Long id) {
		Optional<Student> obj = repository.findById(id);
		return obj.get();
	}
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	public Student Update(Long id,Student student) {
		Student entity = repository.getReferenceById(id);
		updateStudent(entity,student);
		return repository.save(entity);
	}

	private void updateStudent(Student entity, Student student) {
		entity.setName(student.getName());
		entity.setPaymentCourse(student.getPaymentCourse());
		entity.setDatePayment(student.getdatePayment());
		
	}
}
