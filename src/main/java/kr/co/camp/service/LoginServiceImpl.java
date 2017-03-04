package kr.co.camp.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.camp.repository.mapper.LoginMapper;
import kr.co.camp.repository.vo.CampMemberVO;

@Service
public class LoginServiceImpl implements LoginService{
	
	
	@Autowired
	private LoginMapper dao;
	
	public CampMemberVO join(CampMemberVO user) throws Exception{
		return dao.retrieveMember(user);
	}
	
	
}
