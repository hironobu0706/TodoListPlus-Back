package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.LoginMapper;
import com.example.demo.model.Login;

@Repository
@Transactional
public class LoginRepository {

	@Autowired
	private LoginMapper mapper;

	public Login loginAuth(String mailAddress, String password) {
		return mapper.loginAuth(mailAddress, password);
	}
}
