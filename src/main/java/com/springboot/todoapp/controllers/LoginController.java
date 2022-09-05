package com.springboot.todoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.todoapp.service.TodoService;

@Controller
public class LoginController {
	
	@Autowired
	TodoService todoService;
	

	@GetMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@GetMapping(value="/")
    public String showWelcomePage(ModelMap model){
		model.put("username", todoService.getUserName());
		System.out.println("inside /");
        return "index";
    }
}
