package com.relations.jpamanytomany.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Course {
	@Id
	@GeneratedValue

	private Long id;
	private String title;
	private String abrevation;
	private int modules;
	private double fee;
	
	

	@ManyToMany(mappedBy = "courses" , fetch=FetchType.LAZY)
	@JsonBackReference
	private Set <Student> students;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAbrevation() {
		return abrevation;
	}



	public void setAbrevation(String abrevation) {
		this.abrevation = abrevation;
	}



	public int getModules() {
		return modules;
	}



	public void setModules(int modules) {
		this.modules = modules;
	}



	public double getFee() {
		return fee;
	}



	public void setFee(double fee) {
		this.fee = fee;
	}



	public Set<Student> getStudents() {
		return students;
	}



	public void setStudents(Set<Student> students) {
		this.students = students;
	}



	public Course(Long id, String title, String abrevation, int modules, double fee, Set<Student> students) {
		
		this.id = id;
		this.title = title;
		this.abrevation = abrevation;
		this.modules = modules;
		this.fee = fee;
		this.students = students;
	}
	
	

	

	
	

}
