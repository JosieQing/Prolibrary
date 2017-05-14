package com.neusoft.dao;


import com.neusoft.util.Pagination;


public interface formDao {
	/**
	 * 获取新聘员工所有信息报表
	 */
	public Pagination getFormNewEmployee(String dname,String workDay,String formalDay,int pageSize, int pageNumber);
	/**
	 * 获取部门调动报表
	 */
	public Pagination getFormMoveDept(String startdate,String endDate,int pageSize, int pageNumber);
	/**
	 * 获取岗位调动报表
	 */
	public Pagination getFormMoveEemployee(String startdate,String endDate,int pageSize, int pageNumber);
	/**
	 * 获取离职调动报表
	 */
	public Pagination getFormResignMessage(String dname,String date,String endDate,int pageSize, int pageNumber);
}