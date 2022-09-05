package com.springboot.todoapp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.springboot.todoapp.entity.Todo;
import com.springboot.todoapp.service.TodoService;

@Controller
public class TodoItemController {
	
	@Autowired
	TodoService todoService;
	

	@GetMapping("/todo-list")
	public String todoList(ModelMap model) {
		try {
			model.put("todolist", todoService.getTodoList());
			
			return "todo-list";
		}catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "error";
		}
		
	}
	
	@GetMapping("/add-todo")
	public String showCreateForm(Model model) {
		model.addAttribute("todo", new Todo());
		return "add-todo-item";
	}
	
	@PostMapping("/save-todo")
	public String createTodoItem(@Valid Todo todo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "add-todo-item"; 
		}
		try {
			todoService.saveTodo(todo);		
			return "redirect:/todo-list";
		}catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "error";
		}
		
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		
		try {
			Todo todo = todoService.getTodoById(id);
			model.addAttribute("todo", todo);
			return "update-todo-item";
		}catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "error";
		}
		
	}
	

	@PostMapping("/update-todo/{id}")
	public String updateToDoItem(@PathVariable("id") long id, @Valid Todo todo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			todo.setId(id);
			return "update-todo-item";
		}
		try {
			todoService.updateTodo(todo);
			return "redirect:/todo-list";
		}catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "error";
		}
		
	}
	
	
	@GetMapping("/mark-complete/{id}")
	public String markComplete(@PathVariable("id") long id, Model model) {
		try {
			todoService.markComplete(id);
			return "redirect:/todo-list";
		}catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "error";
		}
		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTodoItem(@PathVariable("id") long id, Model model) {

		try {
			todoService.deleteTodo(id);
			return "redirect:/todo-list";
		}catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "error";
		}
		
	}
	
}
