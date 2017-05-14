package com.neusoft.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.neusoft.dao.impl.AdminDaoImpl;
import com.neusoft.dao.impl.EmployeeLeaveDaoImpl;
import com.neusoft.db.DBManager;
import com.neusoft.service.EmployeeLeaveService;
import com.neusoft.util.Pagination;

public class EmployeeLeaveServiceImpl implements EmployeeLeaveService{

	private DBManager dbManager;
	private EmployeeLeaveDaoImpl  empleaveDao;
	
	public EmployeeLeaveServiceImpl(){
		empleaveDao = new EmployeeLeaveDaoImpl();
		dbManager = DBManager.getInstance();
	}
	
	/**
	 * 判断离职是否成功
	 * @param eid
	 * @return
	 */
	public boolean getResignById(Integer eid, String todate, String totype,
			String reason, String operator, String ename) {
		Connection conn=dbManager.getConnection();
		empleaveDao.setConnection(conn);
		boolean isright=false;
		try {
			isright=empleaveDao.getResignById(eid, todate, totype, reason, operator, ename);
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isright;
	}
	

	/**
	 * 根据分页得到员工离职记录
	 */
	public Pagination getResignByPage(String eid, String ename, String todate,
			String totype, int pageSize, int pageNumber) {
		Connection conn=dbManager.getConnection();
		empleaveDao.setConnection(conn);
		Pagination page=null;
		try {
			page=empleaveDao.getResignByPage(eid, ename, totype, todate, pageSize, pageNumber);
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
	}
		
	
	

	

	
	
	
	
	
	
	
	
}
