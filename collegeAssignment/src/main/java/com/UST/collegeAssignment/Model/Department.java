package com.UST.collegeAssignment.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Faculty> faculties;

    @OneToOne
    @JoinColumn(name = "hod_id")
    private Faculty hod;

    @ManyToOne
    @JoinColumn(name = "college_id")
    private College college;

	public Department(Long id, String name, List<Faculty> faculties, Faculty hod, College college) {
		
		this.id = id;
		this.name = name;
		this.faculties = faculties;
		this.hod = hod;
		this.college = college;
	}
	public Department()
	{
		
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
	public List<Faculty> getFaculties() {
		return faculties;
	}
	public void setFaculties(List<Faculty> faculties) {
		this.faculties = faculties;
	}
	public Faculty getHod() {
		return hod;
	}
	public void setHod(Faculty hod) {
		this.hod = hod;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}

    
}
