package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Login;
import com.example.demo.request.RequestLoginForm;
import com.example.demo.service.LoginService;

@RestController
@RequestMapping("api")
@CrossOrigin("http://localhost:3000") // https://todo-list-plus-front-hironobu0706-hironobu0706s-projects.vercel.app/
public class LoginController {

	@Autowired
	private LoginService service;
	
	@PostMapping("/loginAuth")
	public Login loginAuth(@RequestBody RequestLoginForm request) {
		Login responseLogin = new Login();
		responseLogin = service.loginAuth(request.getMailAddress(), request.getPassword());
		
		if(responseLogin == null) {
			return null;
		}
		
		// トークンを生成しsession、レスポンスに格納
//		String hash = Hash.hashString(responseLogin.getUser_id());
//		session.setAttribute("loginToken", hash);
		
//		responseLogin.setToken(hash);
//		System.out.println("1session:"+session.getAttribute("loginToken"));

		return responseLogin;
	}
}
