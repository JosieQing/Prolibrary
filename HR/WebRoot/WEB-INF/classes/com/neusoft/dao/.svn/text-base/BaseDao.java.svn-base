package com.neusoft.dao;

import java.sql.Connection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.neusoft.db.JdbcTemplate;
import com.neusoft.mapping.MappingFactory;

public class BaseDao {
	protected JdbcTemplate jdbcTemplate=JdbcTemplate.getInstance();
	protected MappingFactory mappingFactory=MappingFactory.getMappingFactory();

	protected Log logger=LogFactory.getLog("DAOLogger");
	/**
	 * ע����ݿ����е�l��
	 */
	public void setConnection(Connection connection){
		jdbcTemplate.setConnection(connection);
	}



}
