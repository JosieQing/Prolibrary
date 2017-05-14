package com.neuedu.examonline.exam.impersonality;
import java.sql.*;
import java.util.*;

import com.neuedu.examonline.db.*;

public class CjBean extends BaseBean{
	
	public void pj(String ksbh1){
		Connection conn = this.conn();
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			String sql = "select b.num,b.name,b.cname,a.questions_id,a.examanswer,e.kg_id,e.kg_answer,d.fen,c.id "
					+ "from answer_kg e,stsjgl d,student b,exam_management c，exam_result a "
					+ "where a.stu_id=b.num and a.questions_id=d.stid and d.sjid=c.paper_id "
					+ "and e.kg_id=a.questions_id and c.id=a.examnum and c.id='"+ksbh1+"' ";
			System.out.println("sql--:" + sql);
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			while (rs.next()) {
				System.out.println("rrrrssss");
				String  da= rs.getString(5);
				String zqda = rs.getString(7);
				int fz = rs.getInt(8);
				String xh = rs.getString(1);
				String xm = rs.getString(2);
				String bj = rs.getString(3);
				String ksbh = rs.getString(9);
//			System.out.println("dddss1");
//			System.out.println(da);
//			System.out.println(zqda);
				if(da==null){
					da="";
				}
				if(da.equals(zqda)){
					cj(xh,xm,bj,ksbh,fz);
					//System.out.println("dddss2");
				}else{
					fz=0;
					cj(xh,xm,bj,ksbh,fz);
					//System.out.println("dddss3");
				}
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
	} 
public void cj(String xh,String xm,String bj,String ksbh,int fz){
	Connection conn = this.conn();
	Statement stat = null;
	ResultSet rs = null;
	try {
		String sql = "select * from kgcj where xh='"+xh+"' and ksbh='"+ksbh +"' ";
		//System.out.println("sql--:" + sql);
		stat = conn.createStatement();
		rs = stat.executeQuery(sql);
		if(rs.next()){
			jf(xh,fz);
		}else{
			jr(xh,xm,bj,ksbh,fz);
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
}
public void jf(String xh,int fz){
	Connection conn = this.conn();
	Statement stat = null;
	ResultSet rs = null;
	try {
		String sql = " update kgcj set fs=fs+'"+fz+"' where xh='"+xh+"' ";
		//System.out.println("sql--:" + sql);
		stat = conn.createStatement();
		stat.executeUpdate(sql);
		
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
}
public void jr(String xh,String xm,String bj,String ksbh,int fz){
	Connection conn = this.conn();
	Statement stat = null;
	ResultSet rs = null;
	try {
		String sql = " insert into kgcj(xh,xm,bj,ksbh,fs) values('"+xh+"','"+xm+"','"+bj+"','"+ksbh+"','"+fz+"')";
		//System.out.println("sql--:" + sql);
		stat = conn.createStatement();
		stat.executeUpdate(sql);
		
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
}
public int hangshu(String q_bj, String q_ksbh) {
	Connection conn = this.conn();
	Statement stat = null;
	ResultSet rs = null;

	int rowTotal = 0;
	try {
		String sql = "select count(*) as rowTotal from kgcj where 1=1 ";

		if (!"".equals(q_bj)) {
			sql = sql + "and bj like'%" + q_bj + "%'  ";
		}
		if (!"".equals(q_ksbh)) {
			sql = sql + "and ksbh like'%" + q_ksbh + "%'  ";
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

public List cjb(String q_bj, String q_ksbh, int rowIndex, int pageSize){
	Connection conn = this.conn();
	Statement stat = null;
	ResultSet rs = null;
	List l3 = new ArrayList();
	int i = 0;
	try {
		String sql = "select * from kgcj where 1=1";
		if (!"".equals(q_bj)) {
			sql = sql + "and bj like'%" + q_bj + "%'  ";
		}
		if (!"".equals(q_ksbh)) {
			sql = sql + "and ksbh like'%" + q_ksbh + "%'  ";
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
		while (rs.next()) {
			if (i > (pageSize - 1)) {
				break;
			}
			CjbObj co = new CjbObj();
			String xh = rs.getString("xh");
			String xm = rs.getString("xm");
			String bj = rs.getString("bj");
			String stmc = rs.getString("ksbh");
			int fs = rs.getInt("fs");
		    co.setXh(xh);
		    co.setXm(xm);
		    co.setBj(bj);
		    co.setStmc(stmc);
		    co.setFs(fs);
			l3.add(co);
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
	return l3;
}
}
