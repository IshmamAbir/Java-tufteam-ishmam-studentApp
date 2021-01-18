package com.example.tufteamishmam.dto;

import com.example.tufteamishmam.entity.Course;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;

@Data
public class DepartmentDto {

    private long departmentId;
    private String departmentName;
    private String departmentCode;
    private boolean enable=true;
    private List<StudentDto> studentDtoList;
    private  List<CourseDto> courseDtoList;

    private List<Long> studentIdList;
    private List<Long> courseIdList;
}
