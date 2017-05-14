package com.neusoft.service;

import java.sql.SQLException;

import java.util.List;

import com.neusoft.bean.Department;
import com.neusoft.bean.Job;


public interface AjaxService {
	
	
	/**
	 * 根据EID得到ENAME
	 * @param eid
	 * @return
	 */
	public String getEnameByEid(Integer eid);
	
	
	
	/**
	 * 根据EID得到JNAME
	 * @param eid
	 * @return
	 */
	public String getJnameByEid(Integer eid);
	
	/**
	 * 根据EID得到DNAME
	 * @param eid
	 * @return
	 */
	public String getDnameByEid(Integer eid);
	
	/**
	 * 根据EID得到PMID
	 * @param eid
	 * @return
	 */
	public Integer getPmIdByEid(Integer eid);
	
	/**
	 * 根据JOBNO得到DNAME
	 * @param eid
	 * @return
	 */
	public String getDnameByJobNo(String jobNo);
	
	
	/**
	 * 根据DNAME得到JNAME
	 * @param Dname
	 * @return
	 */
	public String getJnameByDname(String Dname);
	
	
	/**
	 * 根据deptno得到job
	 * @param eid
	 * @return
	 */
	public List<Job> getJobMessageById(String dname)throws SQLException, ClassNotFoundException;
	
	/**
	 * 获取所有部门信息
	 * @return
	 */
	public List<Department> getDeptMessage();
	/**
	 * 根据岗位编号获取岗位名称
	 */
	public String getJobNameByJobno(Integer jobno)throws SQLException, ClassNotFoundException;
	/**
	 * 根据部门编号获取部门名称
	 */
	public String getDnameByDeptno(String deptno)throws SQLException, ClassNotFoundException;
	/**
	 * 根据部门编号获取部门上级部门
	 */
	public String getSuperDnameByDeptno(String deptno)throws SQLException, ClassNotFoundException;
	
		
		
}
