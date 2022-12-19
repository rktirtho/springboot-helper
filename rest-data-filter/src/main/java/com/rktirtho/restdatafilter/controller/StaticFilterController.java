package com.rktirtho.restdatafilter.controller;

import com.rktirtho.restdatafilter.model.Student;
import com.rktirtho.restdatafilter.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/static_controller/students")
@RequiredArgsConstructor
public class StaticFilterController {

    private StudentService service;

    @Autowired
    public StaticFilterController(StudentService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Student> getAllStudent() {
        return service.getAllStudent();
    }


}
