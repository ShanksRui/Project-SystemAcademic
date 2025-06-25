package com.dev.System_Academic.Entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double paymentCourse;
	private LocalDate datePayment;
	
	public Student() {
		
	}
	
	public Student(Long id, String name, LocalDate datePayment,Double paymentCourse) {
		this.id = id;
		this.name = name;
		this.datePayment = datePayment;
		this.paymentCourse = paymentCourse;
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

	public LocalDate getdatePayment() {
		return datePayment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public Double getPaymentCourse() {
		return paymentCourse;
	}

	public void setPaymentCourse(Double paymentCourse) {
		this.paymentCourse = paymentCourse;
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
