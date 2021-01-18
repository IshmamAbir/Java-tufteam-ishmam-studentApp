package com.example.tufteamishmam.service;

import com.example.tufteamishmam.dto.CourseDto;
import com.example.tufteamishmam.entity.Course;
import com.example.tufteamishmam.repository.CourseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    public List<CourseDto> getAllCourse() {
        List<Course> courseList=courseRepository.findAllByEnabledTrue();
        List<CourseDto> courseDtoList=new ArrayList<>();
        for (Course course:courseList) {
            CourseDto courseDto=new CourseDto();
            BeanUtils.copyProperties(course,courseDto);
            courseDtoList.add(courseDto);
        }
        return courseDtoList;
    }

    public CourseDto findById(long subjectId) {
        Optional<Course> optionalCourse=courseRepository.findById(subjectId);
        Course course=optionalCourse.get();
        CourseDto courseDto=new CourseDto();
        BeanUtils.copyProperties(course,courseDto);
        return courseDto;
    }
}
