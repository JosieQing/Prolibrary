package com.neusoft.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import com.neusoft.bean.TransferMan;
import com.neusoft.dao.impl.TransferManDaoImpl;
import com.neusoft.db.DBManager;
import com.neusoft.service.TransferManService;
import com.neusoft.util.Pagination;

public class TransferManServiceImpl implements TransferManService{
	
	private TransferManDaoImpl transferManDao;
	private DBManager dbManager;
	
	
	public TransferManServiceImpl(){
		
		transferManDao = new TransferManDaoImpl();
		dbManager = DBManager.getInstance();
	}

	/**
	 * 增加调动信息
	 * @throws SQLException 
	 */
	public boolean addTransferInfo(TransferMan tm) throws SQLException {
		
		boolean isRight = false;
		Connection conn = dbManager.getConnection();
		transferManDao.setConnection(conn);
		
		try {
			isRight = transferManDao.addTransferInfo(tm);
			conn.commit();//提交
		} catch (SQLException e) {
			conn.rollback();//回滚
			e.printStackTrace();
		}
		return isRight;
	}

	
	/**
	 * 根据EID查询员工调动信息
	 * @param eid
	 * @return
	 */
	public TransferMan getTransferInfoByEid(int eid) {
		
		Connection conn = dbManager.getConnection();
		transferManDao.setConnection(conn);
		//执行SQL语句
		TransferMan tm = null;
		tm = transferManDao.getTransferInfoByEid(eid);
		
		return tm;
	}
	
	/**
	 * 查询所有调动信息
	 */
	public List<TransferMan> getAllTransferInfo() {
		
		Connection conn = dbManager.getConnection();
		transferManDao.setConnection(conn);
		
		List<TransferMan> list = transferManDao.getAllTransferInfo();
		return list;
	}

	

	/**
	 * 分页---pageSize：每页记录条数；pageNumber：当前选择页
	 */
	public Pagination getTransferManByPage(int pageSize, int pageNumber) {
		
		Connection conn = dbManager.getConnection();
		transferManDao.setConnection(conn);
		Pagination p = null;
		
		p = transferManDao.getTransferInfoByPage(pageSize, pageNumber);
	
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	/**
	 * 分页--条件
	 */
	public Pagination getTransferInfoByPage(String eid,String state,String startDay,String endDay,int pageSize, int pageNumber){
		
		Connection conn = dbManager.getConnection();
		transferManDao.setConnection(conn);
		Pagination p = null;
		
		p = transferManDao.getTransferInfoByPage(eid,state,startDay,endDay,pageSize, pageNumber);
	
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
}
