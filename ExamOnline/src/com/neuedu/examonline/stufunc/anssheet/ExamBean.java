package com.neuedu.examonline.stufunc.anssheet;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neuedu.examonline.db.BaseBean;

public class ExamBean extends BaseBean {

	
	public List getList(){
		Connection conn=this.conn();
		Statement stat = null;
		ResultSet rs = null;
		List<ExamView> list=new ArrayList<ExamView>();
		try{
			String sql="select * from EXAM_MANAGEMENT";
			System.out.println("sql--:"+sql);
			stat=conn.createStatement();
			rs= stat.executeQuery(sql);
			while(rs.next()){
				int id=rs.getInt("id");
				String exam_name=rs.getString("exam_name");
				int total_time=rs.getInt("total_time");
				Date start_time=rs.getDate("start_time");
				int status=rs.getInt("status");
				ExamView e1=new ExamView(id, exam_name,total_time,start_time, status);
				list.add(e1);
				

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
			return list;

		}
	
	
	
}
