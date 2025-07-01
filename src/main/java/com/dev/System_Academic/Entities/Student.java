package com.dev.System_Academic.Entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	

	
	@JsonFormat(shape = Shape.STRING,pattern = "yyyy-MM-dd:'T'HH:mm:ss'Z'",timezone = "UTC")
	private Instant datePayment;
	
	@OneToMany(mappedBy = "student")
	@JsonManagedReference
	private Set<Enrollment> enrollments = new HashSet<>();
	
	@ManyToOne()
	@JsonBackReference
	private Course course;
	
	public Student() {
		
	}
	
	public Student(Long id, String name, Instant datePayment) {
		this.id = id;
		this.name = name;
		this.datePayment = datePayment;
	}
	
	public Double getTotalPriceRegistration() {
		double tax = course.getMonthlyPayment() * course.getFee();
		for(Enrollment en :enrollments) {
			if(course.getSubjects().contains(en.getSubject()) 
			&& datePayment.isAfter(course.getLimitDatePayment())) {	
			return tax += course.getMonthlyPayment();  	 
		}		
	}		
	return course.getMonthlyPayment();
}
	public Set<Enrollment> getEnrollments(){
		return enrollments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Instant getdatePayment() {
		return datePayment;
	}
	

	public void setDatePayment(Instant datePayment) {
		this.datePayment = datePayment;
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
		Student other = (Student) obj;
		return Objects.equals(id, other.id);
	}
}
