package com.neuedu.examonline.paper.random.javabean;

import java.sql.*;
import java.util.*;

import javax.naming.*;
import javax.sql.*;

import com.neuedu.examonline.db.BaseBean;

public class suijibean extends BaseBean{
	Connection conn=this.conn;
	DataSource ds = null;
	public Map<String,String> allxueke() {
		Map<String,String> map= new HashMap<String,String>();
		ResultSet rs = null;
		PreparedStatement ps = null;
	try{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		ds = (DataSource) envCtx.lookup("jdbc/oracle");	
		String sql="SELECT * from course";
		conn =ds.getConnection();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
	while(rs.next()){
		 map.put(rs.getString("id"), rs.getString("couse"));
	}
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		try{
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
	}
		return map;
	}
//ͨ�������������ѧ��

	public Map<String,String> alltixing() {
		Map<String,String> map= new HashMap<String,String>();
		ResultSet rs = null;
		PreparedStatement ps = null;
	try{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		ds = (DataSource) envCtx.lookup("jdbc/oracle");	
		String sql="SELECT * from problem_types";
		conn =ds.getConnection();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
	while(rs.next()){
		 map.put(rs.getString("types_id"), rs.getString("types_name"));
	}
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		try{
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
	}
		return map;
	}
	//ͨ�����������������
	
	public  int  zuchengshijuan(String xueke,String tixing)
	{
		int a=-1;
		ResultSet rs = null;
		PreparedStatement ps = null;
	try{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		ds = (DataSource) envCtx.lookup("jdbc/oracle");	
		String sql="SELECT count(*) FROM question  where cid ='"+xueke+"'and type_id ='"+tixing+"'";
		conn =ds.getConnection();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
	if(rs.next()){
		a=rs.getInt("count(*)");
	}
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		try{
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
	}
		return a;
	}
	//ͨ������ѧ�ƺ������������
	
	public  Set<Integer>  zuchengshijuan(int geshu,int count)
	{
		Random r = new Random();
		
		Set<Integer>  set=new HashSet<Integer> ();
		while(true)
		{
			set.add(r.nextInt(count)+1);
			if(set.size()==geshu){break;}
		}
		return set;
	};
			//���һ����Χһ�������������
	
	public  void setshijuanming(String shijuanming)

	{
		ResultSet rs = null;
		PreparedStatement ps = null;
	try{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		ds = (DataSource) envCtx.lookup("jdbc/oracle");	
		String sql="insert into paper(id,name) values (paper_id.nextval,'"+shijuanming+"')";
		conn =ds.getConnection();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		try{
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
	}
		
	}
	//�����Ծ���
	
	public  int getshijuanming(String shijuanming)
	{
		int a=-1;
		ResultSet rs = null;
		PreparedStatement ps = null;
	try{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		ds = (DataSource) envCtx.lookup("jdbc/oracle");	
		String sql="SELECT * from paper where name='"+shijuanming+"' order by id desc";
		conn =ds.getConnection();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
	if(rs.next())
	{
		a=rs.getInt("id");
	}
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		try{
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
	}
		return a;
	}
	//�õ��Ծ���
	
	public  int gettihao(int xuhao,String xueke,String tixing)
	{
		int a=-1;
		ResultSet rs = null;
		PreparedStatement ps = null;
	try{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		ds = (DataSource) envCtx.lookup("jdbc/oracle");	
		String sql = "select question2.*from(select rownum row1 ,question1.* from (SELECT * FROM question  where cid ='"+xueke+"'and type_id ='"+tixing+"')question1)question2 where  row1="+xuhao+" ";
		conn =ds.getConnection();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
	if(rs.next())
	{
		a=rs.getInt("id");
	}
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		try{
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
	}
		return a;
	}
	//ͨ������ѧ�ƺ����ͺ����������
	
	public void  zuchengshijuan(int stid,int sjid,int fen)
	{
		ResultSet rs = null;
		PreparedStatement ps = null;
	try{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		ds = (DataSource) envCtx.lookup("jdbc/oracle");	
		String sql="insert into stsjgl(id,stid,sjid,fen) values (stsjgl_id.nextval,'"+stid+"','"+sjid+"','"+fen+"')";
		conn =ds.getConnection();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		try{
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
	}
		
	}
	//�����Ծ��е�һ������

	public boolean panduanshijuanming(String shijuanming)
	{
		int a=0;
		ResultSet rs = null;
		PreparedStatement ps = null;
	try{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		ds = (DataSource) envCtx.lookup("jdbc/oracle");	
		String sql="SELECT * from paper where name='"+shijuanming+"'";
		conn =ds.getConnection();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
	while(rs.next())
	{
		a++;
	}
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		try{
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}
	}
		if(a==1){return true;}
		return false;
	}
//�ж��Ծ����Ƿ���
	public  String  zhaotypes_name(String tixing)
	{
		String str=null;
		ResultSet rs = null;
		PreparedStatement ps = null;
	try{
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		ds = (DataSource) envCtx.lookup("jdbc/oracle");	
		String sql="SELECT * from problem_types where types_id="+tixing;
		conn =ds.getConnection();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
	while(rs.next())
	{
		str=rs.getString("types_name");
	}
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		try{
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
		catch(SQLException sqle){
			sqle.printStackTrace();
		}}
		return str;
}
//ͨ��idȡ�����͵�����
	public  String  zhaoname(String xueke)
{
	String str=null;
	ResultSet rs = null;
	PreparedStatement ps = null;
try{
	Context initCtx = new InitialContext();
	Context envCtx = (Context) initCtx.lookup("java:comp/env");
	ds = (DataSource) envCtx.lookup("jdbc/oracle");	
	String sql="SELECT * from course where id='"+xueke+"'";
	conn =ds.getConnection();
	ps = conn.prepareStatement(sql);
	rs = ps.executeQuery();
while(rs.next())
{
	str=rs.getString("couse");
}
	
}
catch(Exception e){
	e.printStackTrace();
}
finally{
	try{
		if(rs!=null){
			rs.close();
		}
		if(ps!=null){
			ps.close();
		}
		if(conn!=null){
			conn.close();
		}
	}
	catch(SQLException sqle){
		sqle.printStackTrace();
	}}
	return str;
}
//ͨ��ѧ��idȡ��ѧ����
	public boolean panduanzifu(String str)
	{
		boolean xxx=false;
		if(str.matches("[0-9]{1,}")){xxx=true;}
		if(str.equals("0")){xxx=false;}
		return xxx;
	}
}
