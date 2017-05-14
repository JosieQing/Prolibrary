package com.neusoft.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.neusoft.bean.ProbationMan;

public class ProbationManMapping implements  EntityMapping{
	
	/**
	 * 将结果集映射为一个对象
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public Object mapping(ResultSet rs) throws SQLException {
			
		ProbationMan probationMan = new ProbationMan();
				
			probationMan.setPmid((rs.getInt("pmid")));
			probationMan.setEid(rs.getInt("eid"));
			probationMan.setRemarks(rs.getString("remarks"));
			probationMan.setResult(rs.getString("result"));
			probationMan.setProbationDay(rs.getDate("probationDay"));
			probationMan.setProbationTime(rs.getInt("probationTime"));
			probationMan.setState(rs.getString("state"));
			probationMan.setFormalDay(rs.getDate("formalDay"));
			probationMan.setLeaveDay(rs.getDate("leaveDay"));
			probationMan.setDelayDay(rs.getDate("delayDay"));
			probationMan.setEndDay(rs.getDate("endDay"));

			
			return 	probationMan;
		}
}
