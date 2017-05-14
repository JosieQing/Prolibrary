package com.neusoft.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.bean.Admin;
import com.neusoft.dao.AdminDao;
import com.neusoft.mapping.EntityMapping;
import com.neusoft.util.OraclePagination;
import com.neusoft.util.Pagination;

public  class AdminDaoImpl extends BaseDAO implements AdminDao {
	
	/**
	 * ��֤��½
	 */
	public Admin isCheckLogin(String username,String password)throws SQLException, ClassNotFoundException {
		
		String sql = "SELECT * FROM Admin WHERE USERNAME = ? AND PASSWORD = ?";
		EntityMapping mapping = mappingFactory.getMapping(mappingFactory.Admin_MAPPING);
		List<Object> list = jdbcTemplate.query(sql, mapping, username,password);
		if(list.size()>0){
			return (Admin) list.get(0);
		}else{
			return null;
		}
	}
//	
//	public static void main(String[] args) {
//		AdminDaoImpl a = new AdminDaoImpl();
//		try {
//			Admin admin = a.isCheckLogin("admin", "123");
//			System.out.println(admin.getUsername()+"---"+admin.getPassword()+"--"+admin.getId());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	/**
	 * ����Ա����Ϣ
	 */

	public boolean addAdmin(Admin admin) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO Admin VALUES(NB_SEQ.nextval,?,?)";
		int row = jdbcTemplate.update(sql, admin.getUsername(),admin.getPassword());
		return row == 1;
		
	}
	
	/**
	 * ͨ��ID���Ա����Ϣ
	 */
	
	public Admin getAdminById(int id) throws SQLException,
			ClassNotFoundException {
		String sql = "SELECT * FROM Admin WHERE ID = ?";
		EntityMapping mapping = mappingFactory.getMapping(mappingFactory.Admin_MAPPING);
		List<Object> list = jdbcTemplate.query(sql, mapping, id);
		
		if(list.size()>0){
			return (Admin)list.get(0);
		}else{
			return null;
		}
		
	}
	
	
	/**
	 * ͨ��IDɾ��Ա����Ϣ
	 */
	
	public boolean deleteAdminById(int id) throws SQLException,
			ClassNotFoundException {
		String sql = "DELETE Admin WHERE ID = ?";
		int row = jdbcTemplate.update(sql, id);
		
		return row == 1;
		
	}
	
	/**
	 * ��ѯ����Ա����Ϣ
	 */
	
	public List<Admin> getAllAdminMessage() throws SQLException,ClassNotFoundException {
		
		String sql = "SELECT * FROM Admin";
		EntityMapping mapping = mappingFactory.getMapping(mappingFactory.Admin_MAPPING);
		List<Object> list = jdbcTemplate.query(sql, mapping);
		List<Admin> lists = new ArrayList<Admin>();
		for (int i = 0; i < list.size(); i++) {
			Admin admin =(Admin) list.get(i);
			lists.add(admin);
		} 
		return lists;
	}
	
	/**
	 * �޸��û���Ϣ
	 */
	
	public boolean upDate(Admin admin,int id){
		String sql = "UPDATE Admin SET USERNAME = ?,PASSWORD = ? WHERE ID = ?";
		
		int row = jdbcTemplate.update(sql,admin.getUsername(),admin.getPassword(),id);
		return row == 1;
	}

	
	/**
	 * ����ģ��username��ѯ�й���Ϣ
	 * @return
	 */
	public List<Admin> getAllConnecteMessage(String str) {
		
		String sql = "SELECT * FROM Admin WHERE USERNAME LIKE  ? ";
		EntityMapping mapping = mappingFactory.getMapping(mappingFactory.Admin_MAPPING);
		List<Object> list = jdbcTemplate.query(sql, mapping,"%"+str+"%");
		List<Admin> lists = new ArrayList<Admin>();
		for (int i = 0; i < list.size(); i++) {
			Admin admin =(Admin) list.get(i);
			lists.add(admin);
		}
		return lists;
	}
	
	/**
	 * ��ȡ�����û���username
	 * @return
	 */
	public String[] getUsername() {
		
		String sql = "SELECT USERNAME FROM Admin";
		EntityMapping mapping = mappingFactory.getMapping(mappingFactory.Admin_MAPPING);
		List<Object> list = jdbcTemplate.query(sql, mapping);
		List<Admin> lists = new ArrayList<Admin>();
		for (int i = 0; i < list.size(); i++) {
			Admin admin =(Admin) list.get(i);
			lists.add(admin);
		} 
		String[] str = new String[lists.size()];
		for (int i = 0; i < lists.size(); i++) {
			Admin admin = lists.get(i);
			str[i] = admin.getUsername();
		}
		return str;
	}
	
	/**
	 * ��ҳ---pageSize��ÿҳ��¼������pageNumber����ǰѡ��ҳ
	 */
	public Pagination getAdminByPage(int pageSize, int pageNumber)
			throws SQLException {
		String sql = "select * from Admin order by id";
		Pagination p = new OraclePagination(sql,pageSize,pageNumber);
		return p;
	}

	
//	private DBUtil dbu;
//	
//	public UserDaoImpl(){
//		
//		dbu = new DBUtil();
//	}
//	
//	/**
//	 * �����û�
//	 * @throws ClassNotFoundException 
//	 */
//	@Override
//	public void addUser(Users user) throws SQLException, ClassNotFoundException{
//		//sql:insert into table values (?,?,?,?);
//		//�������ݿ�
//		dbu.connect();
//		//����upDateMessage(String sql,Object...values)�����������Ϣ
//		//insert into users values(NB_SEQ.nextval,?,?)
//		int i =dbu.upDateMessage("insert into users values(NB_SEQ.nextval,?,?)" ,user.getUsername(),user.getPassword());
//		if(i!=0){
//			System.out.println("add user success......");
//		}
//
//	}
//	
//	public static void main(String[] args) {
//		//�����Ϣ
//		
//		Users user = new Users("Lily","lily123");
//		UserDaoImpl udi = new UserDaoImpl();
//		try {
//			udi.addUser(user);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		//����ID��ѯ��Ϣ
//		
//		UserDaoImpl udi = new UserDaoImpl();
//		try {
//			udi.getUserById(6);
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			
//			e.printStackTrace();
//		}
//		
//		//����IDɾ����Ϣ
//		
//		UserDaoImpl udi = new UserDaoImpl();
//		
//		try {
//			udi.deleteUserById(11);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		//��ѯ����Ա����Ϣ
//	
//		UserDaoImpl udi = new UserDaoImpl();
//		try {
//			udi.getAllUserMessage();
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	
//		 
//	}
//	
//	
//	/**
//	 * ����ID��ѯԱ����Ϣ
//	 * 
//	 * @param id
//	 * @return
//	 * @throws ClassNotFoundException 
//	 */
//	@Override
//	public Users getUserById(int id) throws SQLException, ClassNotFoundException{
//		//�������ݿ�
//		dbu.connect();
//		//����getMessage(String sql,Object...values)����������ID��ѯ��Ϣ
//		ResultSet rs = dbu.getMessage("select * from users where id = ?", id);
//		
//		if(rs.next()){
//			
//			System.out.println(rs.getInt("id")+"--"+rs.getString("username")+"--"+rs.getString("password"));
//		}
//		return null;
//	}
//	
//	
//	/**
//	 * ����IDɾ���û�
//	 * 
//	 * @param id
//	 * @throws ClassNotFoundException 
//	 */
//	@Override
//	public void deleteUserById(int id) throws SQLException, ClassNotFoundException{
//		//�������ݿ�
//		dbu.connect();
//		//����upDateMessage(String sql,Object...values)�����������Ϣ
//		//insert into users values(NB_SEQ.nextval,?,?)
//		int i =dbu.upDateMessage("delete users where id = ?" ,id);
//		if(i!=0){
//			System.out.println("delete user success......");
//		}
//
//	}
//	
//
//	/**
//	 * ��ѯ�����û���Ϣ
//	 * @return
//	 * @throws ClassNotFoundException 
//	 */
//	@Override
//	public Users[] getAllUserMessage() throws SQLException, ClassNotFoundException{
//		//�������ݿ�
//		dbu.connect();
//		//����getMessage(String sql,Object...values)��������ѯ������Ϣ
//		ResultSet rs = dbu.getMessage("select * from users");
//		while(rs.next()){
//			System.out.println(rs.getInt("id")+"--"+rs.getString("username")+"--"+rs.getString("password"));
//		}
//		return null;
//	}
	
//	/**
//	 * ����Ա����Ϣ
//	 */
//	@Override
//	public boolean addUser(Users user) throws SQLException, ClassNotFoundException {
//		//�������ݿ�
//		DBManager dbManager = DBManager.getInstance();
//		Connection conn = dbManager.getConnection();
//		//2.ִ��ģ��JdbcTemplet�еĲ�ѯ����
//		JdbcTemplate jt = JdbcTemplate.getInstance();
//		jt.setConnection(conn);
//		String sql = "insert into users values(NB_SEQ.nextval,?,?)";
//		int row = jt.update(sql,"Tom","tom123");
//		return row == 1;
//		
//		
//	}
	

}
