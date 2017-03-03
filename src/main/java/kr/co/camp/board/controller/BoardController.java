package kr.co.camp.board.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import kr.co.camp.board.dao.BoardMapper.BoardDAO;
import kr.co.camp.board.vo.BoardFileVO;
import kr.co.camp.board.vo.BoardVO;
import kr.co.camp.repository.vo.PageResultVO;
import kr.co.camp.repository.vo.SearchVO;
@Controller
@RequestMapping("/board")
public class BoardController {
private BoardDAO dao;
	
	public BoardController() {
		this.dao = new BoardDAO();
	}
	@ResponseBody
	@RequestMapping("/list.do")
	public Map<String, Object> list(SearchVO search) throws Exception {
		List<BoardVO> list = dao.selectBoard(search);
		int count = dao.selectBoardCount(search);
		Map<String, Object> result = new HashMap<>();
		result.put("list", list);
		result.put("pageResult", new PageResultVO(search.getPageNo(), count));
		return result;
	}
	
	public static void main(String[] args) {
		for (int count = 0; count < 100; count++) {
			int p1 = (count % 10 == 0) ? count / 10 : count / 10 + 1;
			int p2 = (int)Math.ceil(count / 10d);
			System.out.println(p1 + "-" + p2);
		}
	}
//	@RequestMapping("/board/writeForm.do")
//	public void writeForm()throws Exception{}
//	
//	@RequestMapping("/board/write.do")
//	public ModelAndView write(HttpServletRequest request) throws Exception {
//		
//		ServletContext context = request.getServletContext();
//		String path = context.getRealPath("/upload");
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
//		String datePath = sdf.format(new Date());
//		
//		String savePath = path + datePath;
//		File f = new File(savePath);
//		if (!f.exists()) f.mkdirs();
//		
//		// 파일 처리를 위한 API 클래스 호출
//		MultipartRequest mRequest = new MultipartRequest(
//				request, 
//				savePath, 
//				1024 * 1024 * 10, 
//				"UTF-8",
//				new MlecFileRenamePolicy()
//		);
//		
//		int no = dao.insertBoard((BoardVO)WebUtil.getParamToVO(mRequest, BoardVO.class));
//		
//		File file = mRequest.getFile("attachFile");
//		if (file != null) {
//			String oriName = mRequest.getOriginalFileName("attachFile");
//			String systemName = mRequest.getFilesystemName("attachFile");
//			long fileSize = file.length();
//			
//			BoardFileVO boardFile = new BoardFileVO();
//			boardFile.setNo(no);
//			boardFile.setOriName(oriName);
//			boardFile.setSystemName(systemName);
//			boardFile.setFilePath(datePath);
//			boardFile.setFileSize(fileSize);
//			
//			dao.insertBoardFile(boardFile);
//		}
//		
//		ModelAndView mav = new ModelAndView("list.do");
//		mav.addAttribute("msg", "게시물이 등록되었습니다");
//		return mav;
//	}
	
}