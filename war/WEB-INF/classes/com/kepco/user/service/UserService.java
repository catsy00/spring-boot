package com.kepco.user.service;

import com.kepco.user.util.AuthInfo;
import com.kepco.user.util.LoginCommand;
import com.kepco.user.util.RegisterRequest;

public interface UserService {

	void register(RegisterRequest regReq) throws Exception;

	AuthInfo loginAuth(LoginCommand loginCommand) throws Exception;
	
	public int idChk(String memberId) throws Exception;
}
