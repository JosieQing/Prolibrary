package com.neusoft.dao;

import java.util.List;
import com.neusoft.bean.TransferMan;
import com.neusoft.util.Pagination;

public interface TransferManDao {

	/**
	 * 增加调动信息
	 */
	public boolean addTransferInfo(TransferMan tm);

	/**
	 * 根据EID查询员工调动信息
	 * 
	 * @param eid
	 * @return
	 */
	public TransferMan getTransferInfoByEid(int eid);

	/**
	 * 查询所有调动信息
	 * 
	 * @return
	 */
	public List<TransferMan> getAllTransferInfo();

	// /**
	// * 根据模糊username查询有关信息
	// * @return
	// */
	// public List<TransferMan> getAllConnecteMessage(String str);

	/**
	 * 分页
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 */
	public Pagination getTransferInfoByPage(int pageSize, int pageNumber);
	
	/**
	 * 分页--条件
	 */
	public Pagination getTransferInfoByPage(String eid,String state,String startDay,String endDay,int pageSize, int pageNumber); 
}
