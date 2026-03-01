package com.example.demo.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class RequestLoginForm implements Serializable { // Serializableでsession管理ができる
	private String mailAddress;
	private String password;
}
