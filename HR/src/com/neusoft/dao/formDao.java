package com.neusoft.dao;


import com.neusoft.util.Pagination;


public interface formDao {
	/**
	 * ��ȡ��ƸԱ��������Ϣ����
	 */
	public Pagination getFormNewEmployee(String dname,String workDay,String formalDay,int pageSize, int pageNumber);
	/**
	 * ��ȡ���ŵ�������
	 */
	public Pagination getFormMoveDept(String startdate,String endDate,int pageSize, int pageNumber);
	/**
	 * ��ȡ��λ��������
	 */
	public Pagination getFormMoveEemployee(String startdate,String endDate,int pageSize, int pageNumber);
	/**
	 * ��ȡ��ְ��������
	 */
	public Pagination getFormResignMessage(String dname,String date,String endDate,int pageSize, int pageNumber);
}