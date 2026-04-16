package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@CrossOrigin(origins = "*") // このコントローラーの全メソッドを全許可
public class HomeController {

	@GetMapping("{path:^(?!.*static).*$}/**")
	public String all() {
		return "index";
	}
}