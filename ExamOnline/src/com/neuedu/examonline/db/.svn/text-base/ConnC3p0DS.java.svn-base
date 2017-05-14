package com.neuedu.examonline.db;

//import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.util.Properties;

public class ConnC3p0DS implements ConnDS{
	
	private ComboPooledDataSource cpds = new ComboPooledDataSource();
	
	public ConnC3p0DS(){
		initDataSource();
	}
	
    public Connection getConn() {
    	Connection conn = null;
        try {
            if (null != cpds) {
            	conn = cpds.getConnection(); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }  
        return conn;
    }
    
    public void initDataSource(){
    	try {
        	Properties prop = new Properties();
        	InputStream fis	= ConnC3p0DS.class.getResourceAsStream("/dataSource.properties");
        	//FileInputStream fis = new FileInputStream("dataSource.properties");
        	prop.load(fis);
        	cpds.setUser(prop.getProperty("user"));
        	cpds.setPassword(prop.getProperty("password"));
        	cpds.setDriverClass(prop.getProperty("driverClass"));
        	cpds.setJdbcUrl(prop.getProperty("jdbcUrl"));
        	cpds.setInitialPoolSize(Integer.parseInt(prop.getProperty("initialPoolSize")));
        	cpds.setMinPoolSize(Integer.parseInt(prop.getProperty("minPoolSize")));
        	cpds.setMaxPoolSize(Integer.parseInt(prop.getProperty("maxPoolSize")));
        	cpds.setMaxStatements(Integer.parseInt(prop.getProperty("maxStatements")));
        	cpds.setMaxIdleTime(Integer.parseInt(prop.getProperty("maxIdleTime")));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
}
