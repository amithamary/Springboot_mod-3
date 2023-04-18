package com.UST.collegeAssignment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.UST.collegeAssignment.Model.Faculty;
import com.UST.collegeAssignment.Services.FacultyService;

@RestController
@RequestMapping("/api/faculties")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping
    public List<Faculty> getFacultiesByCollegeName(@RequestParam String collegeName) {
        return facultyService.getFacultiesByCollegeName(collegeName);
    }

    @GetMapping("/department")
    public List<Faculty> getFacultiesByDepartmentNameAndCollegeName(@RequestParam String departmentName, @RequestParam String collegeName) {
        return facultyService.getFacultiesByDepartmentNameAndCollegeName(departmentName, collegeName);
    }

    @GetMapping("/hod")
    public Faculty getHodByDepartmentNameAndCollegeName(@RequestParam String departmentName, @RequestParam String collegeName) {
        return facultyService.getHodByDepartmentNameAndCollegeName(departmentName, collegeName);
    }
}
