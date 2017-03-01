package kr.co.camp.common;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// 환경설정파일을 로딩시키는 역할
public class MyAppSqlConfig {
	// xml에 접근할 수 있는 각종 기능들(API)이 담겨있는 SqlSession - mybatis를 사용하기 위해서 꼭 필요해
	// SqlSession을 얻어내기 위해 sqlsessionfactory, sqlsessionfactorybuilder를 이용함
	// 클래스 정보를 로딩하게 되면 처리됨
	private static final SqlSession sqlMapper;
	static {
		try {
			// 환경설정 파일 주소 설정. 소스폴더 밑 주소부터
			String resource = "config/mybatis/sqlMapConfig.xml";
			// 문자단위를 읽어주는 클래스. 리더 객체 제공
			Reader reader = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlMapper = sqlFactory.openSession();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
					"Error initializing MyAppSqlConfig class. Cause: " + e);
		}
	}

	public static SqlSession getSqlSessionInstance() {
		return sqlMapper;
	}
}