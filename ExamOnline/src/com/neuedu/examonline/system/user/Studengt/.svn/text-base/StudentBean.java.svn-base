package com.neuedu.examonline.system.user.Studengt;
import com.neuedu.examonline.db.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentBean extends BaseBean {

public List student(){
		
		List rList = new ArrayList();
		Connection conn = this.conn();
		Statement stustat = null;
		ResultSet sturs = null;
		
		String student_id = null;
		String student_name = null;
		
		try{
			String selsql = "SELECT * FROM student";
			stustat = conn.createStatement();
			sturs = stustat.executeQuery(selsql);
			while(sturs.next()){
				student_id = sturs.getString("num");
				student_name = sturs.getString("name");
				StudentObject t = new StudentObject();
				t.setNumber_id(student_id);
				t.setStudent_name(student_name);
				rList.add(t);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(stustat!=null){
					stustat.close();
				}
				if(sturs!=null){
					sturs.close();
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
