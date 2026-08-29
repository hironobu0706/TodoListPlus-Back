
package com.example.demo.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.model.TodolistModel;
import com.example.demo.service.TodolistService;

@WebMvcTest(TodolistController.class)
class TodolistControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockitoBean
	TodolistService service;

	@Test
	// 1_正常系_ユーザーIDをキーにTODO一覧取得(複数件)
	void getTodolist_success() throws Exception {
		when(service.getTodolistWithUserId("1")).thenReturn(List.of(new TodolistModel()));
		mockMvc.perform(get("/api/getTodolistWithUserId").param("user_id", "1")).andExpect(status().isOk());
	}

	@Test
	// 2_正常系_ユーザーIDをキーにTODO取得(1件)
	void getTodo_success() throws Exception {
		when(service.getTodolistWithUserId("1")).thenReturn(List.of(new TodolistModel()));
		mockMvc.perform(get("/api/todolist/1")).andExpect(status().isOk());
	}

	@Test
	void createTodo_success() throws Exception {
		when(service.createTodo(any())).thenReturn(1);
		mockMvc.perform(post("/api/create").contentType(MediaType.APPLICATION_JSON)
				.content("{\"user_id\":1,\"contents\":\"todo\"}")).andExpect(status().isOk());
	}

	@Test
	// 4_正常系_TODO更新
	void updateTodolist_success() throws Exception {
		when(service.updateTodolist(any(TodolistModel.class))).thenReturn(1);
		mockMvc.perform(put("/api/todolist/update").contentType(MediaType.APPLICATION_JSON).content("""
				{
				    "id": 1,
				    "contents": "更新後TODO",
				    "user_id": 1
				}
				""")).andExpect(status().isOk());
	}

	@Test
	// 5_正常系_TODO削除
	void deleteTodoWithId_success() throws Exception {
		when(service.deleteTodoWithId(1)).thenReturn(1);
		mockMvc.perform(get("/api/todolist/delete/1")).andExpect(status().isOk());
	}

	@Test
	// 6_正常系_TODO完了
	void completeTodolistWithId_success() throws Exception {
		when(service.completeTodolistWithId(1)).thenReturn(1);
		mockMvc.perform(get("/api/todolist/complete/1")).andExpect(status().isOk());
	}
}
