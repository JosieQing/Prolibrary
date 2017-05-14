package com.neusoft.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.neusoft.bean.FormNewEmployee;

public class FormNewEmployeeMapping implements EntityMapping{

	public Object mapping(ResultSet rs) throws SQLException {
		FormNewEmployee formnew=new FormNewEmployee();
		formnew.setEid(rs.getInt("eid"));
		formnew.setDname(rs.getString("dname"));
		formnew.setJname(rs.getString("jname"));
		formnew.setEname(rs.getString("ename"));
		/*formnew.setSex(rs.getString("sex"));*/
		String s=rs.getString("sex");
		if(s.equals("0")){
			formnew.setSex("ÄÐ");
		}else if(s.equals("1")){
			formnew.setSex("Å®");
		}
		formnew.setWorkday(rs.getDate("workday"));
		formnew.setHighestEducation(rs.getString("highestEducation"));
	return formnew;
	}

	
	
}
