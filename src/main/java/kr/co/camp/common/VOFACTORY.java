package kr.co.camp.common;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

// VO 자동화 완료.

public class VOFACTORY {
	public static void main(String[] args) {
		
		FileWriter fw = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("테이블을 입력하세요 : ");
		String tName = sc.nextLine();
		
		
		String className = "";
		
		if(tName.contains("_")){
		
			String[] vo = tName.split("_");
			
			for(int i=1;i<vo.length;i++){
				className+=(vo[i].substring(0, 1)).toUpperCase()+vo[i].substring(1);
			}
			
		} else
			className = tName.substring(0,1).toUpperCase() + tName.substring(1,tName.length());
		
		File f = new File("vofile/"+className+".java");
			
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
		
			// 유효성 체크 후, 파일 생성
			if(!f.exists())
				f.createNewFile();
			
			// DB 정보 뺴오기 !
			
			con = ConnectionPool.getConnection();
			String sql = "select * from "+tName ;
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsCount = rsmd.getColumnCount();
			
			// 컬럼명 , 컬럼 데이터 타입
			String[] columnsName = new String[columnsCount];
			String[] columnsType = new String[columnsCount];
			
			// 컬럼명 , 컬럼 데이터 타입 스트링 배열에 각각 넣는 작업.
			for(int i=1;i<=columnsName.length;i++){
			
				String cName = rsmd.getColumnName(i).toLowerCase();
				String temp="";
				
				if(cName.contains("_")){
					String[] str = cName.split("_");
					
					for(int j=1;j<str.length;j++){
						temp+=str[0];
						str[j] = (str[j].substring(0,1).toUpperCase()) + str[j].substring(1, str[j].length());
						temp+=str[j];
					}

					columnsName[i-1] = temp.trim(); 
						
				}else 
					columnsName[i-1] = cName; 
					
				
				String tNaming = rsmd.getColumnTypeName(i).toLowerCase();
				columnsType[i-1] = tNaming;
				
			}
			// setter,getter 메소드명 만드는 작업
			
			String[] columnsSetGet = new String[columnsCount];
			
			for(int i = 0; i<columnsSetGet.length;i++){
				
				columnsSetGet[i] = columnsName[i].substring(0, 1).toUpperCase() + 
						columnsName[i].substring(1, columnsName[i].length()); 
				
			}
			
			// DB 데이터 자료형 - > 자바 자료형으로 변환
			for(int i = 0; i<columnsType.length ; i++ ){
				if(columnsType[i].equals("number"))
					columnsType[i] = "int";
				else if(columnsType[i].equals("varchar2")) 
					columnsType[i] = "String";
				else if(columnsType[i].equals("date")) 
					columnsType[i] = "Date";
			}
			boolean dateFlag = false;
			
			for (String e : columnsType){
				if(e.equalsIgnoreCase("date")){
					dateFlag = true;
					break;
				}
			}
			// DB 정보 뺴오기 끝 !
			
			// 파일 입력 시작
			
			fw = new FileWriter(f,true);
			
			// Date 클래스 import문 삽입 
			if(dateFlag){
				fw.write("import java.util.Date;");
			}
			
			// 클래스 선언부 삽입
			fw.write(String.format("\n\n"));
			fw.write("public class "+className+"VO" + " {\n\n");
			
			// 멤버 변수 삽입
			for(int i = 0 ; i<columnsType.length;i++)
				fw.write(String.format("\t private %s %s; \n",columnsType[i],columnsName[i]));
			
			fw.write(String.format("\n\n"));
			
			// setter , getter 삽입
			
			for(int i=0; i<columnsSetGet.length;i++){
				
				fw.write(String.format("\t public void set%s(%s %s){\n",columnsSetGet[i],columnsType[i], columnsName[i]));
				fw.write(String.format("\t      this."+columnsName[i]+"="+columnsName[i]+";\n"));
				fw.write("\t }\n\n");
				
				fw.write(String.format("\t public %s get%s(){\n",columnsType[i],columnsSetGet[i]));
				fw.write(String.format("\t      return "+columnsName[i]+";\n"));
				fw.write("\t }\n\n");
				
			}
			// 마지막 클래스 선언부 삽입
			
			fw.write("}");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				fw.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			ConnectionFactory.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		} // finally 끝
	} // main 끝
















