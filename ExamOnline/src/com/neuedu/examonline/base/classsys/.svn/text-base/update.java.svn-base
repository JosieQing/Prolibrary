package com.neuedu.examonline.base.classsys;
import java.sql.*;
import java.util.*;
import com.neuedu.examonline.base.classsys.*;
import com.neuedu.examonline.db.*;


public class update {

	private static Connection ct = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static ConnectionFactory cf = new ConnectionFactory();
	public static int updatec(Class_control cc)
	{
	
	        String sql ="update class_sys set cname='"+cc.getCname()+"',speciality='"+cc.getSpeciality()
	        		+"',classnum='"+cc.getClassnum()+"',pnum='"+cc.getPnum()+"',mentor='"+cc.getMentor()+
	        		"' ,teacher='"+cc.getTeacher()+"',start_date=sysdate  where cno ='"+cc.getCno()+"'";
	        		
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
