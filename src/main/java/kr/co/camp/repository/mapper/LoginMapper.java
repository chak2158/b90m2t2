package kr.co.camp.repository.mapper;

import java.util.List;

import kr.co.camp.repository.vo.BoardVO;

public interface LoginMapper {
	public List<BoardVO> selectBoard() throws Exception;
}
