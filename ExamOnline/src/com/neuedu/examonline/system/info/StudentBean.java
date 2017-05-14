package com.neuedu.examonline.system.info;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.neuedu.examonline.db.BaseBean;
import com.neuedu.examonline.db.ConnC3p0DS;

public class StudentBean extends BaseBean{
     public StudentObj getStudentById(String id){
    	 Connection conn = this.conn();
 		Statement stat = null;
 		ResultSet rs = null;
		StudentObj so = new StudentObj();
 		try{
 			String sql="select s.* from student s ,user_table u  where s.cno = u.s_id and u.idea="+id+" ";
 			System.out.println(sql);
 			stat = conn.createStatement();
 			rs = stat.executeQuery(sql);
 			if(rs.next()){
 				String num = rs.getString("num");
 				String sex = rs.getString("sex");
 				String age = rs.getString("age");
 				String banji = rs.getString("class");
 				String cno = rs.getString("cno");
 				String name = rs.getString("name");
 				so.setAge(age);
 				so.setBanji(banji);
 				so.setCno(cno);
 				so.setName(name);
 				so.setNum(num);
 				so.setSex(sex);
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
 		
 	   return so;
 		
    	 
    	 
    	 
     }
     public String getNumById(String id){
    	 Connection conn = this.conn();
  		Statement stat = null;
  		ResultSet rs = null;
 		String num = null;
  		try{
  		
  			String sql="select s.num  from student s ,user_table u  where s.cno = u.s_id and u.idea="+id+" ";
  			System.out.println(sql);
  			stat = conn.createStatement();
  			rs = stat.executeQuery(sql);
  			if(rs.next()){
  			 num = rs.getString("num");
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
  		
  	   return num;
  		
     	 
     	 
     	 
      }
     public int updateStudent(StudentObj so){
    	 Connection conn = this.conn();
   		Statement stat = null;

  		int r= 0;
   		try{
   		
   			String sql="update student set name='"
					+so.getName()+"',age='"
					+so.getAge()+"',sex='"
					+so.getSex()+"',class='"
					+so.getBanji()+"' where num="+so.getNum(); 
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
