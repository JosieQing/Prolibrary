package com.neuedu.examonline.report.export;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.examonline.db.BaseBean;


public class StudentQueryBean extends BaseBean{
	public List<StudentQuery> studentScoreQuery(String student_id)
	{
		List<StudentQuery> list=new ArrayList<StudentQuery>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		
		Statement stat1 = null;
		ResultSet rs1 = null;
		
		
		Statement stat2 = null;
		ResultSet rs2 = null;
		try{
			conn=DB.opendb();
			String kgsql="select xh,xm,bj,ksbh,fs from kgcj where xh='"+student_id+"'";  //在客观成绩表里通过 学生id查到 考试id和客观成绩分数
			System.out.println("sql--:"+kgsql);
			stat = conn.createStatement();
			rs = stat.executeQuery(kgsql);
			while(rs.next()){//大while循环开始
				
				StudentQuery sq=new StudentQuery();
				sq.setStudent_id(rs.getString("xh"));
				sq.setName(rs.getString("xm"));
				sq.setClass_name(rs.getString("bj"));
				sq.setExam_id(rs.getString("ksbh"));
				sq.setKg_score(rs.getDouble("fs"));
			
				String kssql="select exam_name,start_time from exam_management where id='"+sq.getExam_id()+"'";//在考试管理表通过考试id查到考试名称和考试开始时间
				
				try{
					
					System.out.println("sql--:"+kssql);
					stat1 = conn.createStatement();
					rs1 = stat1.executeQuery(kssql);
					
					while(rs1.next()){
						sq.setExam_name(rs1.getString("exam_name"));	
						sq.setStart_time(rs1.getString("start_time"));						
					}	
				}catch(Exception e){
					e.printStackTrace();
				}
					
									
				String zgsql="select sum(score) from zgcj where stuid='"+student_id+"' and  exam_id ='"+sq.getExam_id()+"'";//在主管成绩表里 通过考试id查到 主管分数总和
				
				try{					
					System.out.println("sql--:"+zgsql);
					stat2 = conn.createStatement();
					rs2 = stat2.executeQuery(zgsql);
					while(rs2.next()){
						sq.setZg_score(rs2.getDouble(1));						
					}	
				}catch(Exception e){
					e.printStackTrace();
				}
				
				sq.add(sq.getZg_score(),sq.getKg_score());//把主管成绩和客观成绩加起来放到对象里
				
				list.add(sq);//得到所有对象后 放到list集合里
				
			}//大while循环结束
		}catch(Exception e){
			e.printStackTrace();
		}finally{		
			try{
				if(rs1!=null){
					rs1.close();
				}
				if(stat1!=null){
					stat1.close();
				}

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
		return list;
	}
}
