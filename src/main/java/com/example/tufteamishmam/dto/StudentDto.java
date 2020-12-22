package com.example.tufteamishmam.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class StudentDto {
    private long studentId;
    private String studentName;
    private int studentAge;
    private String studentGender;
    private long department;
    private String departmentName;
    private boolean enable=true;
}
