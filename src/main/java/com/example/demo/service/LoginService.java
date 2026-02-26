package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Login;
import com.example.demo.repository.LoginRepository;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    // メールアドレス、パスワードを受け取り
    // ログインテーブルからパラメータのメールアドレス、パスワードに一致するレコード取得
	public Login loginAuth(String mailAddress, String password) {
		return loginRepository.loginAuth(mailAddress, password);
	}
}