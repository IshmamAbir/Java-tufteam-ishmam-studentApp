package com.example.tufteamishmam.service;

import com.example.tufteamishmam.dto.DepartmentDto;
import com.example.tufteamishmam.dto.StudentDto;
import com.example.tufteamishmam.entity.Department;
import com.example.tufteamishmam.entity.Student;
import com.example.tufteamishmam.exception.ResourceNotFoundException;
import com.example.tufteamishmam.repository.CityRepository;
import com.example.tufteamishmam.repository.DepartmentRepository;
import com.example.tufteamishmam.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repo;
    @Autowired
    private DepartmentRepository departmentRepo;
    @Autowired
    private CityRepository cityRepository;

    public List<StudentDto> findAllStudent() {
        List<Student> studentList= repo.findAllByEnableTrue();
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (Student student:studentList) {
            StudentDto studentDto=new StudentDto();
            BeanUtils.copyProperties(student,studentDto);
            studentDtoList.add(studentDto);
        }
        return studentDtoList;
    }

    public StudentDto findStudentById(long id) {
        Optional<Student> studentOptional= repo.findById(id);
        if (studentOptional.isEmpty()){
            throw new ResourceNotFoundException("  User not found with the id :"+id+" to delete");
        }
        Student student=studentOptional.get();
        StudentDto studentDto=new StudentDto();
        BeanUtils.copyProperties(student,studentDto);
        return studentDto;
    }

    public void saveStudent(StudentDto stdto) {
        Optional<Student> studentOptional= repo.findById(stdto.getStudentId());
        Student student=null;
        if (studentOptional.isPresent()){
            student = studentOptional.get();
        }else {
            student = new Student();
        }
        BeanUtils.copyProperties(stdto,student);
//        student.setDepartment(departmentRepo.getOne(stdto.getDepartment()));
        student.setCity(cityRepository.getOne(stdto.getCityId()));
        repo.save(student);
    }

    public List<DepartmentDto> getAllDepartment() {
        List<Department> departmentList= departmentRepo.findAllByEnableTrue();
        List<DepartmentDto> departmentDtoList = new ArrayList<>();
        for (Department department:departmentList) {
            DepartmentDto departmentDto=new DepartmentDto();
            BeanUtils.copyProperties(department,departmentDto);
            departmentDtoList.add(departmentDto);
        }
        return departmentDtoList;
    }

    public List<StudentDto> showAllStudent() {
        List<Student> studentList= repo.findAllByEnableTrue();
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (Student student:studentList) {
            StudentDto studentDto=new StudentDto();
            BeanUtils.copyProperties(student,studentDto);
//            studentDto.setDepartmentName(student.getDepartment().getDepartmentName());
            studentDto.setCityName(student.getCity().getCityName());
            studentDto.setCityCode(student.getCity().getCityCode());
            studentDtoList.add(studentDto);
        }
        return studentDtoList;
    }


}
