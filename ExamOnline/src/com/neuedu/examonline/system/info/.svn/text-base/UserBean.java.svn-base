package com.neuedu.examonline.system.info;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.neuedu.examonline.db.BaseBean;
import com.neuedu.examonline.db.ConnC3p0DS;
public class UserBean extends BaseBean{
	public String getRoleById(String id){
		Connection conn = this.conn();
		Statement stat = null;
		ResultSet rs = null;
		String role = null;
		try{
			String sql="select role from user_table where idea="+id+" ";
			System.out.println(sql);
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if(rs.next()){
				 role= rs.getString("role");
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
		
	   return role;
		
		
	}

}
