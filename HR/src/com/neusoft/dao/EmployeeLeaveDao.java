package com.neusoft.dao;


import com.neusoft.util.Pagination;



public interface EmployeeLeaveDao {
	/**
	 * ��ְ����
	 * @param eid
	 * @return
	 */
	public boolean getResignById (Integer eid,String todate,String totype,String reason,String operator,String ename);
	
	/**
	 * ���ݷ�ҳ�õ�Ա����ְ��¼
	 */
	public Pagination getResignByPage(String eid,String ename,String todate,String totype,int pageSize,int pageNumber);
}
