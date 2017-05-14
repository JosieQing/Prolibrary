package com.neusoft.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.neusoft.bean.Admin;

public class AdminMapping implements  EntityMapping{
	
	/**
	 * 将结果集映射为一个对象
	 * @throws SQLException 
	 */

	public Object mapping(ResultSet rs) throws SQLException {
		
		Admin admin = new Admin();
			
		admin.setId((rs.getInt("id")));
		admin.setUsername(rs.getString("username"));
		admin.setPassword(rs.getString("password"));
		admin.setEid(rs.getInt("eid"));
		admin.setEname(rs.getString("ename"));
		admin.setUsertype(rs.getString("usertype"));
		return admin;
	}

}
