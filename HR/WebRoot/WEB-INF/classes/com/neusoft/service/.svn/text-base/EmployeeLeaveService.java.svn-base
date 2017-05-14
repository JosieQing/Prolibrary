package com.neusoft.service;

import com.neusoft.util.Pagination;

public interface EmployeeLeaveService {
	/**
	 * 判断离职是否成功
	 * @param eid
	 * @return
	 */
	public boolean getResignById (Integer eid,String todate,String totype,String reason,String operator,String ename);
	
	/**
	 * 根据分页得到员工离职记录
	 */
	public Pagination getResignByPage(String eid,String ename,String todate,String totype,int pageSize,int pageNumber);
}
