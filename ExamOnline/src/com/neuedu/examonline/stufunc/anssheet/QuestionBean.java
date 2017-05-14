package com.neuedu.examonline.stufunc.anssheet;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neuedu.examonline.db.BaseBean;

public class QuestionBean extends BaseBean {
	public List getSelectQuestion(String id){
		Connection conn=this.conn();
		Statement stat=null;
		ResultSet rs=null;
		List<Question> list=new ArrayList<Question>();//����id��ѯ����ѡ����
		try{
			String sql = "SELECT q.id as stid,q.*,em.paper_id "
					+ " FROM exam_management em,paper p,stsjgl s, question q"
					+ " WHERE em.paper_id = p.id" + " AND s.stid = q.id "
					+ " AND p.id= s.sjid"
					+ " AND type_id = 1" + " AND em.id=" + id;
			System.out.println("sql--:"+sql);
			stat=conn.createStatement();
			rs= stat.executeQuery(sql);
			while(rs.next()){
				String questiontext= rs.getString("questiontext"); 
				String a= rs.getString("A");           
				String b= rs.getString("B");           
				String c= rs.getString("C");            
				String d= rs.getString("D");          
				String e= rs.getString("E");
				String examNum=rs.getString("paper_id");
				String questions_id=rs.getString("stid");
				System.out.println("questions_id--:"+questions_id);
				Question q1=new Question(questiontext,a,b,c,d,e,questions_id,examNum);
				list.add(q1);
				

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
	public List getAnswerQuestion(String id){
		Connection conn=this.conn();
		Statement stat=null;
		ResultSet rs=null;
		List<Question> list2=new ArrayList<Question>();//����id��ѯ���м����
		try{
			String sql = "SELECT * "
					+ "FROM exam_management em,paper p,stsjgl s, question q"
					+ " WHERE em.paper_id = p.id" + " AND s.stid = q.id "
					+ " AND p.id= s.sjid"
					+ " AND type_id = 2" + " AND em.id=" + id;
			System.out.println("sql--:"+sql);
			stat=conn.createStatement();
			rs= stat.executeQuery(sql);
			while(rs.next()){
				String num =rs.getString("id");
				String questiontext= rs.getString("questiontext"); 
				String examNum=rs.getString("paper_id");
				String questions_id=rs.getString("stid");
				Question q2=new Question(questiontext,questions_id,examNum);
				list2.add(q2);

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
			return list2;

		}
	

}
