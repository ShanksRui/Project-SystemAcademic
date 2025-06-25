package com.dev.System_Academic.Entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Subject implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private Integer hourQuantity;
	private Double passGrade;
	
	public Subject(Long id, String name, Integer hourQuantity, Double passGrade) {
		this.id = id;
		this.name = name;
		this.hourQuantity = hourQuantity;
		this.passGrade = passGrade;
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

	public Integer getHourQuantity() {
		return hourQuantity;
	}

	public void setHourQuantity(Integer hourQuantity) {
		this.hourQuantity = hourQuantity;
	}

	public Double getPassGrade() {
		return passGrade;
	}

	public void setPassGrade(Double passGrade) {
		this.passGrade = passGrade;
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
		Subject other = (Subject) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
