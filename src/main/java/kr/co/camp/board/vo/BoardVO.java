package kr.co.camp.board.vo;

import java.util.Date;

public class BoardVO {
	private int reviewNo;
	private String memberId;
	private String title;
	private String content;
	private Date regdate;
	private int recomCnt;
	private int unrecomCnt;
	private String mapLatitude;
	private String mapLongitude;
	private int viewCnt;
	
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getRecomCnt() {
		return recomCnt;
	}
	public void setRecomCnt(int recomCnt) {
		this.recomCnt = recomCnt;
	}
	public int getUnrecomCnt() {
		return unrecomCnt;
	}
	public void setUnrecomCnt(int unrecomCnt) {
		this.unrecomCnt = unrecomCnt;
	}
	public String getMapLatitude() {
		return mapLatitude;
	}
	public void setMapLatitude(String mapLatitude) {
		this.mapLatitude = mapLatitude;
	}
	public String getMapLongitude() {
		return mapLongitude;
	}
	public void setMapLongitude(String mapLongitude) {
		this.mapLongitude = mapLongitude;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	
	
}
