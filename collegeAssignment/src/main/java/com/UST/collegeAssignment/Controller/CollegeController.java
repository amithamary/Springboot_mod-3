package com.UST.collegeAssignment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.UST.collegeAssignment.Model.College;
import com.UST.collegeAssignment.Services.CollegeService;

@RestController
@RequestMapping("/api/colleges")
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    @PostMapping
    public College addCollege(@RequestBody College collegeDTO) {
        return collegeService.addCollege(collegeDTO);
    }

    @GetMapping
    public List<College> getAllColleges() {
        return collegeService.getAllColleges();
    }

    @GetMapping("/{collegeId}")
    public College getCollegeById(@PathVariable Long collegeId) {
        return collegeService.getCollegeById(collegeId);
    }

    @GetMapping("/search")
    public College getCollegeByName(@RequestParam String name) {
        return collegeService.getCollegeByName(name);
    }

    @PutMapping("/{collegeId}")
    public College updateCollegeName(@PathVariable Long collegeId, @RequestParam String name) {
        return collegeService.updateCollegeName(collegeId, name);
    }

    @DeleteMapping("/{collegeId}")
    public void deleteCollege(@PathVariable Long collegeId) {
        collegeService.deleteCollege(collegeId);
    }
}
