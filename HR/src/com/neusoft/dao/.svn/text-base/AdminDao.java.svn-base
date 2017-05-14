package com.neusoft.dao;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.bean.Admin;
import com.neusoft.util.Pagination;

	
	
	/**
	 * AdminDao接口是对User bean的操作
	 * 
	 * @author Administrator
	 * 
	 */
	public interface AdminDao {
		
		
		/**
		 * 验证登陆
		 */	
		public Admin isCheckLogin(String username,String password)throws SQLException, ClassNotFoundException ;
		
		/**
		 * 增加用户
		 * 
		 * @param admin
		 */
		public boolean addAdmin(Admin user)throws SQLException, ClassNotFoundException;
	
		/**
		 * 根据ID查询员工信息
		 * 
		 * @param id
		 * @return
		 */
		public Admin getAdminById(int id)throws SQLException, ClassNotFoundException;
	
		/**
		 * 根据ID删除用户
		 * 
		 * @param id
		 */
		public boolean deleteAdminById(int id)throws SQLException, ClassNotFoundException;
	
		/**
		 * 查询所有用户信息
		 * @return
		 */
		public List<Admin> getAllAdminMessage()throws SQLException, ClassNotFoundException;
		
		/**
		 * 修改用户信息
		 * @return
		 */
		public boolean upDate(Admin admin,int id);
		
		
		/**
		 * 根据模糊username查询有关信息
		 * @return
		 */
		public List<Admin> getAllConnecteMessage(String str);
		
		/**
		 * 获取所有用户的username
		 * @return
		 */
		public String[] getUsername();
		
		/**
		 * 分页
		 * @param pageSize
		 * @param pageNumber
		 * @return
		 * @throws SQLException
		 */
		public Pagination getAdminByPage(int pageSize,int pageNumber)throws SQLException;
}
