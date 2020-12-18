package com.example.tufteamishmam.service;

import com.example.tufteamishmam.entity.Student;
import com.example.tufteamishmam.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repo;

    public List<Student> findAllStudent() {
        return repo.findAllByEnableTrue();
    }
}
