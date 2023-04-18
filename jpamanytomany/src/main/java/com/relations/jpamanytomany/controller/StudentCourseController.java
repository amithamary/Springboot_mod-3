package com.relations.jpamanytomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relations.jpamanytomany.model.Course;
import com.relations.jpamanytomany.model.Student;
import com.relations.jpamanytomany.repository.Courserepo;
import com.relations.jpamanytomany.repository.Studentrepo;

@RestController
@RequestMapping("/stdcrs/info")
public class StudentCourseController {
	@Autowired
	private Studentrepo srepo;
	
	
	
	@PostMapping
	public Student save(@RequestBody Student std)
	{
		return srepo.save(std);
	}
	
	@GetMapping
	public List<Student> retrieve()
	{
		return srepo.findAll();
	}
	
//	@GetMapping("/sget/{id}")
//	public Student getById(@PathVariable Long id)
//	{
//		return srepo.findById(id).orElse(null);
//	}
//	
//	@GetMapping("sret/{name}")
//	public Student getByName(@PathVariable String name)
//	{
//		return srepo.findByNameContaining(name);
//				
//	}
//	@GetMapping("crs/{prize}")
//	public Course prize(@PathVariable double fee)
//	{
//		return crepo.findprize(fee);
//	}
//	

}
