package com.neuedu.examonline.base.student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.examonline.db.*;
public class ListBean extends BaseBean {


	
	public int updateList (ListObj uo){
		int r=0;
		Connection conn = this.conn();
		Statement stat = null;
		ResultSet rs = null;
		try{
			String sql="update student set name='"+uo.getName()+"', num='"+uo.getNum()+"',sex='"+uo.getSex()+"',age='"+uo.getAge()+"',cname='"+uo.getCname()+"' where num='"+uo.getNum()+"'";
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
	public int addList(ListObj uo) {
		int r=0;
		Connection conn = this.conn();
		Statement stat = null;
		ResultSet rs = null;
		try{
			//拼写入库的sql语句
			String sql="insert into student(name,num,sex,age,cname)values('"+uo.getName()+"','"+uo.getNum()+"','"+uo.getSex()+"','"+uo.getAge()+"','"+uo.getCname()+"')";
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
	
