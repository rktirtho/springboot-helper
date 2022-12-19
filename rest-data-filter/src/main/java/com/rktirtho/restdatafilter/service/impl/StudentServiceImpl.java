package com.rktirtho.restdatafilter.service.impl;

import com.rktirtho.restdatafilter.model.Student;
import com.rktirtho.restdatafilter.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    final private List<Student> allStudent = List.of(
            new Student(1, "Sam", "Curran", "email@eg.com", "BE-38723"),
            new Student(1, "Mitchel", "Smith", "mitchel@eg.com", "BE-738473"),
            new Student(1, "Lion", "Pitter", "pitter@eg.com", "BE-45345"),
            new Student(1, "Harry", null, "harry@eg.com", "BE-435435")
    );

    @Override
    public List<Student> getAllStudent() {
        return allStudent;
    }
}
