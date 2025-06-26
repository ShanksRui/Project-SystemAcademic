package com.dev.System_Academic.Entities;

import java.util.Objects;

import org.hibernate.annotations.ManyToAny;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

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
	private Double gradeAverage;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	public Enrollment() {
		
	}
	
	public Enrollment(Long id, StatusSubject status, Double gradeAverage,Student student) {
		this.id = id;
		setStatus(status);
		this.gradeAverage = gradeAverage;
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

	public Double getGradeAverage() {
		return gradeAverage;
	}

	public void setGradeAverage(Double gradeAverage) {
		this.gradeAverage = gradeAverage;
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
