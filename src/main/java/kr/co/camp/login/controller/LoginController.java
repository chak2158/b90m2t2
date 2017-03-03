package kr.co.camp.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.camp.repository.vo.Board;
import kr.co.camp.repository.vo.SearchVO;
import kr.co.camp.service.LoginService;

@Controller
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService service;
	
	@RequestMapping("/login.do")
	public List<Board> list(SearchVO search) throws Exception {
		System.out.println("로긴");
		return service.list(search);
	}
	
}
