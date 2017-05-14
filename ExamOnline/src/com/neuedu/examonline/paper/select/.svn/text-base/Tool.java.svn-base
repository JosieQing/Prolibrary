package com.neuedu.examonline.paper.select;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.examonline.db.BaseBean;
import com.neuedu.examonline.paper.select.Question;
public class Tool extends BaseBean{
	Connection conn=null;
	Statement st = null;
	ResultSet rs = null;
	int rowtotal=0;
	int pagetotal=0;
	int nowpage=1;
	
	//获得总题数
	public int getrowtotal()
	{
		try{
			String sql="SELECT count(id) from question";
			conn=this.conn();
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next())
			{
				rowtotal=rs.getInt("count(id)");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(st!=null){
					st.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return rowtotal;
	}		
	
	//获得总页数
	public int getpagetotal(int rowtotal,int pagesize)
	{
		if(rowtotal%pagesize==0)
		{
			pagetotal=rowtotal/pagesize;
		}else
		{
			pagetotal=rowtotal/pagesize+1;
		}		
		return pagetotal;
	}
	//获得当前指针
	public int getnowIndex(String str_nowpage,int pagesize)
	{
		if(str_nowpage==null)
		{
			str_nowpage="1";
		}
		nowpage=Integer.parseInt(str_nowpage);
		//获得当前页面的指针
		int nowIndex=(nowpage-1)*pagesize;
		return nowIndex;
	}
	
	
	//用于分页呈现试题页面
	public List<Question> getlist(int pagesize,int rowIndex,String radiovalue,String textvalue)
	{
		List<Question> list=new ArrayList<Question>();
		int i=0;
		try{
			String sql=getSql(radiovalue ,textvalue);			
			//System.out.println(sql);			
			conn=this.conn();
			st=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			//java.sql.SQLException: 对只转发结果集的无效操作: absolute
			rs=st.executeQuery(sql);						
			
			if(rowIndex==0)
			{
				rs.beforeFirst();
			}else
			{
				rs.absolute(rowIndex);
			}	
			while(rs.next())
			{
				if(i>pagesize-1)
				{
					break;
				}				
				String id = rs.getString("id");
				String questiontext= rs.getString("questiontext"); 
				String boss= rs.getString("boss");           
				String types_name= rs.getString("types_name");
				String COUSE = rs.getString("COUSE");
				Question ques=new Question(questiontext, id,types_name,boss, COUSE);				
				list.add(ques);
				i++;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(st!=null){
					st.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}		
		return list;
	}
	//小插件变更sql语句
	public static String getSql(String radiovalue,String textvalue)
	{
		String sql="";		
		if("请输入题号/题型/学科".equals(textvalue)||textvalue==null||radiovalue==null)
		{
			sql="select q.id,q.questiontext,pt.types_name,q.boss,c.COUSE from question q,problem_Types pt,course c  where  pt.types_id=q.type_id and q.cid=c.ID order by id asc";//要改需要多表连接
		}
		else
		{
			switch (Integer.parseInt(radiovalue)) {
			case 1:
				sql="select q.id,q.questiontext,pt.types_name,q.boss,c.COUSE from question q,problem_Types pt,course c  where q.id="+textvalue+" and pt.types_id=q.type_id and q.cid=c.ID order by   id   asc";
				break;
			case 2:
				sql="select q.id,q.questiontext,pt.types_name,q.boss,c.COUSE from question q,problem_Types pt,course c where pt.types_name like '%"+textvalue+"%'and pt.types_id=q.type_id and q.cid=c.ID order by   id   asc";
				break;
			case 3:
				sql="select q.id,q.questiontext,pt.types_name,q.boss,c.COUSE from question q,problem_Types pt,course c where c.COUSE like '%"+textvalue+"%'and pt.types_id=q.type_id and q.cid=c.ID order by   id   asc";
				break;
			default:
				sql="select q.id,q.questiontext,pt.types_name,q.boss,c.COUSE from question q,problem_Types pt,course c where pt.types_id=q.type_id and q.cid=c.ID order by   id   asc";
				break;
			}
		}	
		return sql;
	}
	//写入关联表完成出卷
	public void update(String paper,String fen,String stid)
	{
		Connection conn=null;
		Statement st = null;
		try{
			String sql="INSERT INTO stsjgl(id,stid,sjid,fen)Values(STSIGL_STEP.nextval,'"+stid+"','"+paper+"','"+fen+"')";			
			System.out.println("sql--:"+sql);			
			conn=this.conn();
			st=conn.createStatement();
			st.executeUpdate(sql);			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(st!=null){
					st.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		
	}
	//检索题型
	public String getstr_st(String stid)
	{
		String str_st="";		
		try{
			String sql="SELECT pt.* from question q,problem_Types pt WHERE q.id ="+stid+" AND pt.types_id=q.type_id";			
			//System.out.println("sql--:"+sql);
			
			conn=this.conn();
			st=conn.createStatement();
			rs=st.executeQuery(sql);						
			while(rs.next())
			{
				str_st= rs.getString("types_name");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(st!=null){
					st.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}				
		return str_st;
	}
	//检索题干和选项
	public Question getQuestiontext(String stid,String num)
	{		
		Question question=null;
		String  type_id="";
		try{
			String sql="SELECT * FROM question WHERE id ="+stid+"";			
			//System.out.println("sql--:"+sql);			
			conn=this.conn();
			st=conn.createStatement();
			rs=st.executeQuery(sql);						
			while(rs.next())
			{
				String questiontext= rs.getString("questiontext"); 
				String a= rs.getString("A");           
				String b= rs.getString("B");           
				String c= rs.getString("C");            
				String d= rs.getString("D");          
				String e= rs.getString("E");
				type_id= rs.getString("type_id");
				if("1".equals(type_id))
				{
					question=new Question(num,questiontext,a,b,c,d,e);					
				}

				if("2".equals(type_id))
				{
					question=new Question(num,questiontext);					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(st!=null){
					st.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}	
		return question;
	}
	//将原[]ques让选择在前，并获得选择和简答的个数和新数组要的太多所以没写返回值
	public int[] paixu(String[]ques)
	{
		int[]xuhao=new int[ques.length];
		int k=0;	
		//排序原[]ques让选择在前
		for(int j=0;j<ques.length;j++)
		{
			String obj=getstr_st(ques[j]);
			if("选择".equals(obj))
			{
				xuhao[k]=Integer.parseInt(ques[j]);
				k++;		
			}
		
		}
		for(int h=0;h<ques.length;h++)
		{
			String obj=getstr_st(ques[h]);
			if("简答".equals(obj))
			{
				xuhao[k]=Integer.parseInt(ques[h]);
				k++;				
			}
		}
		return xuhao;
	}
	
	//获得卷纸
	public List<Question> getpaper(int[]xuhao)
	{
		List<Question> paper=new ArrayList<Question>();	
		
		for(int i=1;i<xuhao.length+1;i++)
		{				
			String stid=""+xuhao[i-1];			
			//stid试题题表中的题号，num是卷纸中题的序号	
			Question question=getQuestiontext(stid,""+i);
			paper.add(question);
		}	
		return paper;
	}

	public void makepaper(String id,String name)
	{
		Connection conn=null;
		Statement st = null;
		try{
			String sql="INSERT INTO paper Values('"+id+"','"+name+"')";			
			System.out.println("sql--:"+sql);
			
			conn=this.conn();
			st=conn.createStatement();
			st.executeUpdate(sql);			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(st!=null){
					st.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
	}
	
	public String getpapernum()
	{
		String papernum=null;
		try{
			String sql="SELECT max(id) from paper";
			conn=this.conn();
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next())
			{
				papernum=rs.getString("max(id)");
				System.out.println("papernum--:"+papernum);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(st!=null){
					st.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}
		return papernum;
	}
	
	public String getpapername(String paperselect)
	{
		String papername="";
		try{
			String sql="SELECT name from paper where id="+paperselect+"";
			conn=this.conn();
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			if(rs.next())
			{
				papername=rs.getString("name");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(st!=null){
					st.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException sqle){
				sqle.printStackTrace();
			}
		}		
		return papername;
	}
	
	
	public static void main(String[] args) {
		
//		System.out.println(0%2);
		Tool to=new Tool();
//		String[]ques={"1"};
//		int[]xuhao=to.paixu(ques);
//		int xnum=0;//选择题数
//		for(int i=0;i<xuhao.length;i++)
//		{
//			String obj=to.getstr_st(""+xuhao[i]);
//			if("简答".equals(obj))
//			{
//				xnum=i;
//			}
//		}
//				
//		System.out.print(xnum);	
//		System.out.print(xuhao[0]);	
//		System.out.print(xuhao[1]);
//		String Quest="";
//		String A="";
//		String B="";
//		String C="";
//		String D="";
//		String E="";
//		List<Question>paper=to.getpaper(xuhao);
//		Question Qnumber=paper.get(0);
//		Quest=""+Qnumber.getNum()+"."+Qnumber.getQuestiontext();
//		A=Qnumber.getA();
//		B=Qnumber.getB();
//		C=Qnumber.getC();
//		D=Qnumber.getD();
//		E=Qnumber.getE();
//		System.out.println(Quest);
//		System.out.println(A);
//		System.out.println(B);
//		System.out.println(C);
//		System.out.println(D);
//		System.out.println(E);
		
		System.out.println(to.getpapernum());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
