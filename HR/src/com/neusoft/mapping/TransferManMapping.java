package com.neusoft.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.neusoft.bean.TransferMan;

/**
 * 将结果集映射为一个对象
 * @param rs
 * @return
 * @throws SQLException
 */
public class TransferManMapping implements  EntityMapping{		
	public Object mapping(ResultSet rs) throws SQLException {
		
		TransferMan transferMan = new TransferMan();
		
		transferMan.setTmid((rs.getInt("tmid")));
		transferMan.setEid(rs.getInt("eid"));
		transferMan.setOldDname(rs.getString("oldDname"));
		transferMan.setOldJname(rs.getString("oldJname"));
		transferMan.setNewDname(rs.getString("newDname"));
		transferMan.setNewJname(rs.getString("newJname"));
		transferMan.setTmType(rs.getString("tmType"));
		transferMan.setReason(rs.getString("reason"));
		transferMan.setTmDate(rs.getDate("tmDate"));
		
		return 	transferMan;
	}
}
