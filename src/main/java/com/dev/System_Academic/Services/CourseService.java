package com.dev.System_Academic.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.System_Academic.Entities.Course;
import com.dev.System_Academic.Repositories.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository repository;
	
	public List<Course> findAll() {
		return repository.findAll();
	}
	public Course findById(Long id) {
		Optional<Course> obj = repository.findById(id);
		return obj.get();
	}
	public Course insert (Course course) {
		return repository.save(course);
	}
}
