package kr.co.camp.repository.vo;

import java.util.Date;

public class Board {
	
	/** 글번호 */
	private int no;
	/** 글쓴이 */
	private String writer;
	/** 제목 */
	private String title;
	/** 내용 */
	private String content;
	/** 날짜 */
	private Date regDate;
	
	
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
