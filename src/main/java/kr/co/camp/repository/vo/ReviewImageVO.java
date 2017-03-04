package kr.co.camp.repository.vo;


public class ReviewImageVO {

	 private int no; 
	 private int reviewNo; 
	 private String oriName; 
	 private String systemName; 
	 private int fileSize; 
	 private String filePath; 


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

	 public void setOriName(String oriName){
	      this.oriName=oriName;
	 }

	 public String getOriName(){
	      return oriName;
	 }

	 public void setSystemName(String systemName){
	      this.systemName=systemName;
	 }

	 public String getSystemName(){
	      return systemName;
	 }

	 public void setFileSize(int fileSize){
	      this.fileSize=fileSize;
	 }

	 public int getFileSize(){
	      return fileSize;
	 }

	 public void setFilePath(String filePath){
	      this.filePath=filePath;
	 }

	 public String getFilePath(){
	      return filePath;
	 }

}