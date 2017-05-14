package com.neuedu.examonline;

import java.sql.*;

import com.neuedu.examonline.db.BaseBean;


public class LoginBean extends BaseBean{

	public String login(String uName,String pWord){
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		String id=null;
		boolean flag=false;
		try{
			
			String sql="select * from user_table where login_name='"+uName+"' and password='"+pWord+"'";
			System.out.println("sql--:"+sql);
			conn=this.conn();
			System.out.println("sql--:"+sql);
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if(rs.next()){
				id=rs.getString("idea");
				flag=true;
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
		
		if(flag==true){
			return id;
		}else{
			return null;
		}
		
		
	}
}
