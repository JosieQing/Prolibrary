package com.neuedu.examonline.base.classsys;
import java.sql.*;
import java.util.*;

import com.neuedu.examonline.base.classsys.*;
import com.neuedu.examonline.db.*;


public class select {

	@SuppressWarnings("static-access")
	private static Connection ct = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static ConnectionFactory cf = new ConnectionFactory();
	public static List<Class_control> sel(String name)
	{
	List<Class_control> list = new ArrayList<Class_control>();
	
	String sql="select * from class_sys where cname like '%"+name+"%'  order by cno";
	
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
			Class_control cc = new Class_control();
			cc.setCno(rs.getString(1));
			String cname=rs.getString(2)==null?"":rs.getString(2);
			cc.setCname(cname);
			String speciality=rs.getString(3)==null?"":rs.getString(3);
			cc.setSpeciality(speciality);
			
			String classnum=rs.getString(4)==null?"":rs.getString(4);
			cc.setClassnum(classnum);
			
			cc.setPnum(rs.getString(5));
			
			String mentor=rs.getString(6)==null?"":rs.getString(6);
			cc.setMentor(mentor);
			
			String teacher=rs.getString(7)==null?"":rs.getString(7);
			cc.setTeacher(teacher);
			
			String start_date=rs.getString(8)==null?"":rs.getString(8);
			cc.setStart_date(start_date);
			
			list.add(cc);
			//System.out.println("��ӡ����Ϊ"+list);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	release.releasec(ct,ps,rs);
	
	return list;
}
}
