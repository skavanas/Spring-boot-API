package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;




@Entity
@Table
public class Student {
	
	@Id
	@SequenceGenerator(name="Student_Sequence",sequenceName="Student_Sequence",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="Student_Sequence")
	private String name;
	private  String email;
	private double id;
	@Transient           // the age will be removed from the DB and it will be calculated
	private Integer age;
	private LocalDate dob;
	
	
	public Student(String name, String email, double id, LocalDate dob) {
		super();
		this.name = name;
		this.email = email;
		this.id = id;
		this.dob = dob;
	}
	
	
	public Student(String name, String email,  LocalDate dob) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getId() {
		return id;
	}
	public void setId(double id) {
		this.id = id;
	}
	public Integer getAge() {
		return Period.between(this.dob,LocalDate.now()).getYears();
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", email=" + email + ", id=" + id + ", age=" + age + ", dob=" + dob + "]";
	}
	
	
		
}
