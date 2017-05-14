package com.neusoft.dao;
import java.sql.SQLException;
import java.util.List;

import com.neusoft.bean.EmpEntry;
import com.neusoft.util.Pagination;
public interface EmpManageDao {
	/**
	 * 添加员工信息
	 */
	public boolean addEmpMessage(EmpEntry ee)throws SQLException, ClassNotFoundException;
	/**
	 * 查询员工信息
	 */
	public List<EmpEntry> getEmpMessage()throws SQLException, ClassNotFoundException;
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
	 * 根据部门id检索该部门员工信息
	 */
	public List<EmpEntry> checkEmpOfDept(Integer deptno)throws SQLException, ClassNotFoundException;
	/**
	 * 根据岗位id检索该岗位员工信息
	 */
	public List<EmpEntry> checkEmpOfJob(Integer jobno)throws SQLException, ClassNotFoundException;
	
	/**
	 * 判断输入的员工编号是否存在
	 * @param eid
	 * @return
	 */
	public boolean isCheckExist(Integer eid);

	/**
	 * 显示分页
	 */
	public Pagination getEmpMessageByPage(int pageSize,int pageNumber)throws SQLException, ClassNotFoundException;

}
