package com.dev.System_Academic.Entities;

import java.util.Objects;

import com.dev.System_Academic.Entities.Enum.StatusSubject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Enrollment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private StatusSubject status;
	private Double gradeAverage;
	
	public Enrollment() {
		
	}
	
	public Enrollment(Long id, StatusSubject status, Double gradeAverage) {
		this.id = id;
		this.status = status;
		this.gradeAverage = gradeAverage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StatusSubject getStatus() {
		return status;
	}

	public void setStatus(StatusSubject status) {
		this.status = status;
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
