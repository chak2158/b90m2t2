package kr.co.camp.repository.vo;
import java.util.Date;

public class CalendarVO {

	 private int no; 
	 private String memberId; 
	 private String calendarTitle; 
	 private Date startDate; 
	 private Date endDate; 
	 private String description; 


	 public void setNo(int no){
	      this.no=no;
	 }

	 public int getNo(){
	      return no;
	 }

	 public void setMemberId(String memberId){
	      this.memberId=memberId;
	 }

	 public String getMemberId(){
	      return memberId;
	 }

	 public void setCalendarTitle(String calendarTitle){
	      this.calendarTitle=calendarTitle;
	 }

	 public String getCalendarTitle(){
	      return calendarTitle;
	 }

	 public void setStartDate(Date startDate){
	      this.startDate=startDate;
	 }

	 public Date getStartDate(){
	      return startDate;
	 }

	 public void setEndDate(Date endDate){
	      this.endDate=endDate;
	 }

	 public Date getEndDate(){
	      return endDate;
	 }

	 public void setDescription(String description){
	      this.description=description;
	 }

	 public String getDescription(){
	      return description;
	 }

}