package kr.co.camp.repository.mapper;

import kr.co.camp.repository.vo.CampMemberVO;

public interface LoginMapper {
	
	// 멤버 검색
	public CampMemberVO retrieveMember(CampMemberVO user) throws Exception;		

}
