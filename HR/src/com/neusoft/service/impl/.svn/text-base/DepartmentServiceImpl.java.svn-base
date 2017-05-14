package com.neusoft.service.impl;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import com.neusoft.bean.Department;
import com.neusoft.dao.impl.DepartmentDaoImpl;
import com.neusoft.db.DBManager;
import com.neusoft.service.DepartmentService;
public class DepartmentServiceImpl  implements DepartmentService{
	private DepartmentDaoImpl deptdao;
	public DepartmentServiceImpl() {
		deptdao=new DepartmentDaoImpl();
	}
	/**
	 * 添加部门信息
	 */
	public boolean addDeptMessage(Department dept)throws SQLException, ClassNotFoundException{
		
		boolean isRight=false;
		DBManager dbManager = DBManager.getInstance();
		Connection conn=dbManager.getConnection();
		deptdao.setConnection(conn);
		try {
			isRight=deptdao.addDeptMessage(dept);
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isRight;
	}
	/**
	 * 查询部门信息
	 */
	public List<Department> getDeptMessage(String deptno)throws SQLException, ClassNotFoundException	{
		List<Department> list=null;
		DBManager dbManager = DBManager.getInstance();
		Connection conn=dbManager.getConnection();
		deptdao.setConnection(conn);
		try {
			list=deptdao.getDeptMessage(deptno);
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
	 * 修改部门信息
	 */
	public boolean modifyDeptMessage(Department dept)throws SQLException, ClassNotFoundException{
		DBManager dbManager = DBManager.getInstance();
		Connection conn=dbManager.getConnection();
		boolean isRight = false;
		deptdao.setConnection(conn);
		isRight=deptdao.modifyDeptMessage(dept);
		conn.commit();
		return isRight;
	}
	/**
	 * 删除部门信息
	 */
	public boolean deleteDeptMessage(Integer deptno)throws SQLException, ClassNotFoundException{
		boolean isRight=false;
		DBManager dbManager = DBManager.getInstance();
		Connection conn=dbManager.getConnection();
		deptdao.setConnection(conn);
		isRight=deptdao.deleteDeptMessage(deptno);
		conn.commit();
		return isRight;
	}
	/**
	 * 根据部门id获取部门信息
	 */
	public Department getDeptMessageById(Integer deptno) throws SQLException,
			ClassNotFoundException {
		DBManager dbManager = DBManager.getInstance();
		Connection conn=dbManager.getConnection();
		deptdao.setConnection(conn);
		Department dept = deptdao.getDeptMessageById(deptno);
		conn.commit();
		return dept;
	}

	

	
}
