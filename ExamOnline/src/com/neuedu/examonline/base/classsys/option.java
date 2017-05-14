package com.neuedu.examonline.base.classsys;
import java.sql.*;
import java.util.*;
import com.neuedu.examonline.base.classsys.*;
import com.neuedu.examonline.db.*;


public class option {

	@SuppressWarnings("static-access")
	private static Connection ct = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static ConnectionFactory cf = new ConnectionFactory();
	public  List sel()
	{
	List ls = new ArrayList();
	
	String sql="select tname from teachers";
	
	System.out.println("sql--"+sql);//����

	try {
		ct = cf.get();
		
		ps = ct.prepareStatement(sql);
		
		rs = ps.executeQuery();
		
		if(rs==null)
		{
			return null;
		}
		
		while(rs.next())
		{
			String tname=rs.getString("tname");
			ls.add(tname);
			//System.out.println("��ӡ����Ϊ"+list);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	release.releasec(ct,ps,rs);
	
	return ls;
}
}
