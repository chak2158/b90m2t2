package kr.co.camp.common;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

// 클래스 정보가 로딩 될때 연결정보 올림
// 클래스 가 로딩될떄 올라가는거 static 블록

public class ConnectionPool {

	// 커넥션 초기 개수
	private static final int INIT_COUNT = 3;
	// 연결을 맺었는데 사용하지 않은 연견들
	private static List<Connection> free = new ArrayList<>();
	// 누군가 요청해도 사용하고 있는 연결들
	private static List<Connection> used = new ArrayList<>();
	
	
	
	static {
		try {
			for (int i = 1 ; i<=INIT_COUNT ; i ++ ){
				free.add(ConnectionFactory.getConnection());
			}
		} catch (Exception e) {
			System.out.println("초기 연결 풀 생성시 오류 발생");
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public static Connection getConnection() throws Exception {
		
		// 비어있을 경우
		if(free.isEmpty()){
			throw new Exception("사용할 수 있는 커넥션이 없습니다");
		}
		
		// 삭제시 해당 값이 반한됨.
		// 쉬는풀에서 제거
		Connection con = free.remove(0);
		
		// 사용풀로 이동
		used.add(con);
		return con;
	}
	
	// 사용자의 사용이 끝나고 반환 처리
	public static void releaseConnection(Connection con){
		used.remove(con); // 
		free.add(con);
	}
	
	// 커넥션풀링 기법 간단한 사용 예
	public static void main(String[] args) {
		
		// 한 동안 커넥션 풀 사용. 만약에 커넥션풀이 모자르다는 요청이 나오면 , release를 안 했다는 뜻.
		
		try {
			
			for(int i = 0 ; i <= 10 ; i++){
				
				Thread.sleep(2000); // 2초마다 한번씩 for문 회전
				
				// 커넥션풀을 사용하는 쪽의 코드
				Connection con = ConnectionPool.getConnection();
				System.out.println("사용자 요청 CON : " + con);
				
				// 연결 정리 요청
				ConnectionPool.releaseConnection(con);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}



























