package com.neusoft.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neusoft.bean.Admin;
import com.neusoft.bean.Department;
import com.neusoft.bean.EmpEntry;
import com.neusoft.dao.BaseDao;
import com.neusoft.dao.EmpEntryDao;
import com.neusoft.mapping.EntityMapping;
import com.neusoft.mapping.MappingFactory;
import com.neusoft.util.OraclePagination;
import com.neusoft.util.Pagination;

public class EmpEntryDaoImpl extends BaseDao implements EmpEntryDao {
	/**
	 * 添加员工信息
	 */
	public boolean addEmpMessage(EmpEntry ee) throws SQLException,
			ClassNotFoundException {
		String sql = "INSERT INTO Employee VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int i = jdbcTemplate.update(sql, ee.getEid(), ee.getEname(), ee
				.getCard(), ee.getSex(), ee.getDeptno(), ee.getDname(), ee
				.getJobno(), ee.getJname(), ee.getWorkDay(), ee.getEmpForm(),
				ee.getPersonSource(), ee.getPoliticStatus(), ee
						.getNationalCity(), ee.getNativePlace(), ee.getPhone(),
				ee.getEmail(), ee.getHeight(), ee.getBloodType(), ee
						.getMarriage(), ee.getBirthPlace(), ee
						.getResidentPlace(), ee.getHighestEducation(), ee
						.getHighestOffering(), ee.getGraduateSchool(), ee
						.getMajor(), ee.getGraduateDay(), ee
						.getForeignLanguage(), ee.getCareer(), ee
						.getFamilyRelationship(), ee.getSocialRelationship(),
				ee.getIdStyle(), ee.getFormalDay(), ee.getProbationDay(), ee
						.getBirthday(),ee.getState());
		return i == 1;
	}
	/**
	 * 根据ID获取员工信息
	 */
	public EmpEntry getEmpMessageById(Integer eid) throws SQLException,
			ClassNotFoundException {
		String sql = "SELECT * FROM employee WHERE eid = ?";
		EntityMapping mapping = mappingFactory
				.getMapping(MappingFactory.EmpEntry_MAPPING);
		List<Object> list = jdbcTemplate.query(sql, mapping, eid);
		EmpEntry ee = null;
		for (int i = 0; i < list.size(); i++) {
			ee = (EmpEntry) list.get(i);
		}
		return ee;
	}

	/**
	 * 删除员工信息
	 */
	public boolean deleteEmpMessage(Integer eid) throws SQLException,
			ClassNotFoundException {
		String sql = "delete employee where eid=?";
		int i = jdbcTemplate.update(sql, eid);
		return i == 1;
	}

	/**
	 * 修改员工信息
	 */
	public boolean modifyEmpMessage(EmpEntry ee) throws SQLException,
			ClassNotFoundException {
		String sql = "update employee set ename=?,sex=?,workDay=?,phone=?,email=?,formalDay=?,probationDay=? where eid=?";
		int i = jdbcTemplate.update(sql, ee.getEname(), ee
				.getSex(), ee.getWorkDay(),ee.getPhone(),ee.getEmail(), ee.getFormalDay(), ee.getProbationDay(),
				ee.getEid());
		return i == 1;
	}

	/**
	 * 显示分页
	 */
	public Pagination getEmployeeByPage(String eid, String ename,
			String deptno, String jobno, int pageSize, int pageNumber)
			throws SQLException, ClassNotFoundException {
		StringBuilder sql = new StringBuilder("select * from employee where state!=2 ");
		StringBuilder condition = new StringBuilder();
		if (eid!= null && !eid.isEmpty()) {
			condition.append(" and EID='" + eid + "'");
		}
		if (ename != null && !ename.isEmpty()) {
			condition.append(" and ENAME='" + ename + "'");
		}
		if (deptno != null && !deptno.isEmpty() && !deptno.equals("0")) {
			condition.append(" and DEPTNO=" + deptno);
		}
		if (jobno != null && !jobno.isEmpty() && !jobno.equals("0")) {
			condition.append(" and JOBNO=" +jobno);
		}
//		if(!condition.toString().isEmpty()){
//			condition.delete(0, 4);
//			condition.insert(0, " where");
//		}
		sql.append(condition.toString());
		sql.append(" order by eid desc");
		
		Pagination pg = new OraclePagination(sql.toString(),pageSize,pageNumber);
		return pg;
	}


	/**
	 * 判断输入的员工编号是否存在
	 * 
	 * @param eid
	 * @return
	 */
	public boolean isCheckExist(Integer eid) {

		String sql = "SELECT * FROM Employee WHERE EID=?";
		EntityMapping mapping = mappingFactory
				.getMapping(mappingFactory.EmpEntry_MAPPING);
		List<Object> list = jdbcTemplate.query(sql, mapping, eid);
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 员工状态
	 */
	public String getEmpForm(Integer eid) {
		
		String sql = "SELECT * FROM Employee WHERE EID=?";
		EntityMapping mapping = mappingFactory
				.getMapping(mappingFactory.EmpEntry_MAPPING);
		List<Object> list = jdbcTemplate.query(sql, mapping, eid);
		if (list.size() > 0) {
			EmpEntry ee = (EmpEntry) list.get(0);
			String empForm = ee.getEmpForm();
			return empForm;
		} else {
			return null;
		}	
	}

}
