package com.example.tufteamishmam.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Entity")
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
}
