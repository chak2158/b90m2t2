package kr.co.mlec.board;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/test")
public class TestController {
	@RequestMapping("/test")
	public String gogo(){
		
		return "zzz";
				
	}
}
