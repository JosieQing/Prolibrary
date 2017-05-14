package com.neusoft.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.neusoft.bean.Job;

public class JobMapping implements EntityMapping{
	public Object mapping(ResultSet rs) throws SQLException{
		Job job=new Job();
		job.setJobno(rs.getInt("jobno"));
		job.setJname(rs.getString("jname"));
		job.setJobStyle(rs.getString("jobStyle"));
		job.setJobCompile(rs.getInt("jobCompile"));
		job.setDeptno(rs.getInt("deptno"));
		return job;
	}
	
}
