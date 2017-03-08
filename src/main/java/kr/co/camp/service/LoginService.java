package kr.co.camp.service;

import java.util.Map;

import kr.co.camp.repository.vo.CampMemberVO;

public interface LoginService {
	
	public CampMemberVO join(CampMemberVO user) throws Exception; 
	public void register(Map<String, Object> param) throws Exception; 
	public boolean checkId(String id) throws Exception;
	public boolean checkEmail(String email) throws Exception;
	public String searchId(String email) throws Exception;		
}
