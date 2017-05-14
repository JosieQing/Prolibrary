package com.neuedu.examonline.base.classsys;
import java.sql.*;
import java.util.*;
import com.neuedu.examonline.base.classsys.*;
import com.neuedu.examonline.db.*;


public class add extends BaseBean
{
	private  static Connection ct = null;
	private  static PreparedStatement ps = null;
	private  ResultSet rs = null;
	private static ConnectionFactory cf = new ConnectionFactory();
	public static  int addc(Class_control cc)
	{
	
		 String sql ="insert into Class_sys values(class_cno.nextval,'"+cc.getCname()+"','"+cc.getSpeciality()
	        		+"','"+cc.getClassnum()+"','"+cc.getPnum()+"','"+cc.getMentor()+"','"+cc.getTeacher()+"',sysdate)";
	        		
	        System.out.println("sql--"+sql);//����
	       int i=0;
	        try
	        {
	        	ct = cf.get();
	            ps = ct.prepareStatement(sql);
	           i=ps.executeUpdate();
	        } catch (Exception e)
	        {
	            e.printStackTrace();
	        } 
	        release.releasec(ct,ps,null);
	      
	        return i;
}
}
