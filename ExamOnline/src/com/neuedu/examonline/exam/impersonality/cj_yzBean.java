package com.neuedu.examonline.exam.impersonality;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.neuedu.examonline.db.BaseBean;

public class cj_yzBean extends BaseBean{
	public int yz(int ksbh2) {

		Connection conn = this.conn();
		Statement stat = null;
		ResultSet rs = null;
		boolean flag = false;
		try {

			String sql = "select * from kgcj where ksbh='" + ksbh2 + "' ";
			System.out.println("sql--:" + sql);
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if (rs.next()) {
				flag = true;
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

		if (flag) {
			return 1;
		} else {
			return 0;
		}
	}

	public String yz2(int ksbh2) {
		Connection conn = this.conn();
		Statement stat = null;
		ResultSet rs = null;
		String kszt = null;
		try {

			String sql = "select * from exam_management where id='" + ksbh2
					+ "'  ";
			System.out.println("sql--:" + sql);
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				kszt = rs.getString("status");
				System.out.println(kszt + "aaaaaa");
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

		return kszt;
	}
}
