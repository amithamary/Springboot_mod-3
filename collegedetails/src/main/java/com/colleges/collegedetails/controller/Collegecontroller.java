package com.colleges.collegedetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.colleges.collegedetails.model.College;
import com.colleges.collegedetails.services.Collegeservices;

@RestController
@RequestMapping("/clg/details")
public class Collegecontroller {
	@Autowired
	private Collegeservices clgservices;
	
	@PostMapping("/create")
	public College create(@RequestBody College clg)
	{
		return clgservices.createdata(clg);
	}
	
	@GetMapping("/getall")
	public List <College> getall()
	{
		return clgservices.getdetails();
	}
	
	@GetMapping("/abt/{id}")
	public College getclgbyid(@PathVariable int id)
	{
		return clgservices.getglgbyid(id);
		
	}
	
	@PutMapping("/update/{id}")
//	public College update(@PathVariable College clg)
//	{
//		return clgservices.updatedetails(clg);
//	}
	 public ResponseEntity<College> updateCollege(@PathVariable int id, @RequestBody College clg) {
        College updatedCollege = clgservices.updateCollege(id, clg);
        return ResponseEntity.ok(updatedCollege);
    }
	
	@DeleteMapping("/delete/{id}")
	public String remove(@PathVariable int id)
	{
		clgservices.remove(id);
		return "The corresponding data is removed ";
	}
	
	

}
