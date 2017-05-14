package com.neusoft.dao;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.bean.EmpEntry;
import com.neusoft.bean.ProbationMan;
import com.neusoft.mapping.EntityMapping;
import com.neusoft.mapping.MappingFactory;
import com.neusoft.util.Pagination;

/**
 * ProbationManDao 接口是对ProbationMan bean 的操作
 * @author ttc
 *
 */
public interface ProbationManDao {
	
//
//	/**
//	 * 试用信息录入
//	 */
//	public boolean addAllProbationInfo(ProbationMan pm);
	
	/**
	 * 根据ID获取员工信息
	 */
	public EmpEntry getEmpMessageById(Integer eid) ;	
	/**
	 * 试用期信息简单录入
	 * @param pm
	 * @return
	 */
	public boolean addProbationInfo(ProbationMan pm);
	
	/**
	 * 试用期信息管理
	 * @param pm
	 * @param eid
	 * @return
	 */
	public boolean probationManInfo(ProbationMan pm,Integer eid);
	
//	/**
//	 * 通过员工编号查询信息
//	 * @param eid
//	 * @return
//	 */
//	public ProbationMan getProbationInfoByEid(Integer eid);
//
//	/**
//	 * 通过员工试用状态查询信息
//	 * @return
//	 */
//	public List<ProbationMan> getAllProbationInfoByState(String state);
//	
//	/**
//	 * 试用信息查询
//	 * @return
//	 */
//	public List<ProbationMan> getAllProbationInfo();
//	
//	
//	/**
//	 * 根据模糊的eid查询有关信息
//	 * @param eid
//	 * @return
//	 */
//	public List<ProbationMan> getAllConnecteMessage(String eid);
//	
//	
//	
//	
//	/**
//	 * 分页ByEid
//	 * @param pageSize
//	 * @param pageNumber
//	 * @return
//	 * @throws SQLException
//	 */
//	public Pagination getProbationManByPageByEid(String eid,int pageSize,int pageNumber);
//	
//	
//	/**
//	 * 分页ByState
//	 * @param pageSize
//	 * @param pageNumber
//	 * @return
//	 * @throws SQLException
//	 */
//	public Pagination getProbationManByPageByState(String state,int pageSize,int pageNumber);
//	
	/**
	 * 分页---pageSize：每页记录条数；pageNumber：当前选择页
	 * 根据eid模糊查询和试用状态查询
	 */
	public Pagination getProbationManByPage(String eid, String state,
			int pageSize, int pageNumber);
	
	
}
