package com.example.tufteamishmam.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;
    @Column
    private String studentName;
    @Column
    private int studentAge;
    @Column
    private String studentGender;
    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departmentId")
    private Department department;*/
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cityId")
    private City city;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "student_department",
            joinColumns = @JoinColumn(name = "studentId"),
            inverseJoinColumns = @JoinColumn(name = "departmentId"))
    private Department department;
    @Column
    private boolean enable=true;
}
