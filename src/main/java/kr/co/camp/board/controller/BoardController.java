package kr.co.camp.board.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.camp.board.vo.PageResultVO;
import kr.co.camp.board.vo.SearchVO;

public class BoardController {
	@RequestMapping("/board/list.do")
	public void list(SearchVO search, Model model) throws Exception {
		model.addAttribute("list", dao.selectBoard(search));
		model.addAttribute("pageResult", new PageResultVO(search.getPageNo(), dao.selectBoardCount(search)));
	}
}
