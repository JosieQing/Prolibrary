 package com.neusoft.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.bean.Department;
import com.neusoft.bean.EmpEntry;
import com.neusoft.bean.Job;
import com.neusoft.bean.ProbationMan;
import com.neusoft.bean.Turnover;
import com.neusoft.dao.AjaxDao;
import com.neusoft.dao.BaseDao;
import com.neusoft.mapping.EntityMapping;

public class AjaxDaoImpl  extends BaseDao implements AjaxDao{
	
	
	/**
	 * 根据EID得到ENAME
	 * @param eid
	 * @return
	 */
	public String getEnameByEid(Integer eid){
		
		//通过eid得到查询信息
		String sql = "SELECT * FROM EMPLOYEE WHERE EID = "+eid;
		EntityMapping mapping = mappingFactory.getMapping(mappingFactory.EmpEntry_MAPPING);
		List<Object> list = jdbcTemplate.query(sql, mapping);
		if(list.size()>0){//查询第一条信息
			EmpEntry ee = (EmpEntry)list.get(0);
			return ee.getEname();
		}else{
			return "0";
		}
	}
	
	/**
	 * 根据EID得到PMID
	 * @param eid
	 * @return
	 */
	public Integer getPmIdByEid(Integer eid){
		
		
		Integer pmid = null;
		
		String sql1 = "SELECT * FROM PROBATIONMAN WHERE EID = "+eid;
		EntityMapping mapping1 = mappingFactory.getMapping(mappingFactory.PROBATIONMAN_MAPPING);
		List<Object> list1 = jdbcTemplate.query(sql1, mapping1);
		if(list1.size()>0){
			ProbationMan pm = (ProbationMan)list1.get(0);
			pmid = pm.getPmid();
			return pmid;
		}else{
			return 0;
		}
		
	}

	
	
	/**
	 * 根据EID得到JNAME
	 * @param eid
	 * @return
	 */
	public String getJnameByEid(Integer eid){
		
		String sql = "SELECT * FROM EMPLOYEE WHERE EID = "+eid;
		EntityMapping mapping = mappingFactory.getMapping(mappingFactory.EmpEntry_MAPPING);
		List<Object> list = jdbcTemplate.query(sql, mapping);
		if(list.size()>0){
			EmpEntry ee = (EmpEntry)list.get(0);
			return ee.getJname();
		}else{
			return "0";
		}
	}
	
	/**
	 * 根据EID得到DNAME
	 * @param eid
	 * @return
	 */
	public String getDnameByEid(Integer eid){
		
		String sql = "SELECT * FROM EMPLOYEE WHERE EID = "+eid;
		EntityMapping mapping = mappingFactory.getMapping(mappingFactory.EmpEntry_MAPPING);
		List<Object> list = jdbcTemplate.query(sql, mapping);
		if(list.size()>0){
			EmpEntry ee = (EmpEntry)list.get(0);
			return ee.getDname();
		}else{
			return "0";
		}
	}
	
	/**
	 * 根据JOBNO得到DNAME
	 * @param eid
	 * @return
	 */
	public String getDnameByJobNo(String jobNo){
		
		Integer dno = 0;
		String sql1 = "SELECT DEPTNO FROM JOB WHERE  JOBNO = "+jobNo;
		EntityMapping mapping1 = mappingFactory.getMapping(mappingFactory.Job_MAPPING);
		List<Object> list1 =jdbcTemplate.query(sql1, mapping1);
		if(list1.size()>0){
			
			Job job = (Job)list1.get(0);
			dno = job.getDeptno();
		
			String sql2 = "SELECT DEPTNO FROM DEPARTMENT WHERE  DEPTNO = "+dno;
			EntityMapping mapping2 = mappingFactory.getMapping(mappingFactory.Department_MAPPING);
			List<Object> list2 = jdbcTemplate.query(sql2, mapping2);
			
			if(list2.size()>0){
				Department d = (Department)list2.get(0);
				return d.getDname();
			}else{
				return "0";
			}
		}else{
			return "0";
		}
	}
	
	/**
	 * 根据DNAME得到JNAME
	 * @param Dname
	 * @return
	 */
	public String getJnameByDname(String Dname){
		
		Integer deptno = 0;
		String sql1 = "SELECT * FROM DEPARTMENT WHERE  Dname = "+Dname;
		EntityMapping mapping1 = mappingFactory.getMapping(mappingFactory.Job_MAPPING);
		List<Object> list1 =jdbcTemplate.query(sql1, mapping1);
		if(list1.size()>0){
			
			Job job = (Job)list1.get(0);
			deptno = job.getDeptno();
		
			String sql2 = "SELECT * FROM JOB WHERE  DEPTNO = "+deptno;
			EntityMapping mapping2 = mappingFactory.getMapping(mappingFactory.Department_MAPPING);
			List<Object> list2 = jdbcTemplate.query(sql2, mapping2);
			
			if(list2.size()>0){
				Job d = (Job)list2.get(0);
				return d.getJname();
			}else{
				return "0";
			}
		}else{
			return "0";
		}
	}
	
	
	/**
	 * 根基deptno查询岗位信息
	 */

	public List<Job> getJobMessage(String deptno) throws SQLException,
			ClassNotFoundException {
		String sql = "select * from job where deptno=?";
		List<Job> list=new ArrayList<Job>();
		EntityMapping mapping=mappingFactory.getMapping(mappingFactory.Job_MAPPING);
		List<Object> lists =  jdbcTemplate.query(sql, mapping, deptno);
		Job job=null;
		for(int i=0;i<lists.size();i++){
			job=(Job)lists.get(i);
			list.add(job);
		}
		return list;
	}
	
	/**
	 * 获取所有部门信息
	 * @return
	 */
	public List<Department> getDeptMessage(){
		
		String[] ss = null;
		
		String sql = "SELECT * FROM department";
		EntityMapping mapping = mappingFactory.getMapping(mappingFactory.Department_MAPPING);
		List<Object> list = jdbcTemplate.query(sql, mapping);
		List<Department> lists = new ArrayList<Department>();
		for (int i = 0; i < list.size(); i++) {
			Department department =(Department) list.get(i);
			lists.add(department);
		} 
		
		return lists;
	}

	/**
	 * 根据岗位编号得到岗位名称
	 */
	public String getJobNameByJobno(Integer jobno) throws SQLException,
			ClassNotFoundException {
		String sql = "SELECT * FROM JOB WHERE JOBNO ="+jobno;
		EntityMapping mapping = mappingFactory.getMapping(mappingFactory.Job_MAPPING);
		List<Object> list = jdbcTemplate.query(sql, mapping);
		if(list.size()>0){
			Job job = (Job)list.get(0);
			return job.getJname();
		}else{
			return null;
		}
	}


	/**
	 * 根据部门编号得到部门名称
	 */
	public String getDnameByDeptno(String deptno) throws SQLException,
			ClassNotFoundException {
		String sql = "SELECT * FROM Department WHERE deptno = "+deptno;
		EntityMapping mapping = mappingFactory.getMapping(mappingFactory.Department_MAPPING);
		List<Object> list = jdbcTemplate.query(sql, mapping);
		if(list.size()>0){
			Department department = (Department)list.get(0);
			return department.getDname();
		}else{
			return null;
		}
	}

	/**
	 * 根据部门编号得到上级部门名称
	 */
	public String getSuperDnameByDeptno(String deptno) throws SQLException,
			ClassNotFoundException {
		String sql = "SELECT * FROM Department WHERE deptno = "+deptno;
		EntityMapping mapping = mappingFactory.getMapping(mappingFactory.Department_MAPPING);
		List<Object> list = jdbcTemplate.query(sql, mapping);
		if(list.size()>0){
			Department department = (Department)list.get(0);
			return department.getSuperDept();
		}else{
			return null;
		}
	}
	
	/**
	 * 根据eid得到lid
	 */
	
	public Integer getEidByLid (Integer eid){
		String sql="select lid from turnover  where eid="+eid;
		EntityMapping mapping= mappingFactory.getMapping(mappingFactory.Turnover_Mapping);
		List<Object> list=jdbcTemplate.query(sql, mapping);
		if(list.size()>0){
			Turnover turnover=(Turnover) list.get(0);
			return turnover.getLid();
		}
		return null;
	}



}
