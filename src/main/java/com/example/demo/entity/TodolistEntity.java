package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodolistEntity {
    private int id;
    private int user_id;
    private int priority;
    private String contents;
    private String tag;
    private int status;
    private String deadline;
    private String created_by;
    private String updated_by;
}
