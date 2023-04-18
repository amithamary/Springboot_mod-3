package com.UST.collegeAssignment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.UST.collegeAssignment.Model.Department;
import com.UST.collegeAssignment.Model.Faculty;
import com.UST.collegeAssignment.Services.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department addDepartment(@RequestBody Department departmentDTO) {
        return departmentService.addDepartment(departmentDTO);
    }

    @GetMapping
    public List<Department> getDepartmentsByCollegeName(@RequestParam String collegeName) {
        return departmentService.getDepartmentsByCollegeName(collegeName);
    }

    @GetMapping("/{departmentId}")
    public Department getDepartmentById(@PathVariable Long departmentId, @RequestParam String collegeName) {
        return departmentService.getDepartmentByIdAndCollegeName(departmentId, collegeName);
    }

    @GetMapping("/search")
    public Department getDepartmentByNameAndCollegeName(@RequestParam String name, @RequestParam String collegeName) {
        return departmentService.getDepartmentByNameAndCollegeName(name, collegeName);
    }

    @GetMapping("/hod")
    public Faculty getHodByDepartmentNameAndCollegeName(@RequestParam String name, @RequestParam String collegeName) {
        return departmentService.getHodByDepartmentNameAndCollegeName(name, collegeName);
    }

    @PostMapping("/{departmentId}/faculties")
    public FacultyDTO addFacultyToDepartment(@PathVariable Long departmentId, @RequestBody FacultyDTO facultyDTO) {
        return departmentService.addFacultyToDepartment(departmentId, facultyDTO);
    }

    @PostMapping("/{departmentId}/hod")
    public FacultyDTO addHodToDepartment(@PathVariable Long departmentId, @RequestParam String name) {
        return departmentService.addHodToDepartment(departmentId, name);
    }
}
