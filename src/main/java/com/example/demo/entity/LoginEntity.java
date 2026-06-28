package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginEntity {
    private String user_id;
    private String mail_address;
    private String password;
    private String user_name;
    private String created_by;
    private String updated_by;

}
