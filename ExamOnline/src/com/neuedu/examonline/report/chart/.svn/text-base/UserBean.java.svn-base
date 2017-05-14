package com.neuedu.examonline.report.chart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserBean {

	/**
	 * 得到总记录数
	 * 
	 * @param query_name
	 * @param query_login
	 * @return
	 */
	public int getCount() {
		Connection conn = null;
		Statement stat = null;
		String id = null;
		ResultSet rs = null;
		int sjl = 0;
		try {
			conn = DB.opendb();
			String sql1 = "select count(*) as sjl from student";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql1);
			if (rs.next()) {
				sjl = rs.getInt("sjl");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stat != null) {
					stat.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}

		return sjl;
	}

	/**
	 * 得到列表
	 * 
	 * @param query_name
	 * @param query_login
	 * @return
	 */

	public List getList( int rowIndex,int pagesize) {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		List resultList = new ArrayList();
		int i = 0;
		try {
			conn = DB.opendb();
			String sql = "select * from student s join class_sys c on s.cno=c.cno order by num";
			stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stat.executeQuery(sql);
			if (rowIndex == 0) {
				rs.beforeFirst();
			} else {
				rs.absolute(rowIndex);
			}
			while (rs.next()) {
				if (i > pagesize - 1) {
					break;
				}
				Student uo = new Student();
				String num = rs.getString("num");
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String age = rs.getString("age");
				String cname = rs.getString("cname");
		uo.setSno(num);
		uo.setSname(name);
		uo.setSex(sex);
		uo.setSage(age);
		uo.setBname(cname);
				resultList.add(uo);
				i++;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stat != null) {
					stat.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}

		return resultList;
	}
	
	

}
