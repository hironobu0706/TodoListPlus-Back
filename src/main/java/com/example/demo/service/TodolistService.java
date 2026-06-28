package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TodolistEntity;
import com.example.demo.model.TodolistModel;
import com.example.demo.repository.TodolistRepository;

@Service
public class TodolistService {

    @Autowired
    private TodolistRepository todolistRepository;

	public List<TodolistModel> getTodolistWithUserId(String user_id) {
		List<TodolistModel> todolistModelList = new ArrayList<TodolistModel>();
		List<TodolistEntity> todolistEntityList = todolistRepository.getTodolistWithUserId(user_id);
		
		entityListToModelList(todolistModelList, todolistEntityList);
		return todolistModelList;
	}

	public TodolistModel getTodolistWithId(int id) {
		TodolistModel todolistModel = new TodolistModel();
		TodolistEntity todolistEntity = todolistRepository.getTodolistWithId(id);
		
		entityToModel(todolistModel, todolistEntity);
		return todolistModel;
	}
	
	public int updateTodolist(TodolistModel todolist) {
		return todolistRepository.updateTodolist(todolist);
	}

	public int deleteTodoWithId(int id) {
		return todolistRepository.deleteTodoWithId(id);
	}

    public int createTodo(TodolistModel todolist) {
    	todolist.setCreated_by(Integer.toString(todolist.getUser_id()));
    	todolist.setUpdated_by(Integer.toString(todolist.getUser_id()));
        return todolistRepository.createTodo(todolist);
    }

	public int completeTodolistWithId(int id) {
		return todolistRepository.completeTodolistWithId(id);
	}
	
	/**
	 * todolistEntityをtodolistModelに変換する(1レコード専用)
	 * @param todolistModel
	 * @param todolistEntity
	 */
	private void entityToModel(TodolistModel todolistModel,
			                           TodolistEntity todolistEntity){
		
		todolistModel.setId(todolistEntity.getId());
		todolistModel.setUser_id(todolistEntity.getUser_id());
		todolistModel.setPriority(todolistEntity.getPriority());
		todolistModel.setContents(todolistEntity.getContents());
		todolistModel.setTag(todolistEntity.getTag());
		todolistModel.setStatus(todolistEntity.getStatus());
		todolistModel.setDeadline(todolistEntity.getDeadline());
			
	}
	
	/**
	 * todolistEntityListをtodolistModelListに変換する(複数レコード専用)
	 * @param todolistModelList
	 * @param todolistEntityList
	 */
	private void entityListToModelList(List<TodolistModel> todolistModelList,
			                           List<TodolistEntity> todolistEntityList){
		
		todolistEntityList.forEach((todo) -> {
			TodolistModel model = new TodolistModel();
			model.setId(todo.getId());
			model.setUser_id(todo.getUser_id());
			model.setPriority(todo.getPriority());
			model.setContents(todo.getContents());
			model.setTag(todo.getTag());
			model.setStatus(todo.getStatus());
			model.setDeadline(todo.getDeadline());
			
			todolistModelList.add(model);
		});
	}
}
