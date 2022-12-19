package com.rktirtho.restdatafilter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonIncludeProperties({"field 1", "field2"})
//@JsonIgnoreProperties({"field 1", "field2"})
public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    @JsonProperty("registrationNumber") //Change the property name during rest response
    private String regNo;

}
