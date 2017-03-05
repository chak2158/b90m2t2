package kr.co.camp.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.camp.repository.vo.SearchVO;
import kr.co.camp.service.BoardService;

@Controller
@RequestMapping("/board")
@RestController
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("/list.do")
	public Map<String, Object> list(SearchVO search) throws Exception {
		Map<String, Object> map  = service.list(search);
		
		Map<String, Object> result = new HashMap<>();
		result.put("list", map.get("list"));
		result.put("pageResult", map.get("pageResult"));
		return result;
	}
	
	@RequestMapping("/detail.do")
	public Map<String, Object> detail(int reviewNo) throws Exception {
		Map<String, Object> map  = service.detail(reviewNo);
		
		Map<String, Object> result = new HashMap<>();
		result.put("detail", map.get("boardVO"));
		result.put("file", map.get("file"));
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@RequestMapping("/board/write.do")
//	public String write(MultipartHttpServletRequest mRequest, RedirectAttributes attr) throws Exception {
//		
//		Map<String, Object> param = new HashMap<>();
//		
//		ServletContext context = mRequest.getServletContext();
//		String path = context.getRealPath("/upload");
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
//		String datePath = sdf.format(new Date());
//		
//		String savePath = path + datePath;
//		File f = new File(savePath);
//		if (!f.exists()) f.mkdirs();
//		
//		// 게시판과 파일 테이블에 저장할 글번호를 조회
//		BoardVO board = new BoardVO();
//		board.setTitle(mRequest.getParameter("title"));
//		board.setMemberId(mRequest.getParameter("memberId"));
//		board.setContent(mRequest.getParameter("content"));;
//		
////		int no = dao.insertBoard(board);
//		param.put("board", board);
//				
//		// 게시물 저장 처리 부탁..
//		MultipartFile  file = mRequest.getFile("attachFile");
//		String oriName = file.getOriginalFilename();
//		if (oriName != null && !oriName.equals("")) {
//			// 확장자 처리
//			String ext = "";
//			// 뒤쪽에 있는 . 의 위치 
//			int index = oriName.lastIndexOf(".");
//			if (index != -1) {
//				// 파일명에서 확장자명(.포함)을 추출
//				ext = oriName.substring(index);
//			}
//			
//			// 파일 사이즈
//			long fileSize = file.getSize();
//			System.out.println("파일 사이즈 : " + fileSize);
//			
//			// 고유한 파일명 만들기	
//			String systemName = "mlec-" + UUID.randomUUID().toString() + ext;
//			System.out.println("저장할 파일명 : " + systemName);
//		
//			// 임시저장된 파일을 원하는 경로에 저장
//			file.transferTo(new File(savePath + "/" + systemName));
//						
//			BoardFileVO boardFile = new BoardFileVO();
//			boardFile.setOriName(oriName);
//			boardFile.setSystemName(systemName);
//			boardFile.setFilePath(datePath);
//			boardFile.setFileSize(fileSize);
//			param.put("boardFile", boardFile);
//		}
//		
//		service.write(param);
//		
//		attr.addFlashAttribute("msg", "게시물이 등록되었습니다");
//		return "redirect:list.do";
//	}
	
}