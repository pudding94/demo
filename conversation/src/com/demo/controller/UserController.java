package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
//	@RequestMapping("/user_save")
//	public  String save(Model model){
//		  model.addAttribute("message", "saved!");
//		  System.out.println("sb");
//	      return "successed";
//	}
	@RequestMapping("/user_save")
	public  String save(String name){
//		  model.addAttribute("message", "saved!");
		  System.out.println(name);
	      return "successed";
	}
}
