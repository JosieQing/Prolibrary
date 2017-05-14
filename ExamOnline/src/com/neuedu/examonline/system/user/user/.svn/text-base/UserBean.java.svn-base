package com.neuedu.examonline.system.user.user;
import com.neuedu.examonline.db.*;

import java.sql.*;

public class UserBean extends BaseBean {

	public int getCount(String name){
		Connection conn = this.conn();
		Statement beanstat = null;
		ResultSet beanrs = null;
		int rowTotal=0;
		try{
			String sql="select count(*) as rowTotal from user_table where 1=1";
			if(name!=null && !"".equals(name)){
				sql+=" and login_name like '%"+ name + "%'";
			}
			beanstat = conn.createStatement();
			beanrs = beanstat.executeQuery(sql);
			if(beanrs.next()){
				rowTotal=beanrs.getInt("rowTotal");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(beanrs!=null){
					beanrs.close();
				}
				if(beanstat!=null){
					beanstat.close();
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
}
