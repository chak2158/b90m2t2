package kr.co.camp.repository.vo;


public class ReviewRecomVO {

	 private int no; 
	 private int reviewNo; 
	 private String memberId; 
	 private char recomStatus; 


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

	 public void setRecomStatus(char recomStatus){
	      this.recomStatus=recomStatus;
	 }

	 public char getRecomStatus(){
	      return recomStatus;
	 }

}