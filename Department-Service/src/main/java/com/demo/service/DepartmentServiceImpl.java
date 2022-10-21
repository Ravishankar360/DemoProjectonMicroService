package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Department;
import com.demo.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {
		System.out.println("Save method start");
		return departmentRepository.save(department);
	}

	@Override
	public Department findByDepId(Long depId) {
		System.out.println("Save findByDepId start");
		return departmentRepository.findByDepId(depId);
	}
	
	

}
