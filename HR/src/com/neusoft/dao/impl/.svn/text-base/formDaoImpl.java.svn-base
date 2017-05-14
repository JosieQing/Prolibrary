package com.neusoft.dao.impl;

import com.neusoft.dao.BaseDao;
import com.neusoft.dao.formDao;
import com.neusoft.util.OraclePagination;
import com.neusoft.util.Pagination;

public class formDaoImpl extends BaseDao implements formDao {
	/**
	 * 获取新聘员工信息报表
	 */
	public Pagination getFormNewEmployee(String dname, String workDay,
			String formalDay,int pageSize, int pageNumber) {
		StringBuffer sql=new StringBuffer("select eid,dname,jname,ename,sex,workday,highestEducation FROM employee");
		//String——Integer(通过dname=deptno)：一选多
		Integer did=Integer.valueOf(dname);
		StringBuffer builder= new StringBuffer();
		if (dname != null && !dname.isEmpty()) {
			if (!dname.equals("101")) {
							//deptno=did
				builder.append(" and deptno="+did);
			} else {
				builder.append("");
			}
		}
		if (workDay != null && !workDay.isEmpty()) {
													//客户端输入的信息
			builder.append(" and workDay >= to_date('"+ workDay + "','yyyy-mm-dd')");
		}
		if (formalDay != null && !formalDay.isEmpty()) {
			builder.append(" and workDay<=to_date('" + formalDay + "','yyyy-mm-dd')");
		}
		//and——where
		builder.delete(0, 4);
		if (!builder.toString().equals("")) {
			builder.insert(0, " where");
		}
		sql.append(builder.toString());
		Pagination page=new OraclePagination(sql.toString(),pageSize,pageNumber);
		return page;
	}
	

	/**
	 * 获取部门调动报表
	 */
	public Pagination getFormMoveDept(String startdate, String endDate,int pageSize, int pageNumber) {
		StringBuffer sql= new StringBuffer("select employee.eid,ename,department.dname,newdname,tmdate,tmtype from employee, department, transferman ");
		StringBuffer buffer=new StringBuffer();
		if(startdate!=null&& !startdate.isEmpty()){	
			buffer.append(" and tmdate>=to_date('"+ startdate + "','yyyy-mm-dd')");
		}
		if(endDate!=null&&!endDate.isEmpty()){
		buffer.append(" and tmdate<=to_date('"+ endDate + "','yyyy-mm-dd')");
		}
		buffer.delete(0, 4);
		if(!buffer.toString().equals("")){
			buffer.insert(0,"where");
		}
		sql.append(buffer.toString());
		Pagination page=new OraclePagination(sql.toString(),pageSize,pageNumber);
		
		return page;
	}

	/**
	 * 获取岗位调动报表
	 */
	public Pagination getFormMoveEemployee(String startdate, String endDate,int pageSize, int pageNumber) {
		StringBuffer sql=new StringBuffer("select employee.eid,ename,job.jname,newjname,tmdate,tmtype from employee,job,transferman ");
		StringBuffer buffer=new StringBuffer();
		if(startdate!=null&&!startdate.isEmpty()){
			buffer.append(" and tmdate>=to_Date('"+startdate+"','yyyy-mm-dd')");
		}
		if(endDate!=null&&!endDate.isEmpty()){
			buffer.append(" and tmdate<=to_Date('"+endDate+"','yyyy-mm-dd')");
		}
		buffer.delete(0, 4);
		if(!buffer.toString().equals("")){
			buffer.insert(0,"where");
		}
		sql.append(buffer.toString());
		Pagination page=new OraclePagination(sql.toString(),pageSize,pageNumber);
		
		return page;
	}

	/**
	 * 获取离职调动报表
	 */
	public Pagination getFormResignMessage(String dname, String date,String endDate,int pageSize, int pageNumber) {
		StringBuffer sql=new StringBuffer("select employee.eid,employee.ename,totype,todate from employee,turnover ");
		Integer did=Integer.valueOf(dname);
		StringBuffer buffer=new StringBuffer();
		if(dname!=null&&!dname.isEmpty()){
			if(!dname.equals("101")){
				buffer.append(" and deptno="+did);
		}else{
			buffer.append("");
			}
		}
		if(date!=null&&!date.isEmpty()){
			buffer.append(" and todate>=to_Date('"+date+"','yyyy-mm-dd')");
		}
		if(endDate!=null&&!endDate.isEmpty()){
			buffer.append(" and todate<=to_Date('"+endDate+"','yyyy-mm-dd')");
		}
		buffer.delete(0,4);
		if(!buffer.toString().equals("")){
			buffer.insert(0, "where");
		}
		sql.append(buffer.toString());
		Pagination page=new OraclePagination(sql.toString(),pageSize,pageNumber);
		return page;
	}

	
}
