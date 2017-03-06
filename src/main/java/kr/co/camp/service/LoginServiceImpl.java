package kr.co.camp.service;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.camp.repository.mapper.LoginMapper;
import kr.co.camp.repository.vo.CampMemberVO;
import kr.co.camp.repository.vo.MemberProfileImgVO;

@Service
public class LoginServiceImpl implements LoginService{
	
	
	@Autowired
	private LoginMapper dao;
	
	public CampMemberVO join(CampMemberVO user) throws Exception{
		return dao.retrieveMember(user);
	}
	
	
	public void register(Map<String, Object> param) throws Exception {
		
		dao.insertMember((CampMemberVO)param.get("member"));
		MemberProfileImgVO profileImg = (MemberProfileImgVO)param.get("profileImg");
		
		if(profileImg!=null) {
			dao.insertProfileImg((profileImg));
		}
	}
	
	public boolean checkId(String id) throws Exception {
		return dao.retrieveMemberId(id) != null ? true : false;
	}
	
	
}
