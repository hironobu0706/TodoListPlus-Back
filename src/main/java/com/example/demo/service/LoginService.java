package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LoginEntity;
import com.example.demo.model.LoginModel;
import com.example.demo.repository.LoginRepository;
import com.example.demo.request.RequestCustomerForm;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    // メールアドレス、パスワードを受け取り
    // ログインテーブルからパラメータのメールアドレス、パスワードに一致するレコード取得
	public LoginModel loginAuth(String mailAddress, String password) {
		LoginModel loginModel = new LoginModel();
		loginModel = loginRepository.loginAuth(mailAddress, password);
		if(loginModel == null) {
			return null;
		}
		return loginModel;
	}

	/**
	 * 顧客情報登録サービス
	 * @param todolist
	 * @return 処理件数(1)
	 */
    public int createCustomer(RequestCustomerForm request) {
    	LoginEntity entity = toEntity(request);
        return loginRepository.createCustomer(entity);
    }
    
    /**
     * リクエストをエンティティに変換
     */
    private LoginEntity toEntity(RequestCustomerForm req) {
    	LoginEntity entity = new LoginEntity();

        // 基本項目コピー
        entity.setMail_address(req.getMailAddress());
        entity.setPassword(req.getPassword());
        entity.setUser_name(req.getUserName());
        entity.setCreated_by("createCustomer");
        entity.setUpdated_by("createCustomer");
        
        return entity;
    }
}