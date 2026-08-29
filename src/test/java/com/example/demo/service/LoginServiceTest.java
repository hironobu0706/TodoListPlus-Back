
package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.LoginModel;
import com.example.demo.repository.LoginRepository;
import com.example.demo.request.RequestCustomerForm;

@ExtendWith(MockitoExtension.class)
class LoginServiceTest {

    @Mock
    LoginRepository loginRepository;

    @InjectMocks
    LoginService service;

    @Test
    void loginAuth_success() {
        LoginModel model = new LoginModel();
        model.setUser_id("1");

        when(loginRepository.loginAuth("a","b")).thenReturn(model);

        LoginModel result = service.loginAuth("a","b");

        assertNotNull(result);
        assertEquals("1", result.getUser_id());
    }

    @Test
    void loginAuth_notFound() {
        when(loginRepository.loginAuth("a","b")).thenReturn(null);

        assertNull(service.loginAuth("a","b"));
    }

    @Test
    void createCustomer_success() {
        RequestCustomerForm req = new RequestCustomerForm();
        req.setMailAddress("test@test.com");
        req.setPassword("pass");
        req.setUserName("user");

        when(loginRepository.createCustomer(any())).thenReturn(1);

        assertEquals(1, service.createCustomer(req));
    }
}
