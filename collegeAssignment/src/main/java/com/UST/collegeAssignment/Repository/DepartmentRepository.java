package com.UST.collegeAssignment.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UST.collegeAssignment.Model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByCollegeName(String collegeName);
    Optional<Department> findByNameAndCollegeName(String name, String collegeName);
    Optional<Department> findByHodNameAndCollegeName(String hodName, String collegeName);
}

