package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Department;
import com.demo.service.DepartmentServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
	
	@Autowired
	private DepartmentServiceImpl departmentServiceImpl;
	
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department){
	    System.out.println("Start controller saveDepartment method");
		return this.departmentServiceImpl.saveDepartment(department);
	}
	
	@GetMapping("/{depId}")
	public Department findByDepartmentId(@PathVariable("depId") Long depId) {
		System.out.println("Start controller findByDepId method");
		return departmentServiceImpl.findByDepId(depId);
	}
	

}
