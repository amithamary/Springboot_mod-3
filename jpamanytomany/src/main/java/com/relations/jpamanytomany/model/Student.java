package com.relations.jpamanytomany.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Student {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private int age;
	private String dept;
	

	@ManyToMany (fetch= FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinTable(	name="STUDENT_COURSE_TABLE", 
				joinColumns= {@JoinColumn(name="std_id", referencedColumnName = "id")},
				inverseJoinColumns = {@JoinColumn(name="c_id", referencedColumnName = "id")})

	@JsonBackReference
	private Set <Course> courses;


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


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public Set<Course> getCourses() {
		return courses;
	}


	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}


	public Student(Long id, String name, int age, String dept, Set<Course> courses) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.dept = dept;
		this.courses = courses;
	}
	
	
	

}
