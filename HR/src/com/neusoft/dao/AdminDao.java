package com.neusoft.dao;

import java.sql.SQLException;
import java.util.List;

import com.neusoft.bean.Admin;
import com.neusoft.util.Pagination;

	
	
	/**
	 * AdminDao�ӿ��Ƕ�User bean�Ĳ���
	 * 
	 * @author Administrator
	 * 
	 */
	public interface AdminDao {
		
		
		/**
		 * ��֤��½
		 */	
		public Admin isCheckLogin(String username,String password)throws SQLException, ClassNotFoundException ;
		
		/**
		 * �����û�
		 * 
		 * @param admin
		 */
		public boolean addAdmin(Admin user)throws SQLException, ClassNotFoundException;
	
		/**
		 * ����ID��ѯԱ����Ϣ
		 * 
		 * @param id
		 * @return
		 */
		public Admin getAdminById(int id)throws SQLException, ClassNotFoundException;
	
		/**
		 * ����IDɾ���û�
		 * 
		 * @param id
		 */
		public boolean deleteAdminById(int id)throws SQLException, ClassNotFoundException;
	
		/**
		 * ��ѯ�����û���Ϣ
		 * @return
		 */
		public List<Admin> getAllAdminMessage()throws SQLException, ClassNotFoundException;
		
		/**
		 * �޸��û���Ϣ
		 * @return
		 */
		public boolean upDate(Admin admin,int id);
		
		
		/**
		 * ����ģ��username��ѯ�й���Ϣ
		 * @return
		 */
		public List<Admin> getAllConnecteMessage(String str);
		
		/**
		 * ��ȡ�����û���username
		 * @return
		 */
		public String[] getUsername();
		
		/**
		 * ��ҳ
		 * @param pageSize
		 * @param pageNumber
		 * @return
		 * @throws SQLException
		 */
		public Pagination getAdminByPage(int pageSize,int pageNumber)throws SQLException;
}
