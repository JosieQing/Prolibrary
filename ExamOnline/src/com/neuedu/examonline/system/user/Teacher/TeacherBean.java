package com.neuedu.examonline.system.user.Teacher;
import com.neuedu.examonline.db.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherBean extends BaseBean {
	
	public List teacher(){
		
		List rList = new ArrayList();
		Connection conn = this.conn();
		Statement teastat = null;
		ResultSet tears = null;
		
		String teacher_id = null;
		String teacher_name = null;
		
		try{
			String selsql = "SELECT * FROM teachers";
			teastat = conn.createStatement();
			tears = teastat.executeQuery(selsql);
			while(tears.next()){
				teacher_id = tears.getString("tno");
				teacher_name = tears.getString("tname");
				TeacherValueObject t = new TeacherValueObject();
				t.setNumber_id(teacher_id);
				t.setTeacher_name(teacher_name);
				rList.add(t);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(teastat!=null){
					teastat.close();
				}
				if(tears!=null){
					tears.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		
		return rList;
	}
}
