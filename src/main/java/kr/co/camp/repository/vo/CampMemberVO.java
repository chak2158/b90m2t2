package kr.co.camp.repository.vo;

public class CampMemberVO {

	 private String memberId; 
	 private String password; 
	 private String homeAddr; 
	 private char birthYear; 
	 private char birthMonth; 
	 private char birthDate; 
	 private String phoneNumber; 


	 public void setMemberId(String memberId){
	      this.memberId=memberId;
	 }

	 public String getMemberId(){
	      return memberId;
	 }

	 public void setPassword(String password){
	      this.password=password;
	 }

	 public String getPassword(){
	      return password;
	 }

	 public void setHomeAddr(String homeAddr){
	      this.homeAddr=homeAddr;
	 }

	 public String getHomeAddr(){
	      return homeAddr;
	 }

	 public void setBirthYear(char birthYear){
	      this.birthYear=birthYear;
	 }

	 public char getBirthYear(){
	      return birthYear;
	 }

	 public void setBirthMonth(char birthMonth){
	      this.birthMonth=birthMonth;
	 }

	 public char getBirthMonth(){
	      return birthMonth;
	 }

	 public void setBirthDate(char birthDate){
	      this.birthDate=birthDate;
	 }

	 public char getBirthDate(){
	      return birthDate;
	 }

	 public void setPhoneNumber(String phoneNumber){
	      this.phoneNumber=phoneNumber;
	 }

	 public String getPhoneNumber(){
	      return phoneNumber;
	 }

}