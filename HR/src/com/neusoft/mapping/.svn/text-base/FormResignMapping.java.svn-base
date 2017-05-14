package com.neusoft.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.neusoft.bean.FormResign;

public class FormResignMapping implements EntityMapping{

	public Object mapping(ResultSet rs) throws SQLException {
		FormResign resign=new FormResign();
		resign.setEid(rs.getInt("eid"));
		resign.setEname(rs.getString("ename"));
		resign.setTotype(rs.getString("totype"));
		resign.setTodate(rs.getDate("todate"));
		return resign;
	}


}
