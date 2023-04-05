package com.thiruacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiruacademy.entity.Department;
import com.thiruacademy.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/save")
	public Department saveDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable Long id) {
		return departmentService.getDepartmentById(id);
	}
}
