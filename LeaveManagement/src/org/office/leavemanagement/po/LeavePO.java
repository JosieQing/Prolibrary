package org.office.leavemanagement.po;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class LeavePO {
	private int lid;
	private String lname;
	private Date write_time;
	private Date start_time;
	private Date end_time;
	private String leave_reason;
	private String state;
	private String job;
	private String leave_type;
	private String write_times;
	private String start_times;
	private String end_times;
	
	
	public String getWrite_times() {
		return write_times;
	}
	public void setWrite_times(String write_times) {
		this.write_times = write_times;
	}
	public String getStart_times() {
		return start_times;
	}
	public void setStart_times(String start_times) {
		this.start_times = start_times;
	}
	public String getEnd_times() {
		return end_times;
	}
	public void setEnd_times(String end_times) {
		this.end_times = end_times;
	}
	public LeavePO(){
		
	}
	public LeavePO(int lid, String lname, Date write_time,
			Date start_time, Date end_time, String leave_reason, String state,
			String job, String leave_type) {
		this.lid = lid;
		this.lname = lname;
		this.write_time = write_time;
		this.start_time = start_time;
		this.end_time = end_time;
		this.leave_reason = leave_reason;
		this.state = state;
		this.job = job;
		this.leave_type = leave_type;
	}
	
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Date getWrite_time() {
		return write_time;
	}
	public void setWrite_time(Date write_time) {
		this.write_time = write_time;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public String getLeave_reason() {
		return leave_reason;
	}
	public void setLeave_reason(String leave_reason) {
		this.leave_reason = leave_reason;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getLeave_type() {
		return leave_type;
	}
	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}
	@Override
	public String toString() {
		return "LeaveManagement [lid=" + lid + ", lname=" + lname
				+ ", write_time=" + write_time + ", start_time=" + start_time
				+ ", end_time=" + end_time + ", leave_reason=" + leave_reason
				+ ", state=" + state + ", job=" + job + ", leave_type="
				+ leave_type + "]";
	}
	
	
}
