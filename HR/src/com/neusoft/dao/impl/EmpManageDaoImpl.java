package com.neusoft.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.bean.Admin;
import com.neusoft.bean.Department;
import com.neusoft.bean.EmpEntry;
import com.neusoft.dao.BaseDao;
import com.neusoft.dao.EmpManageDao;
import com.neusoft.mapping.EntityMapping;
import com.neusoft.mapping.MappingFactory;
import com.neusoft.util.OraclePagination;
import com.neusoft.util.Pagination;

public class EmpManageDaoImpl extends BaseDao implements EmpManageDao{
	/**
	 * 添加员工信息
	 */
	public boolean addEmpMessage(EmpEntry ee) throws SQLException,
			ClassNotFoundException {
		String sql = "INSERT INTO Employee VALUES(NB_EMP.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int i = jdbcTemplate.update(sql,ee.getEname(),ee.getCard(),ee.getBirthday(),ee.getSex(),ee.getDeptno(),ee.getDname(),ee.getJobno(),ee.getJname(),ee.getWorkDay(),ee.getEmpForm(),ee.getPersonSource(),ee.getPoliticStatus(),ee.getNationalCity(),ee.getNativePlace(),ee.getPhone(),ee.getEmail(),ee.getHeight(),ee.getBloodType(),ee.getMarriage(),ee.getBirthPlace(),ee.getResidentPlace(),ee.getHighestEducation(),ee.getHighestOffering(),ee.getGraduateSchool(),ee.getForeignLanguage(),ee.getCareer(),ee.getFamilyRelationship(),ee.getSocialRelationship(),ee.getIdStyle(),ee.getFormalDay());
		return i==1;
	}
	/**
	 * 查询员工信息
	 */
	public List<EmpEntry> getEmpMessage() throws SQLException,
			ClassNotFoundException {
		String sql="select * from employee";
		List<EmpEntry> list=new ArrayList<EmpEntry>();
		EntityMapping mapping=mappingFactory.getMapping(MappingFactory.EmpEntry_MAPPING);
		List<Object> lists=jdbcTemplate.query(sql, mapping);
//		//对lIST集合进行遍历
		EmpEntry ee=null;
		for (int i = 0; i < lists.size(); i++) {
			ee=(EmpEntry)lists.get(i);
			list.add(ee);
		}
		return list;

	}
	/**
	 * 根据ID获取员工信息
	 */
	public EmpEntry getEmpMessageById(Integer eid) throws SQLException,
		ClassNotFoundException {
	String sql = "SELECT * FROM employee WHERE eid = ?";
	EntityMapping mapping=mappingFactory.getMapping(MappingFactory.EmpEntry_MAPPING);
	List<Object> list = jdbcTemplate.query(sql, mapping, eid);				
	EmpEntry ee=null;
	for(int i=0;i<list.size();i++){
		ee=(EmpEntry) list.get(i);	
	}	
	return ee;
	}


	/**
	 * 删除员工信息
	 */
	public boolean deleteEmpMessage(Integer eid) throws SQLException,
			ClassNotFoundException {
		String sql="delete employee where eid=?";
		int i=jdbcTemplate.update(sql,eid);
		return i==1;
	}
	/**
	 * 修改员工信息
	 */
	public boolean modifyEmpMessage(EmpEntry ee) throws SQLException,
			ClassNotFoundException {
		String sql="update employee set ename=?,idCard=?,birthday=?,sex=?,deptno=?,dname=?,jobno=?,jname=?,workDay=?,empForm=?,personSource=?,politicStatus=?,nationalCity=?,nativePlace=?,phone=?,email=?,height=?,bloodType=?,marriage=?,birthPlace=?,residentPlace=?,highestEducation=?,highestOffering=?,graduateSchool=?,major=?,foreignLanguage=?,career=?,familyRelationship=?,socialRelationship=?,idStyle=?,formalDay=?,probationDay=?where eid=?";
		int i=jdbcTemplate.update(sql,ee.getEname(),ee.getCard(),ee.getBirthday(),ee.getSex(),ee.getDeptno(),ee.getDname(),ee.getJobno(),ee.getJname(),ee.getWorkDay(),ee.getEmpForm(),ee.getPersonSource(),ee.getPoliticStatus(),ee.getNationalCity(),ee.getNativePlace(),ee.getPhone(),ee.getEmail(),ee.getHeight(),ee.getBloodType(),ee.getMarriage(),ee.getBirthPlace(),ee.getResidentPlace(),ee.getHighestEducation(),ee.getHighestOffering(),ee.getGraduateSchool(),ee.getMajor(),ee.getForeignLanguage(),ee.getCareer(),ee.getFamilyRelationship(),ee.getSocialRelationship(),ee.getIdStyle(),ee.getFormalDay(),ee.getProbationDay(),ee.getEid() );
		return i==1;
	}
	/**
	 * 根据部门id检索该部门员工信息
	 */
	public List<EmpEntry> checkEmpOfDept(Integer deptno)throws SQLException, ClassNotFoundException{
		String sql="select * from employee where deptno=?";
		List<EmpEntry> list=new ArrayList<EmpEntry>();
		EntityMapping mapping=mappingFactory.getMapping(MappingFactory.EmpEntry_MAPPING);
		List<Object> lists=jdbcTemplate.query(sql, mapping,deptno);
		EmpEntry ee=null;
		for (int i = 0; i < lists.size(); i++) {
			ee=(EmpEntry)lists.get(i);
			list.add(ee);
		}
		if(list.size()>0)
			return list;
		else
			return null;
	}

	/**
	 * 根据岗位id检索该岗位员工信息
	 */
	public List<EmpEntry> checkEmpOfJob(Integer jobno)throws SQLException, ClassNotFoundException{
		String sql="select * from employee where  jobno=?";
		List<EmpEntry> list=new ArrayList<EmpEntry>();
		EntityMapping mapping=mappingFactory.getMapping(MappingFactory.EmpEntry_MAPPING);
		List<Object> lists =  jdbcTemplate.query(sql, mapping, jobno);
		EmpEntry ee=null;
		for (int i = 0; i < lists.size(); i++) {
			ee=(EmpEntry)lists.get(i);
			list.add(ee);
		}
		if(list.size()>0)
			return list;
		else
			return null;
	}
	/**
	 * 显示分页
	 */
	public Pagination getEmpMessageByPage(int pageSize, int pageNumber)
		throws SQLException, ClassNotFoundException {
	String sql="select * from employee order by eid desc";
	Pagination p=new OraclePagination(sql,pageSize,pageNumber); 
	return p;
	}
	
	/**
	 * 判断输入的员工编号是否存在
	 * @param eid
	 * @return
	 */
	public boolean isCheckExist(Integer eid){
		
		String sql = "SELECT * FROM Employee WHERE EID=?";
		EntityMapping mapping = mappingFactory.getMapping(mappingFactory.EmpEntry_MAPPING);
		List<Object> list = jdbcTemplate.query(sql, mapping,eid);
		if(list.size()>0){
			return true;
		}else{
			return false;
		}
	}

}
