package kr.co.camp.board.dao.BoardMapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.camp.board.vo.BoardVO;
import kr.co.camp.common.MyAppSqlConfig;
import kr.co.camp.repository.vo.SearchVO;

public class BoardDAO {
	private SqlSession sqlMapper = MyAppSqlConfig.getSqlSessionInstance();
	
	public List<BoardVO> selectBoard(SearchVO search) {
		List<BoardVO> hwboardList = sqlMapper.selectList("kr.co.camp.board.dao.BoardMapper.selectBoard", search);
		return hwboardList;
	}
	public int selectBoardCount(SearchVO search){
		return sqlMapper.selectOne("kr.co.camp.board.dao.BoardMapper.selectBoardCount",search);
	}
	public int insertBoard(BoardVO board) {
		sqlMapper.insert("kr.co.camp.board.dao.BoardMapper.insertBoard", board);
		sqlMapper.commit();
		return board.getReviewNo();
	}
	
	
}
