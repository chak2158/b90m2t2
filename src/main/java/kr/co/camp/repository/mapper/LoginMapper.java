package kr.co.camp.repository.mapper;

import kr.co.camp.repository.vo.CampMemberVO;
import kr.co.camp.repository.vo.MemberProfileImgVO;

public interface LoginMapper {
	
	// 멤버 검색
	public CampMemberVO retrieveMember(CampMemberVO user) throws Exception;		
	public void insertMember(CampMemberVO user) throws Exception;
	public void insertProfileImg(MemberProfileImgVO profile) throws Exception;
	public CampMemberVO retrieveMemberId(String id) throws Exception;		
	public CampMemberVO retrieveMemberEmail(String email) throws Exception;		
	public String searchId(String email) throws Exception;		
	
	
}
