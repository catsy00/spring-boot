package com.kepco.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kepco.common.exception.AlreadyExistingEmailException;
import com.kepco.common.exception.AlreadyExistingIdException;
import com.kepco.common.exception.IdPasswordNotMatchingException;
import com.kepco.user.domain.UserVO;
import com.kepco.user.persistence.UserDAO;
import com.kepco.user.util.AuthInfo;
import com.kepco.user.util.LoginCommand;
import com.kepco.user.util.RegisterRequest;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource(name="userDAO")
	private UserDAO userDAO;
	 
	@Override 
	public void register(RegisterRequest regReq) throws Exception {
		
       // UserVO email = userDAO.selectByEmail(regReq.getEmail());
      //  if(email!=null) {
          //  throw new AlreadyExistingEmailException(regReq.getEmail()+" is duplicate email.");
       // }
        
        UserVO id = userDAO.selectById(regReq.getId());
        if(id!=null) {
            throw new AlreadyExistingIdException(regReq.getId()+" is duplicate id.");
        }
        
        userDAO.insertUser(regReq);
	}

	@Override
	public AuthInfo loginAuth(LoginCommand loginCommand) throws Exception {
		
		UserVO user = userDAO.selectById(loginCommand.getId());
        if(user == null) {
            throw new IdPasswordNotMatchingException();
        }
        
        if(!user.matchPassword(loginCommand.getPassword())) {
            throw new IdPasswordNotMatchingException();
        } 
        
        return new AuthInfo(user.getUSER_ID(), user.getUSER_NM(), user.getGRADE());
	}
	
	@Override
	public int idChk(String memberId) throws Exception {
		System.out.println("memberId2 : " + memberId);
		int result = userDAO.idChk(memberId);
		//userDAO.idChk(vo);
		return result;
	}
	

}
