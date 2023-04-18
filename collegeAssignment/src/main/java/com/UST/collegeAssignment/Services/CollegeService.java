package com.UST.collegeAssignment.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UST.collegeAssignment.Model.College;
import com.UST.collegeAssignment.Repository.CollegeRepository;

@Service
public class CollegeService {
    @Autowired
    private CollegeRepository collegeRepository;

    public List<College> getAllColleges() {
        List<College> colleges = collegeRepository.findAll();
        return colleges.stream().map(College::new).collect(Collectors.toList());
    }

    public College getCollegeById(Long collegeId) {
        Optional<College> collegeOptional = collegeRepository.findById(collegeId);
        return collegeOptional.isPresent() ? new College() : null;
    }

    public College getCollegeByName(String collegeName) {
        Optional<College> college = collegeRepository.findByName(collegeName);
        return college != null ? new College() : null;
    }

    public College saveCollege(College collegeDTO) {
        College college = new College();
        BeanUtils.copyProperties(collegeDTO, college);
        return new College();
    }

    public College updateCollegeName(Long collegeId, String newName) {
        Optional<College> collegeOptional = collegeRepository.findById(collegeId);
        if (collegeOptional.isPresent()) {
            College college = collegeOptional.get();
            college.setName(newName);
            collegeRepository.save(college);
            return new College();
        } else {
            return null;
        }
    }

    public void deleteCollegeById(Long collegeId) {
        collegeRepository.deleteById(collegeId);
    }
}

