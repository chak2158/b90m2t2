package kr.co.camp.BoardService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.camp.board.vo.BoardFileVO;
import kr.co.camp.board.vo.BoardVO;
import kr.co.camp.board.vo.CommentVO;
import kr.co.camp.repository.mapper.BoardMapper;
import kr.co.camp.repository.vo.PageResultVO;
import kr.co.camp.repository.vo.SearchVO;

@Service
public abstract class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper dao;
	
	@Override
	public void write(Map<String, Object> param) throws Exception {
		int no = dao.insertBoard((BoardVO)param.get("board"));
		BoardFileVO boardFile = (BoardFileVO)param.get("boardFile");
		if (boardFile != null) {
			boardFile.setNo(no);
			dao.insertBoardFile(boardFile);
		}
	}

	@Override
	public BoardVO updateForm(int no) throws Exception {
		return dao.selectOneBoard(no);
	}

	@Override
	public void update(BoardVO board) throws Exception {
		dao.updateBoard(board);
	}

	@Override
	public Map<String, Object> list(SearchVO search) throws Exception {
		Map<String, Object> result = new HashMap<>();
		result.put("list", dao.selectBoard(search));
		result.put("pageResult", new PageResultVO(search.getPageNo(), dao.selectBoardCount(search)));
		return result;
	}

	@Override
	public Map<String, Object> detail(int no) throws Exception {
		Map<String, Object> result = new HashMap<>();
		result.put("boardVO", dao.selectOneBoard(no));
		result.put("file", dao.selectBoardFileByNo(no));
		return result;
	}

	@Override
	public void delete(int no) throws Exception {
		dao.deleteBoard(no);
	}

	@Override
	public List<CommentVO> commentUpdate(CommentVO comment) throws Exception {
		dao.updateBoardComment(comment);
		return dao.selectBoardCommentByNo(comment.getNo());
	}

	@Override
	public List<CommentVO> commentRegist(CommentVO comment) throws Exception {
		dao.insertBoardComment(comment);
		return dao.selectBoardCommentByNo(comment.getNo());
	}

	@Override
	public List<CommentVO> commentList(int no) throws Exception {
		return dao.selectBoardCommentByNo(no);
	}

	@Override
	public List<CommentVO> commentDelete(CommentVO comment) throws Exception {
		dao.deleteBoardComment(comment.getReviewNo());
		return dao.selectBoardCommentByNo(comment.getNo());
	}

}
