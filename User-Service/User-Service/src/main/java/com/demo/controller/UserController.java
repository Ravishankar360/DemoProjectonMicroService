package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Exception.BusinessException;
import com.demo.Exception.ControllerException;
import com.demo.Vo.ResponseTemplateVO;
import com.demo.entity.User;
import com.demo.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping("/")
	public ResponseEntity<?> saveDepartment(@RequestBody User user){
		try {
			System.out.println("Start controller saveDepartment method");
			User userSave = this.userServiceImpl.saveUser(user);
			return new ResponseEntity<User>(userSave,HttpStatus.CREATED);
		}catch(BusinessException be) {
			   ControllerException ce = new ControllerException(be.getErrorCode(),be.getErrorMessage());
			   return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<com.demo.Exception.ControllerException>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{depId}")
	public ResponseTemplateVO findByDepartmentId(@PathVariable("depId") Long depId) {
		System.out.println("Start controller findByDepId method");
		return userServiceImpl.getUserwithDepartment(depId);
	}

}
