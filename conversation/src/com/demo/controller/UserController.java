package com.demo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.po.User;
import com.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}
	@Resource
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//	@RequestMapping("/user_save")
//	public  String save(Model model){
//		  model.addAttribute("message", "saved!");
//		  System.out.println("sb");
//	      return "successed";
//	}
//	@RequestMapping(params="method=save") 
	@RequestMapping(value="/save") 
	public String save(String name) {
		
		System.out.println(name);
		User user = new User();
		user.setName(name);
		this.userService.save(user);
		return "successed";
	}
}
