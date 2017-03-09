package kr.co.camp.repository.vo;
import java.util.Date;

public class ReviewCommentVO {

	 private int no; 
	 private int reviewNo; 
	 private String reviewComment;
	 private String memberId; 
	 private Date regDate; 


	 public String getReviewComment() {
		return reviewComment;
	}

	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}

	public void setNo(int no){
	      this.no=no;
	 }

	 public int getNo(){
	      return no;
	 }

	 public void setReviewNo(int reviewNo){
	      this.reviewNo=reviewNo;
	 }

	 public int getReviewNo(){
	      return reviewNo;
	 }

	 public void setMemberId(String memberId){
	      this.memberId=memberId;
	 }

	 public String getMemberId(){
	      return memberId;
	 }

	 public void setRegDate(Date regDate){
	      this.regDate=regDate;
	 }

	 public Date getRegDate(){
	      return regDate;
	 }

}