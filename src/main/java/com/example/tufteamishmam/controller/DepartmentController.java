package com.example.tufteamishmam.controller;

import com.example.tufteamishmam.dto.CourseDto;
import com.example.tufteamishmam.dto.DepartmentDto;
import com.example.tufteamishmam.dto.StudentDto;
import com.example.tufteamishmam.entity.Course;
import com.example.tufteamishmam.entity.Department;
import com.example.tufteamishmam.entity.Student;
import com.example.tufteamishmam.service.CourseService;
import com.example.tufteamishmam.service.DepartmentService;
import com.example.tufteamishmam.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;

    @GetMapping("/showAll")
    public String showAllDepartment(Model model){
        List<Department> departmentList=departmentService.showAllDepartment();
        List<DepartmentDto> departmentDtoList=new ArrayList<>();
        for (Department department:departmentList) {
            DepartmentDto departmentDto=new DepartmentDto();
            BeanUtils.copyProperties(department,departmentDto);
            departmentDtoList.add(departmentDto);
        }
        model.addAttribute("departmentDtoList",departmentDtoList);

        return "department/showAllDepartment";
    }

    @GetMapping("/add")
    public String addDepartment(Model model){
        model.addAttribute("departmentDto",new DepartmentDto());
        model.addAttribute("courseListDto",courseService.getAllCourse());
        model.addAttribute("studentListDto",studentService.findAllStudent());
        return "department/add-department";
    }

    @PostMapping("/save")
    public String saveDepartment(@ModelAttribute DepartmentDto departmentDto){
        Department department = departmentService.saveDepartmentObjectCheck(departmentDto);
        BeanUtils.copyProperties(departmentDto,department);
        List<Student> studentList = new ArrayList<>();
        for (long studentId : departmentDto.getStudentIdList()) {
            StudentDto studentDto = studentService.findStudentById(studentId);
            Student student=new Student();
            BeanUtils.copyProperties(studentDto,student);
            studentList.add(student);
        }
        department.setStudentList(studentList);
        List<Course> courseList = new ArrayList<>();
        for (long subjectId : departmentDto.getCourseIdList()) {
            CourseDto courseDto = courseService.findById(subjectId);
            Course course=new Course();
            BeanUtils.copyProperties(courseDto,course);
            courseList.add(course);
        }
        department.setCourseList(courseList);


        departmentService.save(department);
        return "redirect:/department/showAll";
    }

    @GetMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable("id") long id){
        DepartmentDto departmentDto=new DepartmentDto();
        Department department=departmentService.findById(id);
        BeanUtils.copyProperties(department,departmentDto);
        departmentDto.setEnable(false);
        BeanUtils.copyProperties(departmentDto,department);
        departmentService.save(department);
        return "redirect:/department/showAll";
    }

    @GetMapping("/update/{id}")
    public String updateDepartment(@PathVariable("id") long id,Model model){
        Department department=departmentService.findById(id);
        DepartmentDto departmentDto=new DepartmentDto();
        BeanUtils.copyProperties(department,departmentDto);
        model.addAttribute("departmentDto",departmentDto);
        return "department/add-department";
    }
}
