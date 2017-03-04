package kr.co.camp.service;

import kr.co.camp.repository.vo.CampMemberVO;

public interface LoginService {
	
	public CampMemberVO join(CampMemberVO user) throws Exception; 
	
}
