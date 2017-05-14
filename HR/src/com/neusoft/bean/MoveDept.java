package com.neusoft.bean;

import java.sql.Date;

public class MoveDept {
	private Integer eid;
	private String ename;
	private String dname;
	private String newdname;
	private Date tmdate;
	private String tmtype;
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getNewdname() {
		return newdname;
	}
	public void setNewdname(String newdname) {
		this.newdname = newdname;
	}
	public Date getTmdate() {
		return tmdate;
	}
	public void setTmdate(Date tmdate) {
		this.tmdate = tmdate;
	}
	public String getTmtype() {
		return tmtype;
	}
	public void setTmtype(String tmtype) {
		this.tmtype = tmtype;
	}
}
