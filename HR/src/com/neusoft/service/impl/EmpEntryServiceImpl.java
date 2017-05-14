package com.neusoft.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.neusoft.bean.EmpEntry;
import com.neusoft.dao.impl.EmpEntryDaoImpl;
import com.neusoft.db.DBManager;
import com.neusoft.service.EmpEntryService;
import com.neusoft.util.Pagination;

public class EmpEntryServiceImpl implements EmpEntryService{
	private DBManager dbManager;
	private EmpEntryDaoImpl empManageDao;
	public EmpEntryServiceImpl() {
		empManageDao=new EmpEntryDaoImpl();
	}
	
	/**
	 * 添加员工信息
	 */
	public boolean addEmpMessage(EmpEntry ee)throws SQLException, ClassNotFoundException{
		boolean isRight=false;
		dbManager = DBManager.getInstance();
		Connection conn=dbManager.getConnection();
		empManageDao.setConnection(conn);
		try {
			isRight=empManageDao.addEmpMessage(ee);
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isRight;
	}
	
	/**
	 * 根据ID查询员工信息
	 */
	public EmpEntry getEmpMessageById(Integer eid)throws SQLException, ClassNotFoundException{
		 dbManager = DBManager.getInstance();
		Connection conn=dbManager.getConnection();
		empManageDao.setConnection(conn);
		EmpEntry ee = empManageDao.getEmpMessageById(eid);
		conn.commit();
		return ee;
	}
	/**
	 * 删除员工信息
	 */
	public boolean deleteEmpMessage(Integer eid)throws SQLException, ClassNotFoundException{
		boolean isRight=false;
		dbManager = DBManager.getInstance();
		Connection conn=dbManager.getConnection();
		empManageDao.setConnection(conn);
		isRight=empManageDao.deleteEmpMessage(eid);
		conn.commit();
		return isRight;
	}
	/**
	 * 修改员工信息
	 */
	public boolean modifyEmpMessage(EmpEntry ee)throws SQLException, ClassNotFoundException{
		dbManager = DBManager.getInstance();
		Connection conn=dbManager.getConnection();
		boolean isRight = false;
		empManageDao.setConnection(conn);
		isRight=empManageDao.modifyEmpMessage(ee);
		conn.commit();
		return isRight;
	}
	/**
	 * 判断输入的员工编号是否存在
	 * @param eid
	 * @return
	 */
	public boolean isCheckExist(Integer eid){
		dbManager = DBManager.getInstance();
		Connection conn = dbManager.getConnection();
		empManageDao.setConnection(conn);
		boolean isRight = false; 
		isRight = empManageDao.isCheckExist(eid);	
		return isRight;
	}
	/**
	 * 显示分页
	 */
	public Pagination getEmployeeByPage(String eid, String ename,
			String deptno, String jobno, int pageSize, int pageNumber)
			throws SQLException, ClassNotFoundException {
		dbManager = DBManager.getInstance();
		Connection conn=dbManager.getConnection();
		empManageDao.setConnection(conn);
		Pagination p=null;
		p=empManageDao.getEmployeeByPage(eid, ename, deptno, jobno, pageSize, pageNumber);
		conn.close();
		return p;	
	}
	
	/**
	 * 员工状态
	 */
	public String getEmpForm(Integer eid) {
		
		dbManager = DBManager.getInstance();
		Connection conn = dbManager.getConnection();
		empManageDao.setConnection(conn);
		
		String empForm = null; 
		
		empForm = empManageDao.getEmpForm(eid);	
		return empForm;
	}

}
