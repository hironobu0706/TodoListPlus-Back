package com.example.demo.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LoginModel;
import com.example.demo.request.RequestCustomerForm;
import com.example.demo.request.RequestLoginForm;
import com.example.demo.response.CommonResponse;
import com.example.demo.service.LoginService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*") // このコントローラーの全メソッドを全許可
//@CrossOrigin("http://localhost:3000") // https://todo-list-plus-front-hironobu0706-hironobu0706s-projects.vercel.app/
public class LoginController {

	@Autowired
	private LoginService service;
	
	@PostMapping("/loginAuth")
	public LoginModel loginAuth(@RequestBody RequestLoginForm request) {
		System.out.println("aaaaaaaaaaa");
		LoginModel loginModel = new LoginModel();
		loginModel = service.loginAuth(request.getMailAddress(), request.getPassword());
		
		if(Objects.isNull(loginModel)) {
			return null;
		}
		
		// トークンを生成しsession、レスポンスに格納
//		String hash = Hash.hashString(responseLogin.getUser_id());
//		session.setAttribute("loginToken", hash);
		
//		responseLogin.setToken(hash);
//		System.out.println("1session:"+session.getAttribute("loginToken"));

		return loginModel;
	}
	
	@PostMapping("/createCustomer")
	public ResponseEntity<CommonResponse>
	createCustomer(@RequestBody RequestCustomerForm request) {
	    CommonResponse response = new CommonResponse();
	    try {
	    	// 実行開始
	        int retCount = service.createCustomer(request);
	        
	        // 終了処理
	        response.setSuccess(true);
	        response.setMessage("処理件数：" + Integer.toString(retCount));
	        return ResponseEntity.ok(response);
	    } catch (Exception e) {
	        response.setSuccess(false);
	        response.setMessage(e.getMessage());
	        return ResponseEntity
	                .badRequest()
	                .body(response);
	    }
	}
}
