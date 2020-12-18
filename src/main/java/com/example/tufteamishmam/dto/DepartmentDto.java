package com.example.tufteamishmam.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class DepartmentDto {

    private long departmentId;
    private String departmentName;
    private String departmentCode;
    private boolean enable=true;
}
