package com.neusoft.dao.impl;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.neusoft.bean.Job;
import com.neusoft.dao.BaseDao;
import com.neusoft.dao.JobDao;
import com.neusoft.mapping.EntityMapping;
import com.neusoft.mapping.MappingFactory;
import com.neusoft.util.OraclePagination;
import com.neusoft.util.Pagination;

public class JobDaoImpl extends BaseDao implements JobDao {
	/**
	 * 添加岗位信息
	 */
	public boolean addJobMessage(Job job)throws SQLException, ClassNotFoundException{
		String sql="insert into job values(?,?,?,?,?)";
		int i=jdbcTemplate.update(sql, job.getJobno(),job.getJname(),job.getJobStyle(),job.getJobCompile(),job.getDeptno());
		return i==1;
	}
	/**
	 * 修改岗位信息
	 */
	public boolean modifyJobMessage(Job job)throws SQLException, ClassNotFoundException{
		String sql="update job set jname=?,jobStyle=?,jobCompile=?,deptno=? where jobno=?";
		int i=jdbcTemplate.update(sql,job.getJname(),job.getJobStyle(),job.getJobCompile(),job.getDeptno(),job.getJobno());
		return i==1;
	}
	/**
	 * 删除岗位信息
	 */
	public boolean deleteJobMessage(Integer jobno)throws SQLException, ClassNotFoundException{
		String sql="delete job where jobno=?";
		int i=jdbcTemplate.update(sql,jobno);
		return i==1;
	}
	/**
	 * 根据岗位ID查询岗位信息
	 */
	public Job getJobMessageById(Integer jobno) throws SQLException,
		ClassNotFoundException {
	String sql = "SELECT * FROM job WHERE jobno = ?";
	EntityMapping mapping=mappingFactory.getMapping(MappingFactory.Job_MAPPING);
	List<Object> list = jdbcTemplate.query(sql, mapping, jobno);				
	Job job=null;
	for(int i=0;i<list.size();i++){
		job=(Job) list.get(i);	
	}	
	return job;
	}
	/**
	 * 查询岗位信息
	 */
	public List<Job> getJobMessage(String jobno,String deptno,String jname)throws SQLException, ClassNotFoundException{
		StringBuilder sql = new StringBuilder("select * from job ");
		StringBuilder condition = new StringBuilder();
		if (deptno != null && !deptno.isEmpty() && !deptno.equals("0")) {
			condition.append(" and DEPTNO=" + deptno);
		}
		if (jobno != null && !jobno.isEmpty() && !jobno.equals("0")) {
			condition.append(" and JOBNO=" +jobno);
		}
		if (jname != null && !jname.isEmpty()) {
			condition.append(" and JNAME='" + jname + "'");
		}
		if(!condition.toString().isEmpty()){
			condition.delete(0, 4);
			condition.insert(0, " where");
		}
		sql.append(condition.toString());
		sql.append(" order by jobno desc");
		List<Job> list=new ArrayList<Job>();
		EntityMapping mapping=mappingFactory.getMapping(MappingFactory.Job_MAPPING);
		List<Object> lists = jdbcTemplate.query(sql.toString(),mapping);	
		Job job=null;
		for(int i=0;i<lists.size();i++){
			job=(Job)lists.get(i);
			list.add(job);
		}
		return list;
	}
	
}
