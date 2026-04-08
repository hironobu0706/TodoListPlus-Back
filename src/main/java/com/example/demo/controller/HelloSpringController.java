package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "*") // このコントローラーの全メソッドを全許可
public class HelloSpringController {
	
	@GetMapping("/hello")
	public String hello() {
		return "hello-spring";
	}

}
