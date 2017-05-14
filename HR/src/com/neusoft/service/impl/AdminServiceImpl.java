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
	
	//����ӿڱ��
	//���Ʒ�ת��IOC������ǰ��Ҫ�Լ������£����ڽ�������������ɡ�
	public AdminServiceImpl(){
		adminDao = new AdminDaoImpl();
		dbManager = DBManager.getInstance();
	}
	
//	public AdminerviceImpl(){
//		this.userDao = new UserDaoImpl();
//	}
	
	/**
	 * ��֤��½�Ƿ�ɹ�
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
	 * ����Ա����Ϣ
	 */
	
	public boolean addAdmin(Admin admin) throws SQLException,ClassNotFoundException {
		// ���ó־ò�ķ���
		boolean isRight = false;
		Connection conn = dbManager.getConnection();
		adminDao.setConnection(conn);
		
		try {
			isRight = adminDao.addAdmin(admin);
			conn.commit();//�ύ
		} catch (SQLException e) {
			conn.rollback();//�ع�
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isRight;
	}
	
	/**
	 * ����IDɾ���û�
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
				conn.rollback();//�ع�
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			try {
				conn.rollback();//�ع�
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		return isRight;
	}
	
	/**
	 * ͨ��ID���Ա����Ϣ
	 */
	
	public Admin getAdminById(int id)  {
		//�������ݿ�
		Connection conn = dbManager.getConnection();
		adminDao.setConnection(conn);
		//ִ��SQL���
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
	 * ��ѯ����Ա����Ϣ
	 */
	public List<Admin> getAllAdminMessage() throws SQLException,ClassNotFoundException{
		
		Connection conn = dbManager.getConnection();
		adminDao.setConnection(conn);
		
		List<Admin> list = adminDao.getAllAdminMessage();
		return list;
	}
	
	/**
	 * ����ģ��username��ѯ�й���Ϣ
	 * @return
	 */
	public List<Admin> getAllConnecteMessage(String str) {
		Connection conn = dbManager.getConnection();
		adminDao.setConnection(conn);
		
		List<Admin> list = adminDao.getAllConnecteMessage(str);
		return list;
	}
	
	
	/**
	 * �޸��û���Ϣ
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
	 * ��ȡ�����û���username
	 * @return
	 */
	public String[] getUsername(){
		Connection conn = dbManager.getConnection();
		adminDao.setConnection(conn);
		
		String[] str = adminDao.getUsername();
		return str;
	}
	
	/**
	 * ��ҳ---pageSize��ÿҳ��¼������pageNumber����ǰѡ��ҳ
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
