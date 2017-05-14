package com.neuedu.examonline.report.chart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class XiaLaBean {
	public List banJi(){
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		List resultList = new ArrayList();
		try {
			conn = DB.opendb();
			String sql = "select * from class_sys order by cno";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			while (rs.next()) {
				String cname = rs.getString("cname");
				resultList.add(cname);
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
	public List kaoShiMing(){
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		List resultList = new ArrayList();
		try {
			conn = DB.opendb();
			String sql = "select * from exam_management order by id";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			while (rs.next()) {
				String exam_name = rs.getString("exam_name");
				resultList.add(exam_name);
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
	public List kaoShiZu(){
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		List resultList = new ArrayList();
		try {
			conn = DB.opendb();
			String sql = "select * from ks_zu order by kszno";
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			while (rs.next()) {
				String miaosu = rs.getString("miaosu");
				resultList.add(miaosu);
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
