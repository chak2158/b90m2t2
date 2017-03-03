package kr.co.camp.repository.mapper;

import java.util.List;

import kr.co.camp.repository.vo.Board;

public interface LoginMapper {
	public List<Board> selectBoard() throws Exception;
}
