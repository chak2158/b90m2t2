package kr.co.camp.service;

import java.util.List;

import kr.co.camp.repository.vo.BoardVO;
import kr.co.camp.repository.vo.SearchVO;

public interface LoginService {

	public List<BoardVO> list(SearchVO search) throws Exception;
}
