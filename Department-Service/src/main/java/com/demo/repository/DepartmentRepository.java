package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	Department findByDepId(Long depId);

}
