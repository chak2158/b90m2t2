package kr.co.camp.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.camp.repository.mapper.LoginMapper;
import kr.co.camp.repository.vo.Board;
import kr.co.camp.repository.vo.SearchVO;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginMapper dao;
	
	public List<Board> list(SearchVO search) throws Exception {
		List<Board> list = dao.selectBoard();
		return list;
	};
}
