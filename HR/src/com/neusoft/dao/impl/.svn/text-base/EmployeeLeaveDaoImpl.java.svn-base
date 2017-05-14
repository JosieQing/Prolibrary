package com.neusoft.dao.impl;


import com.neusoft.dao.BaseDao;
import com.neusoft.dao.EmployeeLeaveDao;

import com.neusoft.util.OraclePagination;
import com.neusoft.util.Pagination;

public class EmployeeLeaveDaoImpl extends BaseDao implements EmployeeLeaveDao{
	
	
	/**
	 * 判断离职是否成功
	 * 	处理加保存
	 * @param eid
	 * @return
	 */
	public boolean getResignById(Integer eid, String todate, String totype,
			String reason, String operator, String ename) {
		//根据状态进行离职
		//修改员工编号为离职状态
		//lid(NB_LID.nextval)+eid(Servlet转类型)
		//+toDate+totype+reason+operator+employee.ename
		String sql="update employee set state=2 where eid=?";
		int i=jdbcTemplate.update(sql, eid);
		//添加到离职表中
		//update修改/insert into添加 ——jdbcTemplate.update();
		String sqll="insert into turnover(lid,eid,todate,totype,reason,operator,ename)" +
				"values(NB_LID.nextval,?,to_date(?,'yyyy-mm-dd'),?,?,?,?)";
		int ii=jdbcTemplate.update(sqll,eid,todate,totype,reason,operator,ename);
		return i==1&&ii==1;
		
	}
	 

	/**
	 * 根据分页得到员工离职记录
	 */
	public Pagination getResignByPage(String eid, String ename, String todate,
			String totype, int pageSize, int pageNumber) {
		StringBuilder sql = new StringBuilder("select * from turnover");
		//离职类型选择——只选一
		Integer totype1 = Integer.valueOf(totype);
		switch (totype1) {
		case 0:
			totype = "主动辞职";
			break;
		case 1:
			totype = "辞退";
			break;
		case 2:
			totype = "退休";
			break;
		case 3:
			totype = "试用期结束";
			break;
		}
		StringBuilder builder = new StringBuilder();
		if (todate != null && !todate.isEmpty()) {
			builder.append(" and todate=to_date('" + todate + "','yyyy-mm-dd')");
		}
//Integer——Number——Integer eid=Integer.valueOf(request.getParameter("eid"));
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
