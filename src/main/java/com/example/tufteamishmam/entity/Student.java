package com.example.tufteamishmam.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;
    @Column
    private String studentName;
    @Column
    private String studentAge;
    @Column
    private String studentGender;
    /*@Column
    private Department department;*/
    @Column
    private boolean enable=true;
}
