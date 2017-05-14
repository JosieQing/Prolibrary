package com.neusoft.dao;

import java.sql.SQLException;
import com.neusoft.bean.Department;


import java.util.List;
public interface DepartmentDao {
	/**
	 * 添加部门信息
	 */
	public boolean addDeptMessage(Department dept)throws SQLException, ClassNotFoundException;
	/**
	 * 查询部门信息
	 */
	public List<Department> getDeptMessage(String deptno)throws SQLException, ClassNotFoundException;
	/**
	 * 修改部门信息
	 */
	public boolean modifyDeptMessage(Department dept)throws SQLException, ClassNotFoundException;
	/**
	 * 删除部门信息
	 */
	public boolean deleteDeptMessage(Integer deptno)throws SQLException, ClassNotFoundException;
	/**
	 * 根据部门ID获取部门信息
	 */
	public Department getDeptMessageById(Integer deptno)throws SQLException, ClassNotFoundException;
	/**
	 * 获取所有dname
	 * @return
	 */
	public String[] getDname();

}
