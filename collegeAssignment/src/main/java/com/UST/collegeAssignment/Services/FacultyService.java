package com.UST.collegeAssignment.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UST.collegeAssignment.Model.Faculty;
import com.UST.collegeAssignment.Repository.FacultyRepository;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    public List<Faculty> getFacultiesByCollegeName(String collegeName) {
        List<Faculty> faculties = facultyRepository.findByCollegeName(collegeName);
        return faculties.stream().map(Faculty::new).collect(Collectors.toList());
    }

    public List<Faculty> getFacultiesByDepartmentNameAndCollegeName(String departmentName, String collegeName) {
        List<Faculty> faculties = facultyRepository.findByDepartmentNameAndCollegeName(departmentName, collegeName);
        return faculties.stream().map(Faculty::new).collect(Collectors.toList());
    }

    public Faculty getHodByDepartmentNameAndCollegeName(String departmentName, String collegeName) {
        Faculty hod = facultyRepository.findHodByDepartmentNameAndCollegeName(departmentName, collegeName);
        return hod != null ? new Faculty(hod) : null;
    }

    public Faculty saveFaculty(Faculty facultyDTO) {
        Faculty faculty = new Faculty();
        BeanUtils.copyProperties(facultyDTO, faculty);
        return new Faculty(facultyRepository.save(faculty));
    }

    public void deleteFaculty(Long facultyId) {
        facultyRepository.deleteById(facultyId);
    }
}

