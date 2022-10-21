package com.demo.service;

import com.demo.entity.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department);
	public Department findByDepId(Long depId);
	
}
