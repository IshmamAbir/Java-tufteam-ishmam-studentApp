package com.example.tufteamishmam.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Department")
@Data
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long departmentId;
    @Column
    private String departmentName;
    @Column
    private String departmentCode;
    @Column
    private boolean enable=true;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "course_department",
            joinColumns = @JoinColumn(name = "departmentId"),
            inverseJoinColumns = @JoinColumn(name = "courseId"))
    private List<Course> courseList;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "student_department",
            joinColumns = @JoinColumn(name = "departmentId"),
            inverseJoinColumns = @JoinColumn(name = "studentId"))
    private List<Student> studentList;
}
