package com.neusoft.service;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.bean.Job;

public interface JobSerivce {
	/**
	 * ��Ӹ�λ��Ϣ
	 */
	public boolean addJobMessage(Job job)throws SQLException, ClassNotFoundException;
	/**
	 * ��ѯ��λ��Ϣ
	 */
	public List<Job> getJobMessage()throws SQLException, ClassNotFoundException;
	/**
	 * �޸ĸ�λ��Ϣ
	 */
	public boolean modifyJobMessage(Job job)throws SQLException, ClassNotFoundException;
	/**
	 * ɾ����λ��Ϣ
	 */
	public boolean deleteJobMessage(Integer jobno)throws SQLException, ClassNotFoundException;
	/**
	 * ���ݲ���ID��ѯ��λ��Ϣ
	 */
	public List<Job> getJobMessageOfDept(Integer deptno)throws SQLException, ClassNotFoundException;

}
