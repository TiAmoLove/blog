package com.blog.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.service.UserService;

@RestController
@RequestMapping("/user")
public class TestUserController {

	@Autowired
	UserService userService;
	
	
	@RequestMapping("/test")
	@ResponseBody
	public String testUserAll() {
		
		return userService.selectAllUser().toString();
		
	}
	
	
}
