package com.neuedu.examonline.report.export;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.examonline.db.BaseBean;


public class ScoreDetailsBean extends BaseBean{
	public List<ScoreDetails> studentScoreDetail(String student_id)
	{
		List<ScoreDetails> list=new ArrayList<ScoreDetails>();
		Connection conn1=null;
		Statement stat1 = null;
		ResultSet rs1 = null;
		
		
		Statement stat2 = null;
		ResultSet rs2 = null;
		
		try{
		 conn1 = DB.opendb();
			String sql="select cname from student where num='"+student_id+"'";
			System.out.println("sql--:"+sql);
			stat1 = conn1.createStatement();
			rs1 = stat1.executeQuery(sql);
			while(rs1.next()){
				
				
				String class_name=rs1.getString("cname");		
				String sql1="select num from student where cname='"+class_name+"'";
			
				try{
					System.out.println("sql--:"+sql1);
					
					stat2 = conn1.createStatement();
					rs2 = stat2.executeQuery(sql1);
					while(rs2.next()){
						ScoreDetails sd =new ScoreDetails();
						sd.setStudent_id(rs2.getString("num"));	
						list.add(sd);
					}	
				}catch(Exception e){
					e.printStackTrace();
				}
								
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs2!=null){
					rs2.close();
				}
				if(stat2!=null){
					stat2.close();
				}
				
				if(rs1!=null){
					rs1.close();
				}
				if(stat1!=null){
					stat1.close();
				}
				if(conn1!=null){
					conn1.close();
				}
			}catch(SQLException sqle){
				sqle.printStackTrace();
			}			
		}
		//System.out.println(list.size());
		
		return list;
	}
}
