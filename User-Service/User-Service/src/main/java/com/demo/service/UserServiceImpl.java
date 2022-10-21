package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.Vo.Department;
import com.demo.Vo.ResponseTemplateVO;
import com.demo.entity.User;
import com.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public User saveUser(User user) {
	    System.out.println("Inside userService method saveUser() ..");
		return userRepository.save(user);
	}
	
	public ResponseTemplateVO getUserwithDepartment(Long userId) {
		ResponseTemplateVO response = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);
		ResponseEntity<Department> department = restTemplate.getForEntity("http://localhost:9095/departments/"+user.getUserId(),Department.class);
	    response.getUser();
	    response.getDepartment();
		return response;
	}
	

}
