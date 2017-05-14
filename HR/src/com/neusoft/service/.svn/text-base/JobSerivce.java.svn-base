package com.neusoft.service;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.bean.Job;

public interface JobSerivce {
	/**
	 * 添加岗位信息
	 */
	public boolean addJobMessage(Job job)throws SQLException, ClassNotFoundException;
	/**
	 * 查询岗位信息
	 */
	public List<Job> getJobMessage()throws SQLException, ClassNotFoundException;
	/**
	 * 修改岗位信息
	 */
	public boolean modifyJobMessage(Job job)throws SQLException, ClassNotFoundException;
	/**
	 * 删除岗位信息
	 */
	public boolean deleteJobMessage(Integer jobno)throws SQLException, ClassNotFoundException;
	/**
	 * 根据部门ID查询岗位信息
	 */
	public List<Job> getJobMessageOfDept(Integer deptno)throws SQLException, ClassNotFoundException;

}
