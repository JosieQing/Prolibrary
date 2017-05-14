package com.neusoft.service.impl;
import java.sql.Connection;
import java.sql.SQLException;
import com.neusoft.dao.impl.formDaoImpl;
import com.neusoft.service.formService;
import com.neusoft.util.Pagination;
import com.neusoft.db.DBManager;
public class formServiceImpl implements formService{
	private formDaoImpl formdaoimpl;
	private DBManager db;
	
	public formServiceImpl(){
		formdaoimpl=new formDaoImpl();
		db=DBManager.getInstance();
	}
	/**
	 * 获取新聘员工所有信息报表
	 */
	public Pagination getFormNewEmployee(String dname,String workDay,String formalDay,int pageSize,int pageNumber){
		Connection conn=db.getConnection();
		formdaoimpl.setConnection(conn);
		Pagination page=formdaoimpl.getFormNewEmployee(dname, workDay, formalDay, pageSize, pageNumber);
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
	}
	/**
	 * 获取部门调动报表
	 */
	public Pagination getFormMoveDept(String startdate,String endDate,int pageSize,int pageNumber){
		Connection conn=db.getConnection();
		formdaoimpl.setConnection(conn);
		Pagination page=formdaoimpl.getFormMoveDept(startdate, endDate, pageSize, pageNumber);
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
	}
	/**
	 * 获取岗位调动报表
	 */
	public Pagination getFormMoveEemployee(String startdate,String endDate,int pageSize,int pageNumber){
		Connection conn=db.getConnection();
		formdaoimpl.setConnection(conn);
		Pagination page=formdaoimpl.getFormMoveEemployee(startdate, endDate, pageSize, pageNumber);
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
		return page;
	}

	/**
	 * 获取离职调动报表
	 */
	public Pagination getFormResignMessage(String dname,String date,String endDate,int pageSize,int pageNumber){
		Connection conn=db.getConnection();
		formdaoimpl.setConnection(conn);
		Pagination page=formdaoimpl.getFormResignMessage(dname, date, endDate, pageSize, pageNumber);
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return page;
	}
	public static void main(String[] args) {
		formServiceImpl fsi= new formServiceImpl();
		Pagination a =fsi.getFormNewEmployee("0", "2016-7-10", "2016-8-11",1,1);
		System.out.println(a.getPageSize());
	}
	
}
