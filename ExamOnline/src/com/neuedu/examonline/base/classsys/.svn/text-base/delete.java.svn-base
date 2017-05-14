package com.neuedu.examonline.base.classsys;
import java.sql.*;
import java.util.*;
import com.neuedu.examonline.base.classsys.*;
import com.neuedu.examonline.db.*;


public class delete {

	private static Connection ct = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static ConnectionFactory cf = new ConnectionFactory();
	
	public static int del(String cno)
	{
	
	        String sql ="delete class_sys where cno='"+cno+"'";
	        		
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
