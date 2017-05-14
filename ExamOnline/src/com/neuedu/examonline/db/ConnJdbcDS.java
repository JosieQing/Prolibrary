package com.neuedu.examonline.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnJdbcDS implements ConnDS{
	
	private String user = null;
	private String password=null;
	private String driverClass =null;
	private String jdbcUrl=null;

	public ConnJdbcDS(){
		initDataSource();
	}

    public Connection getConn() {
    	Connection conn = null;
        try {
        	Class.forName(driverClass);
        	conn = DriverManager.getConnection(jdbcUrl,user,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

	public void initDataSource() {
		try {
	    	Properties prop = new Properties();
	    	InputStream fis	= ConnJdbcDS.class.getResourceAsStream("/dataSource.properties");
	    	prop.load(fis);
	    	user = prop.getProperty("user");
	    	password=prop.getProperty("password");
	    	driverClass = prop.getProperty("driverClass");
	    	jdbcUrl=prop.getProperty("jdbcUrl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    

    
}
