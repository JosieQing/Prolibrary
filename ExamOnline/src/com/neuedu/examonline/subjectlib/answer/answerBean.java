package com.neuedu.examonline.subjectlib.answer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.examonline.db.BaseBean;
import com.neuedu.examonline.db.ConnC3p0DS;
import com.neuedu.examonline.subjectlib.answer.*;

public class answerBean {
	
	public int getCount(String query_subject){
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@10.25.50.2:1521:orcl", "scott", "tiger");
		} catch (Exception e) {
			// TODO: handle exception
		}
		Statement stat = null;
		ResultSet rs = null;
		int rowTotal=0;                                                      
		try{
			String sql="select count(*) as rowTotal  from exam_subject where 1=1 ";
			if(!"".equals(query_subject)){
				sql = sql + " and subject like '%"+query_subject+"%' ";
			}
						
			System.out.println("sql--:"+sql);
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if(rs.next()){
				rowTotal=rs.getInt("rowTotal");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(stat!=null){
					stat.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException sqle){
				sqle.printStackTrace();
			}
			
		}
		return rowTotal;

	}

	
	
	public List getKgAnswerList(String query_subject,int rowIndex,int pageSize){
		
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@10.25.50.2:1521:orcl", "scott", "tiger");
		} catch (Exception e) {
			// TODO: handle exception
		}
		Statement stat = null;
		ResultSet rs = null;
		List resultList = new ArrayList();
		int i=0;
		try{
			String sql="select e.*,a.* from exam_subject e,answer_kg a where exam_id=kg_id";
			if(!"".equals(query_subject)){
				sql = sql + " and subject like '%"+query_subject+"%' ";
			}
			System.out.println("sql--:"+sql);
			stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = stat.executeQuery(sql);

			if(rowIndex==0){
				rs.beforeFirst();
			}else{
				rs.absolute(rowIndex);
			}

			while(rs.next()){
				if(i>(pageSize-1)){
					break;
				}
				
				answerObj ao = new answerObj();
				String exam_id = rs.getString("exam_id");
				String kg_id = rs.getString("kg_id");
				String subject = rs.getString("subject");
				String kg_answer = rs.getString("kg_answer");
				ao.setExam_id(exam_id);
				ao.setSubject(subject);	
				ao.setKg_answer(kg_answer);
				ao.setKg_id(kg_id);
				resultList.add(ao);
				//System.out.println(ao);
				i++;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(stat!=null){
					stat.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException sqle){
				sqle.printStackTrace();
			}
			
		}
		return resultList;

	}
	
	
	public List getZgAnswerList(String query_subject,int rowIndex,int pageSize){
	
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@10.25.50.2:1521:orcl", "scott", "tiger");
		} catch (Exception e) {
			// TODO: handle exception
		}
		Statement stat = null;
		ResultSet rs = null;
		List resultList = new ArrayList();
		int i=0;
		try{
			String sql="select e.*,a.* from exam_subject e,answer_zg a where exam_id=zg_id";
			if(!"".equals(query_subject)){
				sql = sql + " and subject like '%"+query_subject+"%' ";
			}
			System.out.println("sql--:"+sql);
			stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = stat.executeQuery(sql);
			if(rowIndex==0){
				rs.beforeFirst();
			}else{
				rs.absolute(rowIndex);
			}
			
			while(rs.next()){
				if(i>(pageSize-1)){
					break;
				}
				
				answerObj ao = new answerObj();
				String exam_id = rs.getString("exam_id");
				String zg_id = rs.getString("zg_id");
				String subject = rs.getString("subject");
				String zg_answer = rs.getString("zg_answer");
				ao.setExam_id(exam_id);
				ao.setSubject(subject);	
				ao.setZg_answer(zg_answer);
				ao.setZg_id(zg_id);
				resultList.add(ao);
				//System.out.println(ao);
				i++;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(stat!=null){
					stat.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException sqle){
				sqle.printStackTrace();
			}
			
		}
		return resultList;

	}
	
	
	
	public int updateKgAnswer(answerObj ao)
	
	{
		int r=0;
		Connection conn=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@10.25.50.2:1521:orcl", "scott", "tiger");
		} catch (Exception e) {
			// TODO: handle exception
		}
		Statement stat = null;
		ResultSet rs = null;
		try {
			String sql="update answer_kg set kg_answer='"+ao.getKg_answer()+"' where kg_id="+ao.getKg_id();
			System.out.println("sql--:"+sql);
			stat =conn.createStatement();
			r=stat.executeUpdate(sql);
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(stat!=null){
					stat.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException sqle){
				sqle.printStackTrace();
			}
			
		}
		return r;
	}
	
	public int updateZgAnswer(answerObj ao)
	
	{
		int r=0;
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@10.25.50.2:1521:orcl", "scott", "tiger");
		} catch (Exception e) {
			// TODO: handle exception
		}
		Statement stat = null;
		ResultSet rs = null;
		try {
			String sql="update answer_zg set zg_answer='"+ao.getZg_answer()+"' where zg_id="+ao.getZg_id();
			System.out.println("sql--:"+sql);
			stat =conn.createStatement();
			r=stat.executeUpdate(sql);
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(stat!=null){
					stat.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException sqle){
				sqle.printStackTrace();
			}
			
		}
		return r;
	}
	
	
	
	public String getKgAnswerById(String kg_id){
		String kg_answer=null;
		
		
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@10.25.50.2:1521:orcl", "scott", "tiger");
		} catch (Exception e) {
			// TODO: handle exception
		}
	Statement stat = null;
	ResultSet rs = null;

	try{
		String sql="select kg_answer from answer_kg where kg_id='"+kg_id+"'";
		
		System.out.println("sql--:"+sql);
		stat = conn.createStatement();
		rs = stat.executeQuery(sql);
		
		while(rs.next()){
			

			kg_answer = rs.getString("kg_answer");
	
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(rs!=null){
				rs.close();
			}
			if(stat!=null){
				stat.close();
			}
			if(conn!=null){
				conn.close();
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
	}

	
		return kg_answer;
	}
	
	
	
	public String getZgAnswerById(String zg_id){
		String zg_answer=null;
		
		
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@10.25.50.2:1521:orcl", "scott", "tiger");
		} catch (Exception e) {
			// TODO: handle exception
		}
	Statement stat = null;
	ResultSet rs = null;

	try{
		String sql="select zg_answer from answer_zg where zg_id='"+zg_id+"'";
		
		System.out.println("sql--:"+sql);
		stat = conn.createStatement();
		rs = stat.executeQuery(sql);
		
		while(rs.next()){
			

			zg_answer = rs.getString("zg_answer");
	
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(rs!=null){
				rs.close();
			}
			if(stat!=null){
				stat.close();
			}
			if(conn!=null){
				conn.close();
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
	}

	
		return zg_answer;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
