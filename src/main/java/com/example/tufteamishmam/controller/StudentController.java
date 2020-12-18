package com.example.tufteamishmam.controller;

import com.example.tufteamishmam.dto.StudentDto;
import com.example.tufteamishmam.entity.Student;
import com.example.tufteamishmam.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/show-all")
    public String showStudent(Model model){
        List<Student> studentList = studentService.findAllStudent();
        List<StudentDto> studentDtoList=getStudentDtoList(studentList);
        model.addAttribute("studentDtoList",studentDtoList);

        return "student/showAllStudent";
    }

    @GetMapping("/add")
    public String addStudent(Model model){
        List<String> gender=getGenderList();
        model.addAttribute("genderList",gender);

        model.addAttribute("studentDto",new StudentDto());

        return "student/add-student";
    }








    // ------------------------- Helper Method --------------------------

    public List<String> getGenderList(){
        List<String> gender=new ArrayList<>();
        gender.add("Male");
        gender.add("Female");
        return gender;
    }

    public List<StudentDto> getStudentDtoList(List<Student> studentList){
        List<StudentDto> studentDtoList=new ArrayList<>();
        for (Student student:studentList) {
            StudentDto studentDto=new StudentDto();
            BeanUtils.copyProperties(student,studentDto);
            studentDtoList.add(studentDto);
        }
        return studentDtoList;
    }

}
