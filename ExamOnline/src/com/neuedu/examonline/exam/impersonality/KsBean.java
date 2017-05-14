package com.neuedu.examonline.exam.impersonality;
import java.sql.*;
import java.util.*;

import com.neuedu.examonline.db.*;
public class KsBean extends BaseBean{
	public int hangshu(String q_ksm, String q_ksbh,String q_jzbh) {

		Connection conn = this.conn();
		Statement stat = null;
		ResultSet rs = null;

		int rowTotal = 0;
		try {
			String sql = "select count(*) as rowTotal from exam_management where 1=1 ";

			if (!"".equals(q_ksm)) {
				sql = sql + "and exam_name like'%" + q_ksm + "%'  ";
			}
			if (!"".equals(q_ksbh)) {
				sql = sql + "and id like'%" + q_ksbh + "%'  ";
			}
			if (!"".equals(q_jzbh)) {
				sql = sql + "and paper_id like'%" + q_jzbh + "%'  ";
			}
			//System.out.println("sql--:" + sql);
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if (rs.next()) {

				rowTotal = rs.getInt("rowTotal");
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

		return rowTotal;

	}
	
	public List ksm(String q_ksm, String q_ksbh,String q_jzbh,int rowIndex, int pageSize){

		Connection conn = this.conn();
		Statement stat = null;
		ResultSet rs = null;
		List l1 = new ArrayList();
		try {
			String sql = "select * from exam_management where 1=1 ";
			if (!"".equals(q_ksm)) {
				sql = sql + "and exam_name like'%" + q_ksm + "%'  ";
			}
			if (!"".equals(q_ksbh)) {
				sql = sql + "and id like'%" + q_ksbh + "%'  ";
			}
			if (!"".equals(q_jzbh)) {
				sql = sql + "and paper_id like'%" + q_jzbh + "%'  ";
			}
			//System.out.println("sql--:" + sql);
			stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rs = stat.executeQuery(sql);
			if (rowIndex == 0) {
				rs.beforeFirst();
			} else {
				rs.absolute(rowIndex);
			}
			int i=0;
			while (rs.next()) {
				
				if (i > (pageSize - 1)) {
					break;
				}
				KsObj ko = new KsObj();
				String id = rs.getString("id");
				String exam_namc = rs.getString("exam_name");
				String paper_id = rs.getString("paper_id");
				String start_time = rs.getString("start_time");
				String status = rs.getString("status");
				ko.setId(id);
				ko.setExam_namc(exam_namc);
				ko.setPaper_id(paper_id);
				ko.setStart_time(start_time);
				ko.setStatus(status);
				l1.add(ko);
				i++;
				
			}
		}
		catch (Exception e) {
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
        return l1;	
	}
		
	

}
