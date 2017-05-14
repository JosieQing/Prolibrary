package com.neusoft.service.impl;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import com.neusoft.dao.impl.JobDaoImpl;
import com.neusoft.db.DBManager;
import com.neusoft.bean.Job;
import com.neusoft.service.JobService;
public class JobServiceImpl implements JobService {
	private JobDaoImpl jsdi;
	public JobServiceImpl(){
		jsdi=new JobDaoImpl();		
	}
	/**
	 * 添加岗位信息
	 */
	public boolean addJobMessage(Job job)throws SQLException, ClassNotFoundException{
		boolean isRight=false;
		DBManager dbManager = DBManager.getInstance();
		Connection conn=dbManager.getConnection();
		jsdi.setConnection(conn);
		try {
			isRight=jsdi.addJobMessage(job);
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isRight;
	}
	/**
	 * 查询岗位信息
	 */
	public List<Job> getJobMessage(String jobno,String deptno,String jname)throws SQLException, ClassNotFoundException{
		List<Job> list=null;
		DBManager dbManager = DBManager.getInstance();
		Connection conn=dbManager.getConnection();
		jsdi.setConnection(conn);
		try {
			list=jsdi.getJobMessage(jobno, deptno,jname);
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	/**
	 * 修改岗位信息
	 */
	public boolean modifyJobMessage(Job job)throws SQLException, ClassNotFoundException{
		DBManager dbManager = DBManager.getInstance();
		Connection conn=dbManager.getConnection();
		boolean isRight = false;
		jsdi.setConnection(conn);
		isRight=jsdi.modifyJobMessage(job);
		conn.commit();
		return isRight;
	}
	/**
	 * 删除岗位信息
	 */
	public boolean deleteJobMessage(Integer jobno)throws SQLException, ClassNotFoundException{
		boolean isRight=false;
		DBManager dbManager = DBManager.getInstance();
		Connection conn=dbManager.getConnection();
		jsdi.setConnection(conn);
		isRight=jsdi.deleteJobMessage(jobno);
		conn.commit();
		return isRight;
	}
	/**
	 * 根据Id查询岗位信息
	 */
	public Job getJobMessageById(Integer jobno) throws SQLException,
			ClassNotFoundException {
		DBManager dbManager = DBManager.getInstance();
		Connection conn=dbManager.getConnection();
		jsdi.setConnection(conn);
		Job job = jsdi.getJobMessageById(jobno);
		conn.commit();
		return job;
	}

}
