package com.neusoft.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.neusoft.util.PropertyUtil;



/**
 * @author zhangjun
 * 2013-8-2 下午05:43:26
 * 管理数据库连接
 */
public class DBManager {
	
	private Properties prop;
	private String path = "src/datainfo.properties";
	private PropertyUtil propertyUtil;
	private static DBManager dbManager = null;
	private Log logger = LogFactory.getLog(DBManager.class);
	
	private DBManager(){
	}
	
	public static DBManager getInstance() {
		if (dbManager == null) {
			dbManager = new DBManager();
		}
		return dbManager;
	}

	/**
	 * @return
	 * 与数据库进行连接
	 */
	public Connection getConnection() {
		if (propertyUtil == null) {
			propertyUtil = PropertyUtil.getInstance();
			if (prop == null) {
				prop = propertyUtil.getProperty(path);
				if (logger.isInfoEnabled()) {
					logger.info("读取数据库配置文件：	" + path);
				}
			}
		}
		Connection conn = null;
		try {
			Class.forName(prop.getProperty("DRIVER"));
			conn = DriverManager.getConnection(prop.getProperty("DBURL")+prop.getProperty("DBNAME"),prop.getProperty("USERNAME"),prop.getProperty("USERPWD"));
			conn.setAutoCommit(false);//先这样简单自动提交，以后再业务层管理事务，就需要设置为false了
			if (logger.isInfoEnabled()) {
				logger.info("读取数据库配置文件成功！");
			}
		} catch (ClassNotFoundException e) {
			if (logger.isErrorEnabled()) {
				logger.error("找不到数据库驱动！");
			}
		} catch (SQLException e) {
			if (logger.isErrorEnabled()) {
				logger.error("连接失败！");
			}
		}
		return conn;
	}

}

