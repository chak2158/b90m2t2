package kr.co.camp.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.camp.repository.vo.MemberVO;

@Controller
@RestController
@RequestMapping("/login")
public class LoginController {

	@RequestMapping("/login.do")
	public void login(MemberVO member) {
		
		
	}
	
}
