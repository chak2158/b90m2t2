package kr.co.camp.board.dao;

import org.apache.ibatis.session.SqlSession;

import kr.co.camp.common.MyAppSqlConfig;

public class BoardDAO {
	private SqlSession sqlMapper = MyAppSqlConfig.getSqlSessionInstance();
}
