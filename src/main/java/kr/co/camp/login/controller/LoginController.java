package kr.co.camp.login.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.camp.repository.vo.CampMemberVO;
import kr.co.camp.repository.vo.MemberProfileImgVO;
import kr.co.camp.service.LoginService;

@RequestMapping("/login")
@RestController
public class LoginController {

	@Autowired
	private LoginService service;
	
	@RequestMapping("/join.do")
	public Map<String, Object> join(CampMemberVO user,HttpServletRequest request) throws Exception {
		Map<String, Object> param = new HashMap<>();
		CampMemberVO member = service.join(user);
		// 해당하는 멤버가 있을 경우.
		
		if(member != null) {
			// 로그인한 멤버 세션 영역 설정.
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			
			param.put("member", member);
			param.put("loginCheck", true);
			
			return param;
		}
		// 해당하는 멤버 없을 경우.
		else{
			param.put("loginCheck", false);
			return param;
		}
	}
	
	@RequestMapping("/checkId.do")
	public boolean checkId(String id) throws Exception{
		System.out.println("여기 왔다.");
		System.out.println(service.checkId(id));
		return service.checkId(id);
	}
	
	
	@RequestMapping(value="/register.do", method=RequestMethod.POST)
	public boolean register(MultipartHttpServletRequest request) throws Exception {
		
		Map<String, Object> param = new HashMap<>();
		
		CampMemberVO member = new CampMemberVO();
		member.setMemberId(request.getParameter("memberId"));
		member.setPassword(request.getParameter("password"));
		member.setEmail(request.getParameter("email"));
		member.setHomeAddr(request.getParameter("homeAddr"));
		member.setPhoneNumber(request.getParameter("phoneNumber"));
		member.setBirthYear(request.getParameter("birthYear"));
		member.setBirthMonth(request.getParameter("birthMonth"));
		member.setBirthDate(request.getParameter("birthDate"));
		
		
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("/upload/memberProfileImg");
		
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
		String datePath = sdf.format(new Date());
		
		String savePath = path + datePath;
		
		File f = new File(savePath);
		if (!f.exists()) f.mkdirs();
		
		param.put("member", member);
		
		// 게시물 저장 처리 부탁..
		MultipartFile  file = request.getFile("profileImg");
		
		if (file != null) {
			
			String oriName = file.getOriginalFilename();

			if(oriName.equals("")) {
			
				// 확장자 처리
				String ext = "";
				// 뒤쪽에 있는 . 의 위치 
				int index = oriName.lastIndexOf(".");
				if (index != -1) {
					// 파일명에서 확장자명(.포함)을 추출
					ext = oriName.substring(index);
				}
				// 파일 사이즈
				long fileSize = file.getSize();
				System.out.println("파일 사이즈 : " + fileSize);
				
				// 고유한 파일명 만들기	
				String systemName = "mlec-" + UUID.randomUUID().toString() + ext;
				System.out.println("저장할 파일명 : " + systemName);
			
				// 임시저장된 파일을 원하는 경로에 저장
				file.transferTo(new File(savePath + "/" + systemName));
							
				MemberProfileImgVO profile = new MemberProfileImgVO();
				
				profile.setOriName(oriName);
				profile.setSystemName(systemName);
				profile.setFilePath(datePath);
				profile.setFileSize(fileSize);
				profile.setMemberId(request.getParameter("memberId"));
				
				param.put("profileImg",profile);
			
			}
		}
		
		service.register(param);
		
		return true;
	}
	
	
	
}
