package com.neuedu.examonline.exam.manager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.examonline.db.*;

public class UserBean extends BaseBean{
	/*
	 *
	 * */
		public int getCount(String query_name,String query_login){
			Connection conn = this.conn();
			Statement stat=null;
			ResultSet rs=null;
			int rowTotal=0;
			try{
				String sql="select count(*)as rowTotal from exam_management where 1=1";
			//	if(!"".equals(query_name)){
			//		sql=sql+"and real_name like '%"+query_name+"%' ";
			//	}
			//	if(!"".equals(query_login)){
			//		sql=sql+"and login_name like'%"+query_login+"%'";
					
			//	}
				System.out.println("sql--"+sql);
				stat =conn.createStatement();
				rs =stat.executeQuery(sql);
				if(rs.next()){
					rowTotal=rs.getInt("rowTotal");
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
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
			return rowTotal;
	}

	/*
	 * �õ��б�
	 * */
	
	public List getList(String exam_name1,String remark1,int test_paper_name1,int exam_class1){
		Connection conn = this.conn();
	//	Connection conn = ConnTomcatDS.getConn();
		Statement stat = null;
		ResultSet rs = null;
		
		List resultList = new ArrayList();
		int i=0;
		try{
			String sql="select * from exam_management where 1=1";
					
			System.out.println("sql--:"+sql);
			stat=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=stat.executeQuery(sql);

				UserObj uo=new UserObj();
				String id=rs.getString("id");
				String exam_name= rs.getString("exam_name");
				String remark=rs.getString("remark");
				String test_paper_name=rs.getString("test_paper_name");
				String exam_class=rs.getString("exam_class");
				uo.setId(id);
				uo.setExam_name(exam_name);
				uo.setRemark(remark);
				uo.setTest_paper_name(test_paper_name);
				uo.setExam_class(exam_class);
				resultList.add(uo);
				i++;
				
			
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
		return resultList;
	}
	
	public UserObj getUserById(String id){
		UserObj uo=new UserObj();
		Connection conn=this.conn();
		//Connection conn = ConnTomcatDS.getConn();
		Statement stat=null;
		ResultSet rs=null;
		try{
			String sql="select * from exam_management where id="+id;
			System.out.println("sql--:"+sql);
			stat =conn.createStatement();
			rs=stat.executeQuery(sql);
			if(rs.next()){
				String exam_name=rs.getString("exam_name");
				String remark=rs.getString("remark");
				String test_paper_name=rs.getString("test_paper_name");
				String exam_class=rs.getString("exam_class");
				uo.setId(id);
				uo.setExam_name(exam_name);
				uo.setRemark(remark);
				uo.setTest_paper_name(test_paper_name);
				uo.setExam_class(exam_class);
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
			}catch(SQLException sql){
				sql.printStackTrace();
			}
		}
		return uo;
	}
	public int updateUser(UserObj uo){
		int r=0;
		Connection conn = this.conn();
		//Connection conn = ConnTomcatDS.getConn();
		Statement stat = null;
		ResultSet rs = null;
		try{
			String sql="update exam_management set exam_name='"
					+uo.getExam_name()+"',remark='"
					+uo.getRemark()+"',test_paper_name='"
					+uo.getTest_paper_name()+"',exam_class='"
					+uo.getExam_class()+"' where id="+uo.getId();
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
	
	
	
	
	
	
	
	
	
	
	
	
}