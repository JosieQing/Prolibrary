package com.neusoft.dao.impl;


import com.neusoft.dao.BaseDao;
import com.neusoft.dao.EmployeeLeaveDao;

import com.neusoft.util.OraclePagination;
import com.neusoft.util.Pagination;

public class EmployeeLeaveDaoImpl extends BaseDao implements EmployeeLeaveDao{
	
	
	/**
	 * �ж���ְ�Ƿ�ɹ�
	 * 	����ӱ���
	 * @param eid
	 * @return
	 */
	public boolean getResignById(Integer eid, String todate, String totype,
			String reason, String operator, String ename) {
		//����״̬������ְ
		//�޸�Ա�����Ϊ��ְ״̬
		//lid(NB_LID.nextval)+eid(Servletת����)
		//+toDate+totype+reason+operator+employee.ename
		String sql="update employee set state=2 where eid=?";
		int i=jdbcTemplate.update(sql, eid);
		//��ӵ���ְ����
		//update�޸�/insert into��� ����jdbcTemplate.update();
		String sqll="insert into turnover(lid,eid,todate,totype,reason,operator,ename)" +
				"values(NB_LID.nextval,?,to_date(?,'yyyy-mm-dd'),?,?,?,?)";
		int ii=jdbcTemplate.update(sqll,eid,todate,totype,reason,operator,ename);
		return i==1&&ii==1;
		
	}
	 

	/**
	 * ���ݷ�ҳ�õ�Ա����ְ��¼
	 */
	public Pagination getResignByPage(String eid, String ename, String todate,
			String totype, int pageSize, int pageNumber) {
		StringBuilder sql = new StringBuilder("select * from turnover");
		//��ְ����ѡ�񡪡�ֻѡһ
		Integer totype1 = Integer.valueOf(totype);
		switch (totype1) {
		case 0:
			totype = "������ְ";
			break;
		case 1:
			totype = "����";
			break;
		case 2:
			totype = "����";
			break;
		case 3:
			totype = "�����ڽ���";
			break;
		}
		StringBuilder builder = new StringBuilder();
		if (todate != null && !todate.isEmpty()) {
			builder.append(" and todate=to_date('" + todate + "','yyyy-mm-dd')");
		}
//Integer����Number����Integer eid=Integer.valueOf(request.getParameter("eid"));
		if (eid != null && !eid.isEmpty()) {
			builder.append(" and eid='" + eid + "'");
		}
		if (ename != null && !ename.isEmpty()) {
			builder.append(" and ename='" + ename + "'");
		}
		if (totype != null && !totype.isEmpty() ) {
			builder.append(" and totype='" + totype + "'");
			
		}
		builder.delete(0, 4); 
		if (!builder.toString().equals("")) {
			builder.insert(0, " where");
		}
		sql.append(builder.toString());
		sql.append(" order by eid desc");
		
		Pagination pg = new OraclePagination(sql.toString(),pageSize,pageNumber);
		return pg;
	
	}
	

	
	


}
