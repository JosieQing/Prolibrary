package com.neuedu.examonline.base.student;
import java.sql.*;
import java.util.*;

import com.neuedu.examonline.db.BaseBean;
import com.neuedu.examonline.base.student.*;



public class option extends BaseBean {

	@SuppressWarnings("static-access")
	private static Connection ct = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	@SuppressWarnings("finally")
	public  List sel()
	{
	List ls = new ArrayList();
	
	String sql="select cname from class_sys";
	
	System.out.println("sql--"+sql);//����

	try {
		ct =  this.conn();
		
		ps = ct.prepareStatement(sql);
		
		rs = ps.executeQuery();
		
		if(rs==null)
		{
			return null;
		}
		
		while(rs.next())
		{
			String cname=rs.getString("cname");
			ls.add(cname);
			//System.out.println("��ӡ����Ϊ"+list);
		}
		
	} catch(Exception e){
		e.printStackTrace();

	}finally{
		try{
			if(rs!=null){
				rs.close();
			}
			
			if(ps!=null){
				ps.close();
			}
			if(ct!=null){
				ct.close();
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
	
	
	return ls;
}
}
}
