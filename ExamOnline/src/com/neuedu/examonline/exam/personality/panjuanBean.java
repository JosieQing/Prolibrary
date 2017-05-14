package com.neuedu.examonline.exam.personality;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class panjuanBean {
	
	public int getCount(){
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
			String sql="select count(*) as rowTotal  from stu_zg_answer";			
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
	
	public List getList(int rowIndex,int pageSize){
		
			Connection conn=null;
			
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					conn = DriverManager.getConnection(
							"jdbc:oracle:thin:@10.25.50.2:1521:orcl", "scott", "tiger");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			Statement stat = null;
			ResultSet rs = null;
			List resultList = new ArrayList();
			int i=0;
			try{
				String sql="select e.*,a.*,c.*,s.* from exam_subject e,answer_zg a,cjb c,stu_zg_answer s where e.exam_id=a.zg_id and s.stu_id=c.stu_id and s.zg_id=e.exam_id";
				
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
					panjuanObj po = new panjuanObj();
					String stu_name = rs.getString("stu_name");
					String stu_id = rs.getString("stu_id");
					String exam_id = rs.getString("exam_id");
					String subject = rs.getString("subject");
					String zg_answer = rs.getString("zg_answer");
					String stu_zg_answer = rs.getString("stu_zg_answer");
					String score=rs.getString("score");
					po.setStu_name(stu_name);
					po.setStu_id(stu_id);
					po.setExam_id(exam_id);
					po.setSubject(subject);	
					po.setZg_answer(zg_answer);
					po.setStu_zg_answer(stu_zg_answer);
					po.setScore(score);
					resultList.add(po);
					//System.out.println(po);
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
	
	
	public int updateCj(panjuanObj po)
	{
		int r=0;
		Connection conn=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@10.25.50.2:1521:orcl", "scott", "tiger");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Statement stat = null;
		ResultSet rs = null;
		try {
			String sql="update STU_ZG_ANSWER set score='"+po.getScore()+"' where zg_id='"+po.getZg_id()+"' and stu_id='"+po.getStu_id()+"'";
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

}
