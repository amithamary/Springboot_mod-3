package com.relations.jpamanytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relations.jpamanytomany.model.Course;

@Repository
public interface Courserepo extends JpaRepository<Course, Long>{

//	Course findprize(double fee);

}
