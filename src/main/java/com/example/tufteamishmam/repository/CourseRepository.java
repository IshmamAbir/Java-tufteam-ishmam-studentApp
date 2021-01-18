package com.example.tufteamishmam.repository;

import com.example.tufteamishmam.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    @Query
    List<Course> findAllByEnabledTrue();
}
