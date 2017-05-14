package com.neusoft.service;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.bean.TransferMan;
import com.neusoft.util.Pagination;

public interface TransferManService {
	
	
	/**
	 * 增加调动信息
	 */
	public boolean addTransferInfo(TransferMan tm) throws SQLException;
	
	
	/**
	 * 根据EID查询员工调动信息
	 * @param eid
	 * @return
	 */
	public TransferMan getTransferInfoByEid(int eid);
	
	/**
	 * 查询所有调动信息
	 */
	public List<TransferMan> getAllTransferInfo();
	

	
	/**
	 * 分页---pageSize：每页记录条数；pageNumber：当前选择页
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 */
	public Pagination getTransferManByPage(int pageSize,int pageNumber);
	
	/**
	 * 分页--条件
	 * @param eid
	 * @param state
	 * @param startDay
	 * @param endDay
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 */
	public Pagination getTransferInfoByPage(String eid,String state,String startDay,String endDay,int pageSize, int pageNumber);
	
	//**
	// * 根据模糊username查询有关信息
	// * @return
	// */
	//public List<TransferMan> getAllConnecteMessage(String str);
	
	
}
