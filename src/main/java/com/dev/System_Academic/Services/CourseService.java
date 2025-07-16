package com.dev.System_Academic.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.dev.System_Academic.Entities.Course;
import com.dev.System_Academic.Repositories.CourseRepository;
import com.dev.System_Academic.Services.Exception.DatabaseException;
import com.dev.System_Academic.Services.Exception.ResourceNotFoundException;

@Service
public class CourseService {

	@Autowired
	private CourseRepository repository;
	
	public List<Course> findAll() {
		return repository.findAll();
	}
	public Course findById(Long id) {
		Optional<Course> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	public Course insert (Course course) {
		return repository.save(course);
	}
	public void delete (Long id) {
		 if(!repository.existsById(id)){
	    	   throw new ResourceNotFoundException(id);
	      }try {
	    	  repository.deleteById(id);
	      }catch(DataIntegrityViolationException e ) {
	    	 throw new DatabaseException(e.getMessage());
	      }
	}
}
