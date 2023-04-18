package com.colleges.collegedetails.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colleges.collegedetails.model.College;
import com.colleges.collegedetails.repository.Collegerepo;

@Service
public class Collegeservices {
	@Autowired
	private Collegerepo repo;
	
	public College createdata(College clg) {
		
		return repo.save(clg);
	}

	public List<College> getdetails() {
	
		return repo.findAll();
	}

	public College getglgbyid(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}
	
	public College updateCollege(int id, College clg) {
		 College existingCollege = repo.findById(id)
	                .orElse(null);

	        existingCollege.setName(clg.getName());
	        existingCollege.setType(clg.getType());
	        existingCollege.setLocation(clg.getLocation());

	        College updatedCollege = repo.save(existingCollege);
	        return updatedCollege;
	    }
	
	
	

	
	public void remove(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

	
	

}
