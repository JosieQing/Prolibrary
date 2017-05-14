package com.neuedu.examonline.report.predict;

import java.sql.*;

public class check {
	public check() {

	}
public double[] checkbyid(String id){
	int max=0;
	double[] score=new double[max];
	Statement stat=null;
	ResultSet rs=null;
	Statement stat2=null;
	ResultSet rs2=null;
	Connection conn=null;
	System.out.println(id);
	try {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		 conn= DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:ORCL", "scott", "tiger");
		String sql = "select count(*) as c from cjb where id='"+id+"'";
		 
		 stat = conn.createStatement();
		 rs = stat.executeQuery(sql);
		while(rs.next()){
			max=rs.getInt("c");
		}
		score=new double[max];
		sql = "select * from cjb where id ='"+id+"'order by qdate";
		stat2 = conn.createStatement();
		rs2 = stat2.executeQuery(sql);
        int i=0;
        while(rs2.next()){
        	score[i]=rs2.getDouble("score");
        	i++;
        }
	} catch (Exception e) {
		e.printStackTrace();
	} finally{
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
			if(rs2!=null){
				rs2.close();
			}
			if(stat2!=null){
				stat2.close();
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
	}
	
return score;
}
	public double[] checkbyclass(String classname) {
		int max=0;
		double[] score=new double[max];
		Statement stat=null;
		ResultSet rs=null;
		Statement stat2=null;
		ResultSet rs2=null;
		Connection conn=null;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 conn= DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:ORCL", "scott", "tiger");
			 System.out.println(classname);
			String sql = "select count(*) as c from bjcjb where cname='"+classname+"'";
		System.out.println(sql);
			 stat = conn.createStatement();
			 rs = stat.executeQuery(sql);
			while(rs.next()){
				max=rs.getInt("c");
			}
			System.out.println(max);
			score=new double[max];
			sql = "select * from bjcjb where cname ='"+classname+"'order by cdate";
			stat2 = conn.createStatement();
			rs2 = stat2.executeQuery(sql);
            int i=0;
            while(rs2.next()){
            	score[i]=rs2.getDouble("cscore");
            	i++;
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
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
				if(rs2!=null){
					rs2.close();
				}
				if(stat2!=null){
					stat2.close();
				}
			}catch(SQLException sqle){
				sqle.printStackTrace();
			}
			
		}
		
	return score;
	}
}