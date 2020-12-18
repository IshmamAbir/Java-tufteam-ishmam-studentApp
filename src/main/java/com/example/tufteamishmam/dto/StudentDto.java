package com.example.tufteamishmam.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class StudentDto {
    private long studentId;
    private String studentName;
    private String studentAge;
    private String studentGender;
//    private Department department;
    private boolean enable=true;
}
