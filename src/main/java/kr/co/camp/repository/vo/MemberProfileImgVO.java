package kr.co.camp.repository.vo;

public class MemberProfileImgVO {

	 private String memberId; 
	 private String oriName; 
	 private String systemName; 
	 private int fileSize; 
	 private String filePath; 


	 public void setMemberId(String memberId){
	      this.memberId=memberId;
	 }

	 public String getMemberId(){
	      return memberId;
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