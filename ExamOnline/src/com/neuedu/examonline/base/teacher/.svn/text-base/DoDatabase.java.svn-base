package com.neuedu.examonline.base.teacher;
import com.neuedu.examonline.db.*;

import java.sql.*;
import java.util.*;
import com.neuedu.examonline.util.*;
import java.util.Date;


public class DoDatabase {

	@SuppressWarnings("static-access")
	private static Connection ct = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static ConnectionFactory cf = new ConnectionFactory();
	
	public static List<Teacher> sel(String name)
	{
		List<Teacher> list = new ArrayList<Teacher>();
		
		String sql="select * from teachers where tname like '%"+name+"%'  ";
		
		System.out.println("查询的sql--"+sql);//测试
	
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
				Teacher ter = new Teacher();
				ter.setTno(rs.getString(1));
				ter.setTname(rs.getString(2));
				ter.setTsex(rs.getString(3));
				
				String tage=rs.getString(4)==null?"":rs.getString(4);
				ter.setTage(tage);
				
				String ttel=rs.getString(5)==null?"":rs.getString(5);
				ter.setTtel(ttel);
				
				
				Date dateStr = DateUtil.string2Date(rs.getString(6), DateUtil.Y_M_D);
				String hiredate = DateUtil.format(dateStr, DateUtil.Y_M_D);
				ter.setHiredate(hiredate);
				
				String ttremark=rs.getString(7)==null?"":rs.getString(7);
				ter.setTremark(ttremark);
				list.add(ter);
				//System.out.println("打印集合为"+list);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		release(ct,ps,rs);
		
		return list;
		
	}

	public static int ins(Teacher ter)
	{
		
	        String sql ="insert into teachers values(teacher_tno.nextval,'"+ter.getTname()+"','"+ter.getTsex()
	        		+"','"+ter.getTage()+"','"+ter.getTtel()+"',to_date('"+ter.getHiredate()+"','yyyy-mm-dd'),'"+ter.getTremark()+"')";
	        		
	        System.out.println("增加的sql--"+sql);//测试
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
	        release(ct,ps,null);
	      
	        return i;
	}
	
	
	public static int upd(Teacher ter)
	{
	
	        String sql ="update teachers set tname='"+ter.getTname()+"',tsex='"+ter.getTsex()
	        		+"',tage='"+ter.getTage()+"',ttel='"+ter.getTtel()+"',hiredate=to_date('"+ter.getHiredate()+"','yyyy-mm-dd'),tremark='"+ter.getTremark()+
	        		"' where tno ='"+ter.getTno()+"'";
	        		
	        System.out.println("修改的sql--"+sql);//测试
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
	        release(ct,ps,null);
	      
	        return i;
	}
	
	public static int del(String tno)
	{
	
	        String sql ="delete teachers where tno='"+tno+"'";
	        		
	        System.out.println("sql--"+sql);//测试
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
	        release(ct,ps,null);
	      
	        return i;
	}
	
	
	
	
	
	
	public static void release(Connection ct, PreparedStatement ps, ResultSet rs)
    {

        if (ct != null)
        {
            if (ps != null)
            {
                if (rs != null)
                {
                    try
                    {
                        rs.close();
                    } catch (SQLException e)
                    {
                        e.printStackTrace();
                    }
                }
                try
                {
                    ps.close();
                } catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
            try
            {
                ct.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

    }
}
