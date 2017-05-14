package com.neusoft.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neusoft.bean.Department;
import com.neusoft.bean.Job;
import com.neusoft.dao.impl.AjaxDaoImpl;
import com.neusoft.db.DBManager;
import com.neusoft.service.AjaxService;

public class AjaxServiceImpl implements AjaxService{
	
	private AjaxDaoImpl AjaxDao;
	private DBManager dbManager;
	
	//面向接口编程
	//控制反转（IOC）：以前需要自己做的事，现在交给调用者来完成。
	public AjaxServiceImpl(){
		AjaxDao = new AjaxDaoImpl();
		dbManager = DBManager.getInstance();
	}
	
	/**
	 * 根据EID得到DNAME
	 * @param eid
	 * @return
	 */
	public String getDnameByEid(Integer eid) {
		
		
		//连接数据库
		Connection conn = dbManager.getConnection();
		AjaxDao.setConnection(conn);
		//执行SQL语句
		String dName = null;
		dName = AjaxDao.getDnameByEid(eid);
		
		return dName;
	}
	
	/**
	 * 根据EID得到ENAME
	 * @param eid
	 * @return
	 */
	public String getEnameByEid(Integer eid) {
		
		//连接数据库
		Connection conn = dbManager.getConnection();
		AjaxDao.setConnection(conn);
		//执行SQL语句
		String eName = null;
		eName = AjaxDao.getEnameByEid(eid);
		
		return eName;
	}
	
	
	/**
	 * 根据JOBNO得到DNAME
	 * @param eid
	 * @return
	 */
	public String getDnameByJobNo(String jobNo) {
		
		//连接数据库
		Connection conn = dbManager.getConnection();
		AjaxDao.setConnection(conn);
		//执行SQL语句
		String dName = null;
		dName = AjaxDao.getDnameByJobNo(jobNo);
		
		return dName;
	}
	
	
	
	/**
	 * 根据DNAME得到JNAME
	 * @param Dname
	 * @return
	 */
	public String getJnameByDname(String Dname){
		//连接数据库
		Connection conn = dbManager.getConnection();
		AjaxDao.setConnection(conn);
		//执行SQL语句
		String Jname = null;
		Jname = AjaxDao.getJnameByDname(Dname);
		
		return Jname;
	}
	
	
	/**
	 * 根据EID得到JNAME
	 * @param eid
	 * @return
	 */
	public String getJnameByEid(Integer eid) {
		
		//连接数据库
		Connection conn = dbManager.getConnection();
		AjaxDao.setConnection(conn);
		//执行SQL语句
		String jName = null;
		jName = AjaxDao.getJnameByEid(eid);
		
		return jName;
	}
	
	
	/**
	 * 根据EID得到PMID
	 * @param eid
	 * @return
	 */
	public Integer getPmIdByEid(Integer eid){
		
		//连接数据库
		Connection conn = dbManager.getConnection();
		AjaxDao.setConnection(conn);
		//执行SQL语句
		Integer pmId = null;
		
		pmId = AjaxDao.getPmIdByEid(eid);
			
		return pmId;
	}
	/**
	 * 根据dname得到jname
	 * @param eid
	 * @return
	 */
	public List<Job> getJobMessageById(String dname) {
		DBManager dbManager = DBManager.getInstance();
		Connection conn=dbManager.getConnection();
		AjaxDao.setConnection(conn);
		List<Job> list=null;
		
			try {
				list=AjaxDao.getJobMessage(dname);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		
		return list;
	}

	
	/**
	 * 获取所有部门信息
	 * @return
	 */
	public List<Department> getDeptMessage(){
		
		DBManager dbManager = DBManager.getInstance();
		Connection conn=dbManager.getConnection();
		AjaxDao.setConnection(conn);
		List<Department> l = null;
		try {
			l = AjaxDao.getDeptMessage();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return l;
	}
	
	/**
	 * 根据jobno得到jname
	 */
	public String getJobNameByJobno(Integer jobno) throws SQLException,
			ClassNotFoundException {
		DBManager dbManager = DBManager.getInstance();
		Connection conn=dbManager.getConnection();
		AjaxDao.setConnection(conn);
		String jname = null;
		jname = AjaxDao.getJobNameByJobno(jobno);
		return jname;
	}
	
	/**
	 * 根据deptno得到dname
	 */
	public String getDnameByDeptno(String deptno) throws SQLException,
			ClassNotFoundException {
		DBManager dbManager = DBManager.getInstance();
		Connection conn=dbManager.getConnection();
		AjaxDao.setConnection(conn);
		String dname = null;
		dname = AjaxDao.getDnameByDeptno(deptno);
		return dname;
	}
	
	/**
	 * 根据deptno得到上级部门名称
	 */
	public String getSuperDnameByDeptno(String deptno) throws SQLException,
			ClassNotFoundException {
		DBManager dbManager = DBManager.getInstance();
		Connection conn=dbManager.getConnection();
		AjaxDao.setConnection(conn);
		String superName = null;
		superName = AjaxDao.getSuperDnameByDeptno(deptno);
		return superName;
	}	
}
