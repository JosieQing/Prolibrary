package com.neuedu.examonline.system.info;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.neuedu.examonline.db.BaseBean;
import com.neuedu.examonline.db.ConnC3p0DS;

public class TeacherBean extends BaseBean{
	public TeacherObj getTeacherById(String id){
		Connection conn = this.conn();
 		Statement stat = null;
 		ResultSet rs = null;
 		TeacherObj to = new TeacherObj();
 		try{
 			String sql="select t.* from teachers t ,user_table u  where t.tno = u.t_id and u.idea="+id+" ";
 			System.out.println(sql);
 			stat = conn.createStatement();
 			rs = stat.executeQuery(sql);
 			if(rs.next()){
 				int tno = rs.getInt("tno");
 				String tname = rs.getString("tname");
 				String tage= rs.getString("tage");
 				String ttel = rs.getString("ttel");
 				String tsex = rs.getString("tsex");
 				String hiredate = rs.getString("hiredate");
 				String tremark = rs.getString("tremark");
 				to.setHiredate(hiredate);
 				to.setTage(tage);
 				to.setTname(tname);
 				to.setTno(tno);
 				to.setTremark(tremark);
 				to.setTsex(tsex);
 				to.setTtel(ttel);
 				
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
 		
 	   return to;
 		
    	 
    	 
    	 
     }
     public String getTnoById(String id){
    	 Connection conn = this.conn();
  		Statement stat = null;
  		ResultSet rs = null;
 		String tno = null;
  		try{
  		
  			String sql="select t.tno  from teachers t ,user_table u  where t.tno = u.t_id and u.idea="+id;
  			System.out.println(sql);
  			stat = conn.createStatement();
  			rs = stat.executeQuery(sql);
  			if(rs.next()){
  			 tno = rs.getString("tno");
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
  		
  	   return tno;
  		
     	 
     	 
     	 
      }
     public int updateTeacher(TeacherObj to){
    	 Connection conn = this.conn();
   		Statement stat = null;

  		int r= 0;
   		try{
   		
   			String sql="update teachers set tremark='"
					+to.getTremark()+"',ttel='"
					+to.getTtel()+"' where tno="+to.getTno(); 
   			System.out.println(sql);
   			stat = conn.createStatement();
   			r = stat.executeUpdate(sql);
   			
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
