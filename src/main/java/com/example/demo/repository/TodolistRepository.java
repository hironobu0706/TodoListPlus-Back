package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.TodolistEntity;
import com.example.demo.mapper.TodolistMapper;
import com.example.demo.model.TodolistModel;

@Repository
@Transactional
public class TodolistRepository {

	@Autowired
	private TodolistMapper mapper;

	public List<TodolistEntity> getTodolistWithUserId(String user_id) {
		return mapper.getTodolistWithUserId(user_id);
	}

	public TodolistEntity getTodolistWithId(int id) {
		return mapper.getTodolistWithId(id);
	}

	public int updateTodolist(TodolistModel todolistModel) {
		return mapper.updateTodolist(todolistModel);
	}

	public int deleteTodoWithId(int id) {
		return mapper.deleteTodoWithId(id);
	}
	
	public int createTodo(TodolistModel todolistModel) {
		return mapper.createTodo(todolistModel);
	}

	public int completeTodolistWithId(int id) {
		return mapper.completeTodolistWithId(id);
	}
}
