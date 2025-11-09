package com.tnsif.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.tnsif.college.entity.College;
import com.tnsif.college.service.CollegeService;

@RestController
@RequestMapping("/college/")
public class CollegeController {

    @Autowired
    private CollegeService service;

    // Get all colleges
    @GetMapping
    public List<College> getAllColleges() {
        return service.listAll();
    }

    // Get one college by ID
    @GetMapping("/{id}")
    public College getCollegeById(@PathVariable Integer id) {
        return service.get(id);
    }

    // Add new college
    @PostMapping
    public void addCollege(@RequestBody College college) {
        service.save(college);
    }

    // Update college
    @PutMapping("/{id}")
    public void updateCollege(@PathVariable Integer id, @RequestBody College college) {
        college.setCollegeId(id);
        service.update(college);
    }

    // Delete college
    @DeleteMapping("/{id}")
    public void deleteCollege(@PathVariable Integer id) {
        service.delete(id);
    }
}
