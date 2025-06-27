package com.dev.System_Academic.Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.dev.System_Academic.Entities.Enum.StatusSubject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Enrollment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer status;
	private List<Double> StudentGrade = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;
	
	public Enrollment() {
		
	}
	
	public Enrollment(Long id, StatusSubject status,Student student,Subject subject) {
		this.id = id;
		setStatus(status);
		this.student = student;
		this.subject = subject;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StatusSubject getStatus() {
		return StatusSubject.StatusCodeValue(status);
	}

	public void setStatus(StatusSubject status) {
		this.status = status.getCode();
	}
	
	public List<Double> getStudentGrade() {
		return StudentGrade;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enrollment other = (Enrollment) obj;
		return Objects.equals(id, other.id);
	}

	
}
