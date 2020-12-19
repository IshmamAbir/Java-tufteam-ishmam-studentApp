package com.example.tufteamishmam.service;

import com.example.tufteamishmam.dto.DepartmentDto;
import com.example.tufteamishmam.entity.Department;
import com.example.tufteamishmam.repository.DepartmentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository repo;

    public List<Department> showAllDepartment() {
        return repo.findAllByEnableTrue();

    }

    public Department saveDepartmentObjectCheck(DepartmentDto departmentDto) {
        Optional<Department> optionalDepartment=repo.findById(departmentDto.getDepartmentId());
        Department department;
        department = optionalDepartment.orElseGet(Department::new);
        return department;
    }

    public Department findById(long id) {
        Optional<Department> optionalDepartment=repo.findById(id);
        Department department=optionalDepartment.get();
        return department;

    }

    public void save(Department department) {
        repo.save(department);
    }
}
