package com.example.tufteamishmam.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.List;

@Data
public class StudentDto {
    private long studentId;
    private String studentName;
    private int studentAge;
    private String studentGender;
    /*private long department;
    private String departmentName;*/
    private long cityId;
    private String cityName;
    private String cityCode;
    private boolean enable=true;
    private DepartmentDto departmentDto;
}
