package kr.co.camp.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.camp.repository.vo.CampMemberVO;
import kr.co.camp.service.LoginService;

@Controller
@RequestMapping("/login")
@RestController
public class LoginController {

	@Autowired
	private LoginService service;
	
	@RequestMapping("/join.do")
	public boolean join(CampMemberVO user,HttpServletRequest request) throws Exception {
		
		CampMemberVO member = service.join(user);
		
		// 해당하는 멤버가 있을 경우.
		if(member != null) {
			// 로그인한 멤버 세션 영역 설정.
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			
			return true;
			
		}
		// 해당하는 멤버 없을 경우.
		else{
			
			return false;
			
		}
	}
	
}
