package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.LoginEntity;
import com.example.demo.model.LoginModel;

@Mapper
public interface LoginMapper {
	LoginModel loginAuth(String mailAddress, String password);

	int createCustomer(LoginEntity request);
}
