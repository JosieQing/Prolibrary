package com.neuedu.examonline.stufunc.anssheet;
import java.util.Date;

public class ExamView {
	

private int id;
private String exam_name;
private int total_time;
Date  start_time;
private int status;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getExam_namc() {
	return exam_name;
}
public void setExam_namc(String exam_name) {
	this.exam_name = exam_name;
}
public int gettotal_time() {
	return total_time;
}
public void settotal_time(int total_time){
	this.total_time= total_time;
}
public Date getStart_time() {
	return start_time;
}
public void setStart_time(Date start_time) {
	this.start_time = start_time;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public ExamView(int id,String exam_name,int total_time,Date  start_time,int status){
	super();
	this.id=id;
	this.exam_name=exam_name;
	this.total_time=total_time;
	this.start_time=start_time;
	this.status=status;
}
	
	
}
