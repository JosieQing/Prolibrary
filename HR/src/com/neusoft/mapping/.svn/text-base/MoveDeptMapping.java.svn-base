package com.neusoft.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.neusoft.bean.MoveDept;

public class MoveDeptMapping implements EntityMapping{

	public Object mapping(ResultSet rs) throws SQLException {
		MoveDept movedept=new MoveDept();
		movedept.setEid(rs.getInt("eid"));
		movedept.setEname(rs.getString("ename"));
		movedept.setDname(rs.getString("dname"));
		movedept.setNewdname(rs.getString("newdname"));
		movedept.setTmdate(rs.getDate("tmdate"));
		movedept.setTmtype(rs.getString("tmtype"));
		return movedept;

	}

	
}
