package com.neusoft.mapping;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neusoft.bean.Department;
public class DepartmentMapping implements EntityMapping {
	public Object mapping(ResultSet rs) throws SQLException{
		Department dept=new Department();
		dept.setDeptno(rs.getInt("deptno"));
		dept.setDname(rs.getString("dname"));
		dept.setDtype(rs.getString("dtype"));
		dept.setPhone(rs.getString("phone"));
		dept.setFax(rs.getString("fax"));
		dept.setDescribe(rs.getString("describe"));
		dept.setSuperDept(rs.getString("superDept"));
		dept.setStartDay(rs.getDate("startDay"));
		return dept;
	}
	
}
