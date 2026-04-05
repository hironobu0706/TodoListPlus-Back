package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Login;

@Mapper
public interface LoginMapper {
	Login loginAuth(String mailAddress, String password);
}
