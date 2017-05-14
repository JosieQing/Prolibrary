package com.neusoft.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.neusoft.bean.Admin;
import com.neusoft.dao.impl.AdminDaoImpl;
import com.neusoft.db.DBManager;
import com.neusoft.service.AdminService;
import com.neusoft.util.Pagination;

public class AdminServiceImpl implements AdminService {
	
	
	private AdminDaoImpl adminDao;
	private DBManager dbManager;
	
	//面向接口编程
	//控制反转（IOC）：以前需要自己做的事，现在交给调用者来完成。
	public AdminServiceImpl(){
		adminDao = new AdminDaoImpl();
		dbManager = DBManager.getInstance();
	}
	
//	public AdminerviceImpl(){
//		this.userDao = new UserDaoImpl();
//	}
	
	/**
	 * 验证登陆是否成功
	 */

	public Admin isValidate(String username, String password) {
		
		Connection conn = dbManager.getConnection();
		adminDao.setConnection(conn);
		Admin user = null;
		try {
			user = adminDao.isCheckLogin(username, password);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return user;
	}
	/**
	 * 增加员工信息
	 */
	
	public boolean addAdmin(Admin admin) throws SQLException,ClassNotFoundException {
		// 调用持久层的方法
		boolean isRight = false;
		Connection conn = dbManager.getConnection();
		adminDao.setConnection(conn);
		
		try {
			isRight = adminDao.addAdmin(admin);
			conn.commit();//提交
		} catch (SQLException e) {
			conn.rollback();//回滚
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isRight;
	}
	
	/**
	 * 根据ID删除用户
	 * @throws SQLException 
	 * @throws SQLException,ClassNotFoundException 
	 */

	public boolean deleteAdminById(int id)  {
		
		boolean isRight = false;
		Connection conn = dbManager.getConnection();
		adminDao.setConnection(conn);
		
		try {
			isRight = adminDao.deleteAdminById(id);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();//回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			try {
				conn.rollback();//回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		return isRight;
	}
	
	/**
	 * 通过ID获得员工信息
	 */
	
	public Admin getAdminById(int id)  {
		//连接数据库
		Connection conn = dbManager.getConnection();
		adminDao.setConnection(conn);
		//执行SQL语句
		Admin admin = null;
		try {
			admin = adminDao.getAdminById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return admin;
	}
	
	/**
	 * 查询所有员工信息
	 */
	public List<Admin> getAllAdminMessage() throws SQLException,ClassNotFoundException{
		
		Connection conn = dbManager.getConnection();
		adminDao.setConnection(conn);
		
		List<Admin> list = adminDao.getAllAdminMessage();
		return list;
	}
	
	/**
	 * 根据模糊username查询有关信息
	 * @return
	 */
	public List<Admin> getAllConnecteMessage(String str) {
		Connection conn = dbManager.getConnection();
		adminDao.setConnection(conn);
		
		List<Admin> list = adminDao.getAllConnecteMessage(str);
		return list;
	}
	
	
	/**
	 * 修改用户信息
	 * @throws SQLException 
	 */
	public boolean upDate(Admin admin,int id) throws SQLException{
		boolean isRight = false;
		
		Connection conn = dbManager.getConnection();
		adminDao.setConnection(conn);
		
		isRight = adminDao.upDate(admin,id);
		try {
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return isRight;
	}
	
	
	/**
	 * 获取所有用户的username
	 * @return
	 */
	public String[] getUsername(){
		Connection conn = dbManager.getConnection();
		adminDao.setConnection(conn);
		
		String[] str = adminDao.getUsername();
		return str;
	}
	
	/**
	 * 分页---pageSize：每页记录条数；pageNumber：当前选择页
	 */
	public Pagination getAdminByPage(int pageSize,int pageNumber){
		
		Connection conn = dbManager.getConnection();
		adminDao.setConnection(conn);
		Pagination p = null;
		try {
			p = adminDao.getAdminByPage(pageSize, pageNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return p;
	}
	
	

}
