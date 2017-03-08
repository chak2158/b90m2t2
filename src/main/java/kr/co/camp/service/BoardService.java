package kr.co.camp.service;

import java.util.List;
import java.util.Map;

import kr.co.camp.repository.vo.BoardVO;
import kr.co.camp.repository.vo.CommentVO;
import kr.co.camp.repository.vo.SearchVO;

public interface BoardService {
	public void write(Map<String, Object> param) throws Exception;
	
	public void update(BoardVO board) throws Exception;	
	
	public BoardVO updateForm(int no) throws Exception;

	public Map<String, Object> list(SearchVO search) throws Exception;
	
	//public Map<String, Object> detail(SearchVO search) throws Exception;
	
	public void delete(int no) throws Exception;
	
	public List<CommentVO> commentList(int no) throws Exception ;
	
	public List<CommentVO> commentRegist(CommentVO comment) throws Exception;
	
	public List<CommentVO> commentUpdate(CommentVO comment) throws Exception ;
	
	public List<CommentVO> commentDelete(CommentVO comment) throws Exception ;

	Map<String, Object> detail(int no) throws Exception;
}
