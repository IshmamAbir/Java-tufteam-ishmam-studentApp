package com.example.tufteamishmam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

    private long courseId;
    private String courseCode;
    private String courseName;
    private boolean enabled=true;
}
