package com.UST.collegeAssignment.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UST.collegeAssignment.Model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findByCollegeName(String collegeName);
    List<Faculty> findByDepartmentNameAndCollegeName(String departmentName, String collegeName);
    Optional<Faculty> findByDepartmentHodNameAndCollegeName(String hodName, String collegeName);
}
