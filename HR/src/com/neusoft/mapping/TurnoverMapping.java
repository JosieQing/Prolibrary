package com.neusoft.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.neusoft.bean.Turnover;

public class TurnoverMapping implements EntityMapping{

	public Object mapping(ResultSet rs) throws SQLException {
		Turnover turn=new Turnover();
		turn.setLid(rs.getInt("lid"));
		turn.setEid(rs.getInt("eid"));
		turn.setTodate(rs.getDate("todate"));
		turn.setTotype(rs.getString("totype"));
		turn.setReason(rs.getString("reason"));
		turn.setOperator(rs.getString("operator"));
		turn.setEname(rs.getString("ename"));
		return turn;
	}
	

}
