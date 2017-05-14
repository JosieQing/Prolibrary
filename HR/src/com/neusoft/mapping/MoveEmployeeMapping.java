package com.neusoft.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.neusoft.bean.MoveEmployee;

public class MoveEmployeeMapping implements EntityMapping{

	public Object mapping(ResultSet rs) throws SQLException {
		MoveEmployee moveEmp=new MoveEmployee();
		moveEmp.setEid(rs.getInt("eid"));
		moveEmp.setEname(rs.getString("ename"));
		moveEmp.setJname(rs.getString("jname"));
		moveEmp.setNewjname(rs.getString("newjname"));
		moveEmp.setTmdate(rs.getDate("tmdate"));
		moveEmp.setTmtype(rs.getString("tmtype"));
		return moveEmp;
	}
	

		
	
}
