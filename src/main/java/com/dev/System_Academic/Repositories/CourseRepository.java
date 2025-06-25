package com.dev.System_Academic.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.System_Academic.Entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
