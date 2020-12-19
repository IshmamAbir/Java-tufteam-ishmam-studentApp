package com.example.tufteamishmam.service;

import com.example.tufteamishmam.entity.Department;
import com.example.tufteamishmam.entity.Student;
import com.example.tufteamishmam.repository.DepartmentRepository;
import com.example.tufteamishmam.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repo;
    @Autowired
    private DepartmentRepository departmentRepo;

    public List<Student> findAllStudent() {
        return repo.findAllByEnableTrue();

    }

    public Student findStudentById(long id) {
        Optional<Student> studentOptional= repo.findById(id);
        Student student=null;
        if (studentOptional.isPresent()){
            student = studentOptional.get();
        }else {
            student = new Student();
        }
        return student;
    }

    public void saveStudent(Student student) {
        repo.save(student);
    }

    public List<Department> getAllDepartment() {
        return departmentRepo.findAllByEnableTrue();
    }

    public Department findDepartmentById(long department) {
        Optional<Department> optionalDepartment= departmentRepo.findById(department);
        Department department1=optionalDepartment.get();
        return department1;
    }
}
