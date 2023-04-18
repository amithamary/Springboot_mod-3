package com.colleges.collegedetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colleges.collegedetails.model.College;

@Repository
public interface Collegerepo extends JpaRepository<College, Integer> {

}
