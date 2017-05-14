package com.neusoft.service;

import java.sql.SQLException;


import com.neusoft.bean.EmpEntry;
import com.neusoft.util.Pagination;


public interface EmpEntryService {
	
	/**
	 * 添加员工信息
	 */
	public boolean addEmpMessage(EmpEntry ee)throws SQLException, ClassNotFoundException;
	/**
	 * 根据ID查询员工信息
	 */
	public EmpEntry getEmpMessageById(Integer eid)throws SQLException, ClassNotFoundException;
	/**
	 * 删除员工信息
	 */
	public boolean deleteEmpMessage(Integer eid)throws SQLException, ClassNotFoundException;
	/**
	 * 修改员工信息
	 */
	public boolean modifyEmpMessage(EmpEntry ee)throws SQLException, ClassNotFoundException;
	/**
	 * 判断输入的员工编号是否存在
	 * @param eid
	 * @return
	 */
	public boolean isCheckExist(Integer eid);

	/**
	 * 显示分页
	 */
	public Pagination getEmployeeByPage(String eid,String ename,String deptno,String jobno,int pageSize, int pageNumber) throws SQLException, ClassNotFoundException;
	
	/**
	 * 员工状态
	 */
	public String getEmpForm(Integer eid);
}
