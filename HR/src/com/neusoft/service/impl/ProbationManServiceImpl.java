package com.neusoft.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neusoft.bean.EmpEntry;
import com.neusoft.bean.ProbationMan;
import com.neusoft.dao.BaseDao;
import com.neusoft.dao.EmpEntryDao;
import com.neusoft.dao.impl.EmpManageDaoImpl;
import com.neusoft.dao.impl.ProbationManDaoImpl;
import com.neusoft.db.DBManager;
import com.neusoft.service.ProbationManService;
import com.neusoft.util.Pagination;

public class ProbationManServiceImpl implements ProbationManService{
	
	private ProbationManDaoImpl probationManDao;
	private DBManager dbManager;
	
	
	public ProbationManServiceImpl(){
		probationManDao = new ProbationManDaoImpl();
		dbManager = DBManager.getInstance();
	}
	
	
	/**
	 * 试用期信息简单录入
	 */
	public boolean addProbationInfo(ProbationMan pm) throws SQLException {
		
		boolean isRight = false;
		Connection conn = dbManager.getConnection();
		probationManDao.setConnection(conn);

		try {
			isRight = probationManDao.addProbationInfo(pm);
			conn.commit();//提交
		} catch (SQLException e) {
			conn.rollback();//回滚
			e.printStackTrace();
		}
		return isRight;
	}
	
	/**
	 * 试用期信息管理
	 * @param pm
	 * @param eid
	 * @return
	 */
	public boolean probationManInfo(ProbationMan pm,Integer eid) {
		
		boolean isRight = false;
		
		Connection conn = dbManager.getConnection();
		probationManDao.setConnection(conn);
		
		isRight = probationManDao.probationManInfo(pm, eid);
		try {
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return isRight;
	}
	
	
	
	/**
	 * 通过员工编号查询试用信息
	 */
	
	public ProbationMan getProbationInfoByEid(Integer eid) {
		
		//连接数据库
		Connection conn = dbManager.getConnection();
		probationManDao.setConnection(conn);
		//执行SQL语句
		ProbationMan pm = null;
		pm = probationManDao.getProbationInfoByEid(eid);
		
		return pm;
		
	}
	
//	/**
//	 * 通过员工试用状态查询信息
//	 * @return
//	 */
//	public List<ProbationMan> getAllProbationInfoByState(String state) {
//		
//		Connection conn = dbManager.getConnection();
//		probationManDao.setConnection(conn);
//		
//		List<ProbationMan> list = probationManDao.getAllProbationInfoByState(state);
//		return list;
//	}
//	
//	
//	/**
//	 * 查询所有试用信息
//	 */
//	public List<ProbationMan> getAllProbationInfo() {
//		
//		Connection conn = dbManager.getConnection();
//		probationManDao.setConnection(conn);
//		
//		List<ProbationMan> list = probationManDao.getAllProbationInfo();
//		return list;
//	}
//	
//	
//	/**
//	 * 根据模糊的eid查询有关信息
//	 * @param eid
//	 * @return
//	 */
//	public List<ProbationMan> getAllConnecteMessage(String eid){
//		
//		Connection conn = dbManager.getConnection();
//		probationManDao.setConnection(conn);
//		
//		List<ProbationMan> list = probationManDao.getAllConnecteMessage(eid);
//		return list;
//	}
//	
//	/**
//	 * 分页ByEid
//	 * @param pageSize
//	 * @param pageNumber
//	 * @return
//	 */
//	public Pagination getProbationManByPageByEid(String eid,int pageSize, int pageNumber) {
//		
//		Connection conn = dbManager.getConnection();
//		probationManDao.setConnection(conn);
//		Pagination p = null;
//		
//		p = probationManDao.getProbationManByPageByEid(eid,pageSize, pageNumber);
//		
//		try {
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return p;
//	}
//	
//	
	
//	/**
//	 * 分页ByState
//	 * @param pageSize
//	 * @param pageNumber
//	 * @return
//	 */
//	public Pagination getProbationManByPageByState(String state,int pageSize, int pageNumber) {
//		
//		Connection conn = dbManager.getConnection();
//		probationManDao.setConnection(conn);
//		Pagination p = null;
//		
//		p = probationManDao.getProbationManByPageByState(state,pageSize, pageNumber);
//		
//		try {
//			conn.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return p;
//	}

	/**
	 * 分页---pageSize：每页记录条数；pageNumber：当前选择页
	 * 根据eid模糊查询和试用状态查询
	 */
	public Pagination getProbationManByPage(String eid, String state,
			int pageSize, int pageNumber){
		
		Connection conn = dbManager.getConnection();
		probationManDao.setConnection(conn);
		Pagination p = null;
		
		p = probationManDao.getProbationManByPage(eid,state,pageSize, pageNumber);
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}

	public EmpEntry getEmpMessageById(Integer eid) {

		dbManager = DBManager.getInstance();
		Connection conn=dbManager.getConnection();
		probationManDao.setConnection(conn);
		EmpEntry ee = null;
		try {
			ee = probationManDao.getEmpMessageById(eid);
			if(ee != null){
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ee;
	}
	
}
