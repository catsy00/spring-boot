package com.kepco.user.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kepco.common.persistence.AbstractDAO;
import com.kepco.user.domain.UserVO;
import com.kepco.user.util.RegisterRequest;

@Repository("userDAO")
public class UserDAO extends AbstractDAO {
	
	@Autowired
	private SqlSession sqlSession;
	

	public UserVO selectByEmail(String email) throws Exception {
		return (UserVO)selectOne("user.selectByEmail", email);
	}

	public UserVO selectById(String id) throws Exception {
		return (UserVO)selectOne("user.selectById", id);
	}

	public void insertUser(RegisterRequest regReq) throws Exception {
		insert("user.register", regReq);
	}
	
	public int idChk(String memberId) throws Exception {
		int result = sqlSession.selectOne("user.idChk", memberId);
		return result; 
	}
	
	
}