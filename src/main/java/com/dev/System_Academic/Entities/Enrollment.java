package com.dev.System_Academic.Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.dev.System_Academic.Entities.Enum.StatusSubject;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;
	
	public Enrollment() {
		
	}
	
	public Enrollment(Long id, StatusSubject status,Student student) {
		this.id = id;
		setStatus(status);
        this.student = student;
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
	
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject sub) {
		this.subject = sub;
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
