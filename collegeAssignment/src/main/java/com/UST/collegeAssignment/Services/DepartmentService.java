package com.UST.collegeAssignment.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UST.collegeAssignment.Model.Department;
import com.UST.collegeAssignment.Repository.DepartmentRepository;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getDepartmentsByCollegeName(String collegeName) {
        List<Department> departments = departmentRepository.findByCollegeName(collegeName);
        return departments.stream().map(Department::new).collect(Collectors.toList());
    }

    public Department saveDepartment(Department departmentDTO) {
        Department department = new Department();
        BeanUtils.copyProperties(departmentDTO, department);
        return new Department();
    }

    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
