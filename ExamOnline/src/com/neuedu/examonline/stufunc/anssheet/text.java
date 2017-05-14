package com.neuedu.examonline.stufunc.anssheet;

import java.sql.*;

import com.neuedu.examonline.db.BaseBean;


public class text extends BaseBean{

	public int gettotal_time(String id) throws SQLException//��õ�ǰ����ʱ��
	{
		
		String sql="SELECT total_time from exam_management where id="+id;
		System.out.println("sql--:"+sql);
		Connection conn=this.conn();
		Statement stat=null;
		ResultSet rs=null;
		stat=conn.createStatement();
		rs= stat.executeQuery(sql);
		int total_time = 0;
		try{
			if(rs.next())
			{
				total_time=rs.getInt("total_time");
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
		return total_time;
	}
	public String getexam_name(String id) throws SQLException{
		String sql="SELECT exam_name FROM exam_management WHERE id="+ id;
		System.out.println("sql--:"+sql);
		Connection conn=this.conn();
		Statement stat=null;
		ResultSet rs=null;
		stat=conn.createStatement();
		rs= stat.executeQuery(sql);
		String exam_name=null;
		try{
			if(rs.next())
			{
			   exam_name=rs.getString("exam_name");
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
		return exam_name;
	}
	public String getexamNum(String id) throws SQLException//����Ծ���
	{
		
		String sql="SELECT paper_id from exam_management where id="+id;
		System.out.println("sql--:"+sql);
		Connection conn=this.conn();
		Statement stat=null;
		ResultSet rs=null;
		stat=conn.createStatement();
		rs= stat.executeQuery(sql);
		String paper_id = null;
		try{
			if(rs.next())
			{
				paper_id=rs.getString("paper_id");
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
		return paper_id;
	}
	
	
}
