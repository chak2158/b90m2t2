package kr.co.camp.repository.mapper;

import java.util.List;

import kr.co.camp.repository.vo.BoardFileVO;
import kr.co.camp.repository.vo.BoardVO;
import kr.co.camp.repository.vo.CommentVO;
import kr.co.camp.repository.vo.SearchVO;

public interface BoardMapper {
	
	/* =================================================== */
	/* 기본 게시판                                            */
	/* =================================================== */
	public List<BoardVO> selectBoard(SearchVO search) throws Exception;
	public int selectBoardCount(SearchVO search) throws Exception;
	public BoardVO selectOneBoard(int no) throws Exception;
	public int insertBoard(BoardVO board) throws Exception;
	public boolean updateBoard(BoardVO vo) throws Exception;
	public boolean deleteBoard(int no) throws Exception;
	
	/* =================================================== */
	/* 파일 관련                                             */
	/* =================================================== */
	public void insertBoardFile(BoardFileVO boardFile) throws Exception;
	public BoardFileVO selectBoardFileByNo(int no) throws Exception;
	
	
	/* =================================================== */
	/* 댓글 관련                                             */
	/* =================================================== */
	public void insertBoardComment(CommentVO comment) throws Exception;
	public List<CommentVO> selectBoardCommentByNo(int no) throws Exception;
	public void deleteBoardComment(int commentNo) throws Exception;
	public void updateBoardComment(CommentVO comment) throws Exception;
}














