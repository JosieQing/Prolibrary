package com.neusoft.dao.impl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.neusoft.bean.Department;
import com.neusoft.dao.BaseDao;
import com.neusoft.dao.DepartmentDao;
import com.neusoft.mapping.EntityMapping;
import com.neusoft.mapping.MappingFactory;


public class DepartmentDaoImpl extends BaseDao implements DepartmentDao{
	/**
	 * 添加部门信息
	 */
	public boolean addDeptMessage(Department dept)throws SQLException, ClassNotFoundException{
		String sql="INSERT INTO DEPARTMENT VALUES(?,?,?,?,?,?,?,?)";
		int i = jdbcTemplate
				.update(sql, dept.getDeptno(), dept.getDname(), dept.getDtype(),
						dept.getPhone(), dept.getFax(), dept.getDescribe(),
						dept.getSuperDept(), dept.getStartDay());	
		return i==1;
	}
	/**
	 * 查询部门信息
	 */
	public List<Department> getDeptMessage(String deptno)throws SQLException, ClassNotFoundException{
		
		StringBuilder sql = new StringBuilder("select * from department ");
		StringBuilder condition = new StringBuilder();
		if (deptno != null && !deptno.isEmpty() && !deptno.equals("0")) {
			condition.append(" and DEPTNO=" + deptno);
		}
		if(!condition.toString().isEmpty()){
			condition.delete(0, 4);
			condition.insert(0, " where");
		}
		sql.append(condition.toString());
		sql.append(" order by deptno desc");
		List<Department> list=new ArrayList<Department>();
		EntityMapping mapping=mappingFactory.getMapping(MappingFactory.Department_MAPPING);
		List<Object> lists = jdbcTemplate.query(sql.toString(),mapping);	
		Department dept=null;
		for(int i=0;i<lists.size();i++){
			dept=(Department)lists.get(i);
			list.add(dept);
		}
		return list;
	}
	
	
	/**
	 * 修改部门信息
	 */
	public boolean modifyDeptMessage(Department dept)throws SQLException, ClassNotFoundException{
		String sql="update department set dname=?,dtype=?,phone=?,fax=?,describe=?,superDept=?,startDay=?where deptno=?";
		int i=jdbcTemplate.update(sql, dept.getDname(),dept.getDtype(),dept.getPhone(),dept.getFax(),dept.getDescribe(),dept.getSuperDept(),dept.getStartDay(),dept.getDeptno());
		return i==1;
	}
	/**
	 * 删除部门信息
	 */
	public boolean deleteDeptMessage(Integer deptno)throws SQLException, ClassNotFoundException{
		String sql="DELETE DEPARTMENT WHERE DEPTNO=?";
		int i=jdbcTemplate.update(sql,(int)deptno);
		return i==1;
	}
	/**
	 * 根据部门ID获取部门信息
	 */
	public Department getDeptMessageById(Integer deptno) throws SQLException,
			ClassNotFoundException {
		String sql = "SELECT * FROM department WHERE deptno = ?";
		EntityMapping mapping=mappingFactory.getMapping(MappingFactory.Department_MAPPING);
		List<Object> list = jdbcTemplate.query(sql, mapping, deptno);				
		Department dept=null;
		for(int i=0;i<list.size();i++){
			dept=(Department) list.get(i);	
		}	
		return dept;
	}
	
	/**
	 * 获取所有dname
	 * @return
	 */
	public String[] getDname(){
		
		String sql = "SELECT dname FROM department";
		EntityMapping mapping = mappingFactory.getMapping(mappingFactory.Department_MAPPING);
		List<Object> list = jdbcTemplate.query(sql, mapping);
		List<Department> lists = new ArrayList<Department>();
		for (int i = 0; i < list.size(); i++) {
			Department department =(Department) list.get(i);
			lists.add(department);
		} 
		String[] str = new String[lists.size()];
		for (int i = 0; i < lists.size(); i++) {
			Department department = lists.get(i);
			str[i] = department.getDname();
		}
		return str;
	}
	
}
