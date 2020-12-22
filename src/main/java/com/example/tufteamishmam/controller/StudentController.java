package com.example.tufteamishmam.controller;

import com.example.tufteamishmam.dto.DepartmentDto;
import com.example.tufteamishmam.dto.StudentDto;
import com.example.tufteamishmam.entity.Department;
import com.example.tufteamishmam.entity.Student;
import com.example.tufteamishmam.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/show-all")
    public String showStudent(Model model){
        model.addAttribute("studentDtoList",studentService.findAllStudent());

        return "student/showAllStudent";
    }

    @GetMapping("/add")
    public String addStudent(Model model){
        List<String> gender=getGenderList();
        model.addAttribute("genderList",gender);

        model.addAttribute("studentDto",new StudentDto());

        /*List<Department> departmentList=studentService.getAllDepartment();
        List<DepartmentDto> departmentDtoList= getDepartmentDtoList(departmentList);
        model.addAttribute("departmentDtoList",departmentDtoList);*/
        model.addAttribute("departmentDtoList",studentService.getAllDepartment());

        return "student/add-student";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute StudentDto studentDto){
        StudentDto dto=studentService.findStudentById(studentDto.getStudentId());

        DepartmentDto departmentDto=studentService.findDepartmentById(studentDto.getDepartment());
        dto.setDepartment(departmentDto);
        studentService.saveStudent(student);
        return "redirect:/student/show-all";
    }

    @GetMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") long id,Model model){
        StudentDto studentDto=studentService.findStudentById(id);

        model.addAttribute("studentDto",studentDto);
        model.addAttribute("genderList",getGenderList());
        /*List<DepartmentDto> departmentDtoList= getDepartmentDtoList(studentService.getAllDepartment());
        model.addAttribute("departmentDtoList",departmentDtoList);*/
        model.addAttribute("departmentDtoList",studentService.getAllDepartment());

        return "student/add-student";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") long id,Model model){
        Student student=studentService.findStudentById(id);
        StudentDto studentDto=new StudentDto();
        BeanUtils.copyProperties(student,studentDto);

        studentDto.setEnable(false);
        BeanUtils.copyProperties(studentDto,student);
        studentService.saveStudent(student);

        return "redirect:/student/show-all";
    }






    // ------------------------- Helper Method --------------------------

    public List<String> getGenderList(){
        List<String> gender=new ArrayList<>();
        gender.add("Male");
        gender.add("Female");
        return gender;
    }

    /*public List<StudentDto> getStudentDtoList(List<Student> studentList){
        List<StudentDto> studentDtoList=new ArrayList<>();
        for (Student student:studentList) {
            StudentDto studentDto=new StudentDto();
            BeanUtils.copyProperties(student,studentDto);
            studentDtoList.add(studentDto);
        }
        return studentDtoList;
    }*/
    /*public List<DepartmentDto> getDepartmentDtoList(List<Department> departmentList){
        List<DepartmentDto> departmentDtoList = new ArrayList<>();
        for (Department department:departmentList) {
            DepartmentDto departmentDto=new DepartmentDto();
            BeanUtils.copyProperties(department,departmentDto);
            departmentDtoList.add(departmentDto);
        }
        return departmentDtoList;
    }*/

}
