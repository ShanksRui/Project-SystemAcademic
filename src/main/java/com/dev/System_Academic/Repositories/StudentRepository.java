package com.dev.System_Academic.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.System_Academic.Entities.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

}
