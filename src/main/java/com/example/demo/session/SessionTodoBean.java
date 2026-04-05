package com.example.demo.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;

@Data
@Component
@SessionScope
public class SessionTodoBean {
	private String loginToken;
}
