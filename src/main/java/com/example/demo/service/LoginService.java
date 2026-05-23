package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.LoginEntity;
import com.example.demo.model.Login;
import com.example.demo.repository.LoginRepository;
import com.example.demo.request.RequestCustomerForm;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    // メールアドレス、パスワードを受け取り
    // ログインテーブルからパラメータのメールアドレス、パスワードに一致するレコード取得
	public Login loginAuth(String mailAddress, String password) {
		Login responseLogin = new Login();
		responseLogin = loginRepository.loginAuth(mailAddress, password);
		if(responseLogin == null) {
			return null;
		}
		return responseLogin;
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
        
        // DB用の制御項目（業務ロジック）
//        Date now = new Date();
//        entity.setCreated_at(now);
//        entity.setCreated_by("SYSTEM"); // ログインユーザーにするのが理想
//        entity.setUpdate_at(now);
//        entity.setUpdate_by("SYSTEM");
//        entity.setDelete_flg(0); // 0: 未削除

        return entity;
    }
}