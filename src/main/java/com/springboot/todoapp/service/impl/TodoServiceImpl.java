package com.springboot.todoapp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.todoapp.entity.Todo;
import com.springboot.todoapp.entity.User;
import com.springboot.todoapp.repositories.TodoRepository;
import com.springboot.todoapp.repositories.UserRepository;
import com.springboot.todoapp.service.TodoService;
import com.springboot.todoapp.util.TodoUtil;

@Service
public class TodoServiceImpl implements TodoService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TodoRepository todoRepository;
	
	@Autowired
	TodoUtil todoUtil;
	
	@Override
	public List<Todo> getTodoList() throws IllegalArgumentException{
		List<Todo> todoList = new ArrayList<>();
		User user = userRepository.findByUserName(getUserName()).orElseThrow(() -> new IllegalArgumentException("No logged in user found!"));
		
		todoList = todoRepository.queryBy(user.getId());
		
		return todoList;
	}

	@Override
	public String getUserName() {
		return todoUtil.getUserDetails();
	}

	@Override
	public void saveTodo(Todo todo) throws IllegalArgumentException {
		
		User user = userRepository.findByUserName(getUserName()).orElseThrow(() -> new IllegalArgumentException("No logged in user found!"));
		
		todo.setUser(user);
		todo.setCreatedDate(new Date());
		todo.setModifiedDate(new Date());
		
		todoRepository.save(todo);
	}

	@Override
	public Todo getTodoById(long id) throws IllegalArgumentException {
		
		Todo todo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No todo task found with id: "+id));
		return todo;
	}

	@Override
	public void updateTodo(Todo todo) throws IllegalArgumentException {
		
		User user = userRepository.findByUserName(getUserName()).orElseThrow(() -> new IllegalArgumentException("No logged in user found!"));
		
		todo.setUser(user);
		todo.setModifiedDate(new Date());
		
		todoRepository.save(todo);
	}

	@Override
	public void deleteTodo(long id) throws IllegalArgumentException {
		
		Todo todo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No todo task found with id: "+id));
		todoRepository.delete(todo);
		
	}

	@Override
	public void markComplete(long id) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Todo todo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No todo task found with id: "+id));

		todo.setModifiedDate(new Date());
		todo.setComplete(!todo.isComplete());
		
		todoRepository.save(todo);
	}

	
}
