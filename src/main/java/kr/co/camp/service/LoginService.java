package kr.co.camp.service;

import java.util.List;

import kr.co.camp.repository.vo.Board;
import kr.co.camp.repository.vo.SearchVO;

public interface LoginService {

	public List<Board> list(SearchVO search) throws Exception;
}
