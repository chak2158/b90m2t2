package kr.co.camp.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.camp.board.dao.BoardMapper.BoardDAO;
import kr.co.camp.board.vo.BoardVO;
import kr.co.camp.board.vo.PageResultVO;
import kr.co.camp.board.vo.SearchVO;
@Controller
@RequestMapping("/board")
public class BoardController {
private BoardDAO dao;
	
	public BoardController() {
		this.dao = new BoardDAO();
	}
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
			// 마지막 페이지 구하기
			int p1 = (count % 10 == 0) ? count / 10 : count / 10 + 1;
			int p2 = (int)Math.ceil(count / 10d);
			System.out.println(p1 + "-" + p2);
		}
	}
}