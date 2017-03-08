package kr.co.camp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.camp.repository.mapper.BoardMapper;
import kr.co.camp.repository.vo.BoardVO;
import kr.co.camp.repository.vo.CommentVO;
import kr.co.camp.repository.vo.PageResultVO;
import kr.co.camp.repository.vo.ReviewImageVO;
import kr.co.camp.repository.vo.SearchVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper dao;
	
	@Override
	public void write(Map<String, Object> param) throws Exception {
		dao.insertBoard((BoardVO)param.get("board"));
		int no = ((BoardVO)param.get("board")).getReviewNo();
		
		
		System.out.println("글 번호 : " + no);
		
		
		List<ReviewImageVO> boardFile = (List<ReviewImageVO>)param.get("fileList");
		
		System.out.println("파일 개수 : " + boardFile.size());
		
		if (boardFile.size()!=0) {
			
			
			for(int i=0;i<boardFile.size();i++) {
				ReviewImageVO vo = boardFile.remove(i);
				vo.setNo(no);
				dao.insertBoardFile(vo);
			}
//			boardFile.setReviewNo(no);
//			dao.insertBoardFile(boardFile);
//			System.out.println(boardFile.getFilePath());
//			System.out.println(boardFile.getOriName());
//			System.out.println(boardFile.getSystemName());
			
		}
	}

	@Override
	public BoardVO update(int no) throws Exception {
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
