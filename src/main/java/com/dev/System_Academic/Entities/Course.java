package com.dev.System_Academic.Entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
@Entity
public class Course implements Serializable{
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private Double monthlyPayment;
	private Double fee;
	
	
    @JsonFormat(shape = Shape.STRING,pattern = "yyyy:MM:dd'T'HH:mm:ss'Z'",timezone = "UTC")
	private Instant limitDatePayment;
	
  
    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private Set<Subject> subjects = new HashSet<>();
    
    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private Set<Student> students = new HashSet<>();
    
	public Course() {
		
	}
	
	public Course(Long id, String name, Double monthlyPayment, Double fee, Instant limitDatePayment) {
		this.id = id;
		this.name = name;
		this.monthlyPayment = monthlyPayment;
		this.fee = fee;
		this.limitDatePayment = limitDatePayment;
	}

	public Set<Student> getStudents(){
		return students;
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

	public Double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(Double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	public Instant getLimitDatePayment() {
		return limitDatePayment;
	}

	public void setLimitDatePayment(Instant limitDatePayment) {
		this.limitDatePayment = limitDatePayment;
	}
	
	public Set<Subject> getSubjects(){
		return subjects;
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
		Course other = (Course) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
