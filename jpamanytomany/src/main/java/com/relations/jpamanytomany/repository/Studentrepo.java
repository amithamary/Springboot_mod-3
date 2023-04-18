package com.relations.jpamanytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relations.jpamanytomany.model.Student;

@Repository
public interface Studentrepo extends JpaRepository<Student, Long> {

//	Student findByNameContaining(String name);

	

}
