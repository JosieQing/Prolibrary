package com.neuedu.examonline.system.user.Servlet;
import com.neuedu.examonline.db.*;

import java.sql.*;
import java.util.*;

public class AddBean extends BaseBean{
	
	public String addbean(String add_login,String add_pass,String add_select,String add_role,String add_remark,String number)
	{
		Connection conn = this.conn();
		Statement Teastat = null;
		Statement Stustat = null;
		
		Statement con = null;
		Statement sel = null;
		Statement ect = null;
		Statement stu = null;
		
		ResultSet conrs = null;
		ResultSet selrs = null;
		ResultSet ectrs = null;
		ResultSet sturs = null;
		
		String teacher_id = null;
		int rowTotal = 0;
		boolean flag = false;
		
		try{
			String selsql = "SELECT * FROM user_table where login_name = '"+add_login+"' and password = '"+add_pass+"'";
			sel = conn.createStatement();
			selrs = sel.executeQuery(selsql);
			if(selrs.next()){
				return "2";
			}else{
				String ectsql = "select count(*) as rowTotal from user_table";
				ect = conn.createStatement();
				ectrs = ect.executeQuery(ectsql);
				if(ectrs.next()){
					rowTotal = ectrs.getInt("rowTotal");
				}
				
				if(number.equals("teacher")){
					String consql = "SELECT * FROM teacher where tname = '"+add_select+"'";
					con = conn.createStatement();
					conrs = con.executeQuery(consql);
					if(conrs.next()){
						teacher_id = conrs.getString("tno");
					}else{
						teacher_id = null;
					}
					
					String sql="insert into user_table values ("+(rowTotal+1)+",'"+add_login+"',"
							+add_pass+",null,'"+add_role+"','"+add_remark+"',"+teacher_id+")";
					Teastat = conn.createStatement();
					int i = Teastat.executeUpdate(sql);
					if(i == 1){
						flag = true;
					}
				}
				if(number.equals("student")){
					String consql = "SELECT * FROM student where name = '"+add_select+"'";
					stu = conn.createStatement();
					sturs = stu.executeQuery(consql);
					if(sturs.next()){
						teacher_id = sturs.getString("num");
					}else{
						teacher_id = null;
					}
					
					String sql="insert into user_table values ("+(rowTotal+1)+",'"+add_login+"',"
							+add_pass+","+teacher_id+",'"+add_role+"','"+add_remark+"',null)";
					Stustat = conn.createStatement();
					int i = Stustat.executeUpdate(sql);
					if(i == 1){
						flag = true;
					}
				}			
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(stu!=null){
					stu.close();
				}
				if(sturs!=null){
					sturs.close();
				}
				
				if(ect!=null){
					ect.close();
				}
				if(selrs!=null){
					selrs.close();
				}
				
				if(ectrs!=null){
					ectrs.close();
				}
				if(selrs!=null){
					selrs.close();
				}
				
				if(con!=null){
					con.close();
				}
				if(conrs!=null){
					conrs.close();
				}
				
				if(Teastat!=null){
					Teastat.close();
				}
				if(Stustat!=null){
					Stustat.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		
		if(flag==true){
			return "1";
		}else{
			return "0";
		}
	}
}
