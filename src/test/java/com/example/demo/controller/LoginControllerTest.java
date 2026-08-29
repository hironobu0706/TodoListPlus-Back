
package com.example.demo.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.example.demo.model.LoginModel;
import com.example.demo.service.LoginService;

@WebMvcTest(LoginController.class)
class LoginControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockitoBean
	LoginService service;

	@Test
	// 1_正常系_ログイン成功
	void loginAuth_login_success() throws Exception {
		LoginModel model = new LoginModel();
		model.setUser_id("1");

		when(service.loginAuth(anyString(), anyString())).thenReturn(model);

		mockMvc.perform(post("/api/loginAuth").contentType(MediaType.APPLICATION_JSON)
				.content("{\"mailAddress\":\"a\",\"password\":\"b\"}")).andExpect(status().isOk());
	}

	@Test
	// 2_異常系_ログイン失敗
	void loginAuth_login_fail() throws Exception {
		when(service.loginAuth(anyString(), anyString())).thenReturn(null);

		mockMvc.perform(post("/api/loginAuth").contentType(MediaType.APPLICATION_JSON)
				.content("{\"mailAddress\":\"a\",\"password\":\"b\"}")).andExpect(status().isOk())
				.andExpect(content().string(""));
//                .andExpect(content().json("""
//                        {
//                            "user_id":"1"
//                        }
//                        """));
	}

	@Test
	// 3_正常系_顧客情報登録成功
	void createCustomer_success() throws Exception {
		when(service.createCustomer(any())).thenReturn(1);

		mockMvc.perform(post("/api/createCustomer").contentType(MediaType.APPLICATION_JSON)
				.content("{\"mailAddress\":\"a\",\"password\":\"b\",\"userName\":\"c\"}")).andExpect(status().isOk());
	}

	@Test
	// 4_異常系_顧客情報登録失敗
	void createCustomer_fail() throws Exception {
		when(service.createCustomer(any())).thenThrow(new RuntimeException("DB登録エラー"));

		ResultActions result = mockMvc.perform(post("/api/createCustomer").contentType(MediaType.APPLICATION_JSON)
				.content("{\"mailAddress\":\"zzz@z.z\",\"password\":\"password\",\"userName\":\"samplezzz\"}"));
		result.andExpect(status().isInternalServerError());
	}
}
