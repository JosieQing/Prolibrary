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
	 * 验证登陆
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
	 * 增加员工信息
	 */

	public boolean addAdmin(Admin admin) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO Admin VALUES(NB_SEQ.nextval,?,?)";
		int row = jdbcTemplate.update(sql, admin.getUsername(),admin.getPassword());
		return row == 1;
		
	}
	
	/**
	 * 通过ID获得员工信息
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
	 * 通过ID删除员工信息
	 */
	
	public boolean deleteAdminById(int id) throws SQLException,
			ClassNotFoundException {
		String sql = "DELETE Admin WHERE ID = ?";
		int row = jdbcTemplate.update(sql, id);
		
		return row == 1;
		
	}
	
	/**
	 * 查询所有员工信息
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
	 * 修改用户信息
	 */
	
	public boolean upDate(Admin admin,int id){
		String sql = "UPDATE Admin SET USERNAME = ?,PASSWORD = ? WHERE ID = ?";
		
		int row = jdbcTemplate.update(sql,admin.getUsername(),admin.getPassword(),id);
		return row == 1;
	}

	
	/**
	 * 根据模糊username查询有关信息
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
	 * 获取所有用户的username
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
	 * 分页---pageSize：每页记录条数；pageNumber：当前选择页
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
//	 * 增加用户
//	 * @throws ClassNotFoundException 
//	 */
//	@Override
//	public void addUser(Users user) throws SQLException, ClassNotFoundException{
//		//sql:insert into table values (?,?,?,?);
//		//连接数据库
//		dbu.connect();
//		//调用upDateMessage(String sql,Object...values)方法，添加信息
//		//insert into users values(NB_SEQ.nextval,?,?)
//		int i =dbu.upDateMessage("insert into users values(NB_SEQ.nextval,?,?)" ,user.getUsername(),user.getPassword());
//		if(i!=0){
//			System.out.println("add user success......");
//		}
//
//	}
//	
//	public static void main(String[] args) {
//		//添加信息
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
//		//根据ID查询信息
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
//		//根据ID删除信息
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
//		//查询所有员工信息
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
//	 * 根据ID查询员工信息
//	 * 
//	 * @param id
//	 * @return
//	 * @throws ClassNotFoundException 
//	 */
//	@Override
//	public Users getUserById(int id) throws SQLException, ClassNotFoundException{
//		//连接数据库
//		dbu.connect();
//		//调用getMessage(String sql,Object...values)方法，根据ID查询信息
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
//	 * 根据ID删除用户
//	 * 
//	 * @param id
//	 * @throws ClassNotFoundException 
//	 */
//	@Override
//	public void deleteUserById(int id) throws SQLException, ClassNotFoundException{
//		//连接数据库
//		dbu.connect();
//		//调用upDateMessage(String sql,Object...values)方法，添加信息
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
//	 * 查询所有用户信息
//	 * @return
//	 * @throws ClassNotFoundException 
//	 */
//	@Override
//	public Users[] getAllUserMessage() throws SQLException, ClassNotFoundException{
//		//连接数据库
//		dbu.connect();
//		//调用getMessage(String sql,Object...values)方法，查询所有信息
//		ResultSet rs = dbu.getMessage("select * from users");
//		while(rs.next()){
//			System.out.println(rs.getInt("id")+"--"+rs.getString("username")+"--"+rs.getString("password"));
//		}
//		return null;
//	}
	
//	/**
//	 * 增加员工信息
//	 */
//	@Override
//	public boolean addUser(Users user) throws SQLException, ClassNotFoundException {
//		//连接数据库
//		DBManager dbManager = DBManager.getInstance();
//		Connection conn = dbManager.getConnection();
//		//2.执行模板JdbcTemplet中的查询方法
//		JdbcTemplate jt = JdbcTemplate.getInstance();
//		jt.setConnection(conn);
//		String sql = "insert into users values(NB_SEQ.nextval,?,?)";
//		int row = jt.update(sql,"Tom","tom123");
//		return row == 1;
//		
//		
//	}
	

}
