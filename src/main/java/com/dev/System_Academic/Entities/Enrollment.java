package com.dev.System_Academic.Entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.dev.System_Academic.Entities.Enum.StatusSubject;
import com.fasterxml.jackson.annotation.JsonBackReference;

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
	@JsonBackReference
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;
	
   public Enrollment() {
	   
   }
	
	public Enrollment(Long id,Student student,Subject sub) {
		this.id = id;
        this.student = student;
        this.subject = sub;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StatusSubject getStatus() {
		int valueFinal = Generatedstatus();
		this.status = valueFinal;
		return  StatusSubject.StatusCodeValue(status);
	}

	private int Generatedstatus() {
		if (!StudentGrade.isEmpty()) {
			double value = getFinalGrade();		
		if(value < subject.getPassGrade()) {
			return StatusSubject.FAILED.getCode();
		}else if(value > subject.getPassGrade()){
			return  StatusSubject.COMPLETED.getCode();
	    }	
		}else if(StudentGrade.isEmpty()) {
			return StatusSubject.INPROGRESS.getCode();
		}
		return status;

	}	
	public List<Double> getStudentGrade() {
		return StudentGrade;
	}
	
	public Double getFinalGrade() {
	Double result = StudentGrade.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
	BigDecimal bd = BigDecimal.valueOf(result);
    bd = bd.setScale(2, RoundingMode.HALF_UP);
	return bd.doubleValue();
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
