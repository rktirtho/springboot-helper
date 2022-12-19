package com.rktirtho.restdatafilter.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("SomeBeanFilter")
public class Teacher {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String lastDegree;
    private String email;
    private String phoneNumber;
    private String address;
}
