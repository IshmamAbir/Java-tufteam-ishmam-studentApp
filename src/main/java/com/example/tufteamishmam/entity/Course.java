package com.example.tufteamishmam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "Course")
@Data
@NoArgsConstructor
@ToString
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courseId;
    @Column
    private String courseCode;
    @Column
    private String courseName;
    @Column
    private boolean enabled=true;

}
