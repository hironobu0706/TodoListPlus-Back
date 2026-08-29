
package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.entity.TodolistEntity;
import com.example.demo.model.TodolistModel;
import com.example.demo.repository.TodolistRepository;

@ExtendWith(MockitoExtension.class)
class TodolistServiceTest {

    @Mock
    TodolistRepository repository;

    @InjectMocks
    TodolistService service;

    @Test
    void getTodolistWithUserId_success() {
        TodolistEntity e = new TodolistEntity();
        e.setId(1);
        e.setContents("todo");

        when(repository.getTodolistWithUserId("1")).thenReturn(List.of(e));

        assertEquals(1, service.getTodolistWithUserId("1").size());
    }

    @Test
    void getTodolistWithId_success() {
        TodolistEntity e = new TodolistEntity();
        e.setId(10);
        e.setContents("sample");

        when(repository.getTodolistWithId(10)).thenReturn(e);

        TodolistModel result = service.getTodolistWithId(10);

        assertEquals(10, result.getId());
    }

    @Test
    void createTodo_setsAuditColumns() {
        TodolistModel model = new TodolistModel();
        model.setUser_id(5);

        when(repository.createTodo(any())).thenReturn(1);

        service.createTodo(model);

        assertEquals("5", model.getCreated_by());
        assertEquals("5", model.getUpdated_by());
    }
}
