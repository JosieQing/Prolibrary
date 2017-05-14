package com.neusoft.service;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.bean.Admin;
import com.neusoft.util.Pagination;

public interface AdminService {
	
	/**
	 * 验证登陆是否成功
	 */
	public Admin isValidate(String username, String password);
	
	/**
	 * 增加员工信息
	 * @param user
	 */
	public boolean addAdmin(Admin admin) throws SQLException,ClassNotFoundException;
	
	/**
	 * 根据ID删除用户
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public boolean deleteAdminById(int id) throws SQLException, ClassNotFoundException;
	
	/**
	 * 通过ID获得员工信息
	 */
	
	public Admin getAdminById(int id) throws SQLException,ClassNotFoundException ;
	
	/**
	 * 查询所有员工信息
	 */
	public List<Admin> getAllAdminMessage() throws SQLException,ClassNotFoundException;
	
	/**
	 * 根据模糊username查询有关信息
	 * @return
	 */
	public List<Admin> getAllConnecteMessage(String str);
	
	/**
	 * 修改用户信息
	 */
	public boolean upDate(Admin user,int id) throws SQLException;
	
	/**
	 * 获取所有用户的username
	 * @return
	 */
	public String[] getUsername();
	
	/**
	 * 分页---pageSize：每页记录条数；pageNumber：当前选择页
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 */
	public Pagination getAdminByPage(int pageSize,int pageNumber);
	
}