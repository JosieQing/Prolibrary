package com.neuedu.examonline.report.chart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentBean {
	public List Select(List a,int djy,int pagesize) {
		String sno;
		String sname;
		String sex;
		String bname;
		String sage;
		List b=new ArrayList();
		Connection conn=null;
		Statement stat=null;
		ResultSet rs = null;
		int i=0;
		try{
		 conn =DB.opendb();
		stat = conn.createStatement();
		Iterator it = a.listIterator();
		while (it.hasNext()) {
			String sql = "select * from student s,class_sys c where s.cno=c.cno and num="+ it.next();
			rs = stat.executeQuery(sql);
			if(rs.next()){
			if(i>=(djy-1)*pagesize&&i<djy*pagesize){
			sno = rs.getString("num");
			sname = rs.getString("name");
			sex = rs.getString("sex");
			bname = rs.getString("cname");
			sage = rs.getString("age");
			Student s=new Student();
			s.setSno(sno);
			s.setSname(sname);
			s.setSex(sex);
			s.setBname(bname);
			s.setSage(sage);
			b.add(s);
			}
			}i++;
		}
		}catch(SQLException e){
		e.printStackTrace();} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(conn!=null){
	    		if(stat!=null){
	    			if(rs!=null){
	    				try{
	    					rs.close();
	    				}catch(SQLException e){
	    					e.printStackTrace();
	    				}
	    			}
	    			try{
						stat.close();
					}catch(SQLException e){
						e.printStackTrace();
					}
	    		}
	    		try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
	    	}
		}
return b;
}
	public List muHu(String a){
		List b=new ArrayList();
		Connection conn=null;
		Statement stat=null;
		ResultSet rs = null;
		try{
		 conn =DB.opendb();
		stat = conn.createStatement();
        String sql="select * from student s join class_sys c on s.cno=c.cno where num like '%" + a + "%' or name like '%" + a + "%' or cname like '%" + a + "%' or age like '%" + a + "%' or sex like '%" + a + "%' order by num";
        
        rs=stat.executeQuery(sql);
		while (rs.next()) {
			String s=rs.getString("num");
			b.add(s);
		}
		}catch(SQLException e){
		e.printStackTrace();} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(conn!=null){
	    		if(stat!=null){
	    			if(rs!=null){
	    				try{
	    					rs.close();
	    				}catch(SQLException e){
	    					e.printStackTrace();
	    				}
	    			}
	    			try{
						stat.close();
					}catch(SQLException e){
						e.printStackTrace();
					}
	    		}
	    		try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
	    	}
		}
return b;
	}
	
	public List gMuHu(String a,String c,String d,String f,String g){
		List b=new ArrayList();
		Connection conn=null;
		Statement stat=null;
		ResultSet rs = null;
		try{
		 conn =DB.opendb();
		stat = conn.createStatement();
        String sql="select * from student s join class_sys c on s.cno=c.cno where 1=1";
    	if (!"".equals(a)) {
			sql = sql + "and  num like '%" + a + "%'";
		}
    	if (!"".equals(c)) {
			sql = sql + "and  name like '%" + c + "%'";
		}
    	if (!"".equals(d)) {
			sql = sql + "and  sex like '%" + d + "%'";
		}
    	if (!"".equals(f)) {
			sql = sql + "and  cname like '%" + f + "%'";
		}
    	if (!"".equals(g)) {
			sql = sql + "and  age like '%" + g + "%'";
		}
    	sql=sql+"order by num";
        rs=stat.executeQuery(sql);
		while (rs.next()) {
			String s=rs.getString("num");
			b.add(s);
		}
		}catch(SQLException e){
		e.printStackTrace();} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(conn!=null){
	    		if(stat!=null){
	    			if(rs!=null){
	    				try{
	    					rs.close();
	    				}catch(SQLException e){
	    					e.printStackTrace();
	    				}
	    			}
	    			try{
						stat.close();
					}catch(SQLException e){
						e.printStackTrace();
					}
	    		}
	    		try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
	    	}
		}
return b;
	}
	
	public List kaoShiMing(String a){
		List b=new ArrayList();
		Connection conn=null;
		Statement stat=null;
		ResultSet rs = null;
		try{
		 conn =DB.opendb();
		stat = conn.createStatement();
        String sql="select * from kgcj k join exam_management e on k.ksbh=e.id where exam_name='"+a+"' order by xh";
        rs=stat.executeQuery(sql);
		while (rs.next()) {
			String s=rs.getString("xh");
			b.add(s);
		}
		}catch(SQLException e){
		e.printStackTrace();} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(conn!=null){
	    		if(stat!=null){
	    			if(rs!=null){
	    				try{
	    					rs.close();
	    				}catch(SQLException e){
	    					e.printStackTrace();
	    				}
	    			}
	    			try{
						stat.close();
					}catch(SQLException e){
						e.printStackTrace();
					}
	    		}
	    		try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
	    	}
		}
return b;
	}
	
	
	public List kaoShiZu(String a){
		List<String> b=new ArrayList<String>();
		Connection conn=null;
		Statement stat=null;
		ResultSet rs = null;
		try{
		 conn =DB.opendb();
		stat = conn.createStatement();
        String sql="select xh from kgcj k join exam_management e on k.ksbh=e.id join ks_zu ks on ks.kszno=e.kszno where miaosu='"+a+"' group by xh order by xh";
        rs=stat.executeQuery(sql);
		while (rs.next()) {
			String s=rs.getString("xh");
			b.add(s);
		}
		}catch(SQLException e){
		e.printStackTrace();} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		finally{
			if(conn!=null){
	    		if(stat!=null){
	    			if(rs!=null){
	    				try{
	    					rs.close();
	    				}catch(SQLException e){
	    					e.printStackTrace();
	    				}
	    			}
	    			try{
						stat.close();
					}catch(SQLException e){
						e.printStackTrace();
					}
	    		}
	    		try{
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
	    	}
		}
return b;
	}
}