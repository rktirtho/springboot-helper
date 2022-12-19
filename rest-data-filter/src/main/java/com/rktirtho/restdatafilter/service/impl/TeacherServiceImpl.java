package com.rktirtho.restdatafilter.service.impl;

import com.rktirtho.restdatafilter.model.Teacher;
import com.rktirtho.restdatafilter.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {



    final private List<Teacher> teachers = List.of(
            new Teacher(1, "Mack", "Albert", "John", "MS", "user1@eg.com", "7384304", "Us sj"),
            new Teacher(2, "Colon", "Mark", "Azam", "BS", "user2@eg.com", "834320948", "Us sj"),
            new Teacher(3, "Jonny", "Adam", "Ken", "MS", "user3@eg.com", "54545", "Us sj"),
            new Teacher(4, "Pitter", "Jorge", "Mik", "CS", "user4@eg.com", "738445454304", "Us sj")
    );

    @Override
    public List<Teacher> getAllTeacher() {
        return teachers;
    }
}
