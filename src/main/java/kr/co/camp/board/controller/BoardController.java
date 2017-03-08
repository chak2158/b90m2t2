package kr.co.camp.board.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.camp.repository.vo.BoardVO;
import kr.co.camp.repository.vo.ReviewImageVO;
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
		System.out.println(result);
		return result;
	}

	@RequestMapping("/write.do")
	public String write(MultipartHttpServletRequest mRequest, RedirectAttributes attr) throws Exception {
		Map<String, Object> param = new HashMap<>();
		
		
		ServletContext context = mRequest.getServletContext();
		String path = context.getRealPath("/upload");
		
		ModelAndView mav = new ModelAndView("file/uploadResult");
		String id = mRequest.getParameter("id");
			
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
		String datePath = sdf.format(new Date());
		
		String savePath = path + datePath;
		File f = new File(savePath);
		if (!f.exists()) f.mkdirs();
		
		// 게시판과 파일 테이블에 저장할 글번호를 조회
		BoardVO board = new BoardVO();
		board.setTitle(mRequest.getParameter("title"));
		board.setMemberId(mRequest.getParameter("memberId"));
		board.setContent(mRequest.getParameter("content"));;
//		int no = dao.insertBoard(board);
		param.put("board", board);
			
		
		// attachFile1 
		// attachFile2
//		String formFileName = iter.next();
//			// 폼에서 파일을 선택하지 않아도 객체 생성됨(null이 아니다 그래서 사용자가 구분이 안된다.)
//		MultipartFile mFile = mRequest.getFile(formFileName);
		
		Iterator<String> iter = mRequest.getFileNames();
		List<ReviewImageVO> list = new ArrayList();
		
		while(iter.hasNext()){
			// 게시물 저장 처리 부탁..
			MultipartFile  file = mRequest.getFile(iter.next());
			String oriName = file.getOriginalFilename();
			
			System.out.println("oriName :" + oriName);
			
			if (oriName != null && !oriName.equals("")) {
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
				
				ReviewImageVO boardFile = new ReviewImageVO();
				boardFile.setOriName(oriName);
				boardFile.setSystemName(systemName);
				boardFile.setFilePath(datePath);
				boardFile.setFileSize(fileSize);
				
				list.add(boardFile);
			}
		}

		param.put("fileList", list);
		service.write(param);
		
		
		
//		return "redirect:list.do";
		return "";	
	}
	
	@RequestMapping("/updateForm.do")
	public void updateForm(int no, Model model) throws Exception {
		model.addAttribute("board", service.update(no));
	}
	
	@RequestMapping("/delete.do")
	public String delete(int reviewNo, RedirectAttributes attr) throws Exception {
		service.delete(reviewNo);
		return "";
	}
}