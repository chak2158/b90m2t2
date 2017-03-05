package kr.co.camp.repository.vo;

public class CampMemberVO {

	 private String memberId; 
	 private String password; 
	 private String homeAddr; 
	 private String birthYear; 
	 private String birthMonth; 
	 private String birthDate; 
	 private String phoneNumber; 
	 private String email;


	 public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	 public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public String getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public void setPhoneNumber(String phoneNumber){
	      this.phoneNumber=phoneNumber;
	 }

	 public String getPhoneNumber(){
	      return phoneNumber;
	 }

}