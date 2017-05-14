package com.neusoft.dao.impl;

import java.sql.Connection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.neusoft.db.JdbcTemplate;
import com.neusoft.mapping.MappingFactory;


/**
 * @author zhangjun 2013-7-30 下午06:11:40 共有的DAO类，所有的DAO都必须继承与它
 */
public class BaseDAO {

	protected JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();// JDBC模板
	protected MappingFactory mappingFactory = MappingFactory.getMappingFactory();// mapping工厂实例
	protected Log logger = LogFactory.getLog("DAOLogger");

	/**
	 * 注入数据库连接类
	 * 
	 * @param connection
	 */
	public void setConnection(Connection connection) {
		jdbcTemplate.setConnection(connection);
	}
}
