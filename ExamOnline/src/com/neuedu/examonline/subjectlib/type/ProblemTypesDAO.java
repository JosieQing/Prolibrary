package com.neuedu.examonline.subjectlib.type;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.examonline.db.BaseBean;
import com.neuedu.examonline.db.ConnC3p0DS;


public class ProblemTypesDAO extends BaseBean{
	Connection conn=this.conn();
	Statement stmt=null;
	ResultSet rs=null;
	
	public ProblemTypesDAO(){
		
	}
	
	//添加题型
	public boolean addTypes(String types_name) throws SQLException{
		String sql="insert into problem_Types values(PROBLEM_TYPES_SEQ.nextval,'"+types_name+"')";
		stmt=conn.createStatement();
		int i=stmt.executeUpdate(sql);
		if(i==1){
			return true;
		}else{
			return false;
		}
	}
	
	//查询所有题型信息
	public List getTypesAll() throws SQLException{
		String sql="select * from problem_Types ";
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
		
		List<ProblemTypesBean> list=new ArrayList<ProblemTypesBean>();
		while(rs.next()){
			ProblemTypesBean bean=new ProblemTypesBean();
			bean.setTypes_id(rs.getString("types_id"));
			bean.setTypes_name(rs.getString("types_name"));
			list.add(bean);		
		}
		
		return list;	
	}
	
	//通过ID查询题型信息
	public ProblemTypesBean  getTypesById(String types_updateId) throws SQLException{
		ProblemTypesBean bean=new ProblemTypesBean();
		String sql="select * from problem_Types where types_id="+types_updateId;
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
		if(rs.next()){
			bean.setTypes_id(rs.getString("types_id"));
			bean.setTypes_name(rs.getString("types_name"));
		}
		return bean;
	}
	
	//修改题型信息
	public int updateProblemTypes(ProblemTypesBean ProblemTypes) throws SQLException{
		int i=0;
		String sql="update problem_Types set types_name='"+ProblemTypes.getTypes_name()+"' where types_id="+ProblemTypes.getTypes_id();	
		stmt = conn.createStatement();
		i=stmt.executeUpdate(sql);

		return i;
	}
	public int deleteProblemTypes(String delete_id) throws SQLException{
		String sql="delete problem_Types where types_id="+delete_id;
		stmt=conn.createStatement();
		int i=stmt.executeUpdate(sql);
		return i;
	}
}
