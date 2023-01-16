package com.rktirtho.restdatafilter.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.rktirtho.restdatafilter.model.Teacher;
import com.rktirtho.restdatafilter.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

import static com.rktirtho.restdatafilter.utils.JsonUtils.jsonValueIgnore;
import static com.rktirtho.restdatafilter.utils.JsonUtils.jsonValueInclude;

@RestController
@RequestMapping("/dynamicFilter/teachers")
public class DynamicFilterController {
    private final TeacherService service;

    public DynamicFilterController(TeacherService service) {
        this.service = service;
    }

    @GetMapping()
    public List<Teacher> getAllTeacher() {

        final String filterName = "SomeBeanFilter";
        final List<Teacher> allTeacher = service.getAllTeacher();

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(allTeacher);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("phoneNumber");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);

        return allTeacher;
    }

    @GetMapping("/{id}")
    public MappingJacksonValue getTeacherInfoForStudents(@PathVariable int id) {

        final String filterName = "SomeBeanFilter";
        Teacher teacher = service.getAllTeacher().stream()
                .filter(teacher1 -> teacher1.getId() == id)
                .findFirst()
                .orElseThrow(
                        () -> new InputMismatchException("Data not found")
                );

        final String[] fields = {"address", "lastDegree"};

        return jsonValueIgnore(filterName, teacher, fields);
    }

    @GetMapping("/{id}/students")
    public MappingJacksonValue getTeacherInfo(@PathVariable int id) {

        Teacher teacher = service.getAllTeacher().stream()
                .filter(teacher1 -> teacher1.getId() == id)
                .findFirst()
                .orElseThrow(
                        () -> new InputMismatchException("Data not found")
                );
        final String[] fields = {"phoneNumber", "lastDegree"};

        return jsonValueInclude("SomeBeanFilter", teacher, fields);
    }

    @GetMapping("test")
    public Map<String, String> test() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Uri");
        map.put("user", "Admin");
        return  map;
    }



}
