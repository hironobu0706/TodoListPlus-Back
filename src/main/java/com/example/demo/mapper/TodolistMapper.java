package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.TodolistEntity;
import com.example.demo.model.TodolistModel;

@Mapper
public interface TodolistMapper {
	List<TodolistEntity> getTodolistWithUserId(String user_id);
	
	TodolistEntity getTodolistWithId(int id);
	
	int updateTodolist(TodolistModel todolist);
	
	int deleteTodoWithId(int id);
	
	int createTodo(TodolistModel todolist);
	
	int completeTodolistWithId(int id);
}
