package com.springboot.todoapp.service;

import java.util.List;

import com.springboot.todoapp.entity.Todo;

public interface TodoService {

	public List<Todo> getTodoList() throws IllegalArgumentException;
	
	public String getUserName();
	
	public void saveTodo(Todo todo) throws IllegalArgumentException;
	
	public Todo getTodoById(long id) throws IllegalArgumentException;
	
	public void updateTodo(Todo todo) throws IllegalArgumentException;

	public void deleteTodo(long id) throws IllegalArgumentException;
	
	public void markComplete(long id) throws IllegalArgumentException;

}
