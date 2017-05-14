package com.neuedu.examonline.base.course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.examonline.db.*;


public class UserBean extends BaseBean{
	
	public int updateUser(UserObj uo){
		int r=0;
		Connection conn = this.conn();
		Statement stat = null;
		ResultSet rs = null;
		try{
			String sql="update course set id='"+uo.getId()+"',couse='"+uo.getCouse()+"' where id='"+uo.getId()+"'";
			System.out.println("sql--:"+sql);
			stat = conn.createStatement();
			r=stat.executeUpdate(sql);
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
		return r;
		
	}
	public int addUser(UserObj uo) {
		int r=0;
		Connection conn = this.conn();
		Statement stat = null;
		ResultSet rs = null;
		try{
			//拼写入库的sql语句
			String sql="insert into course(ID,couse)values('"+uo.getId()+"','"+uo.getCouse()+"')";
			System.out.println("sql--:"+sql);
			stat = conn.createStatement();
			r=stat.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
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
	

