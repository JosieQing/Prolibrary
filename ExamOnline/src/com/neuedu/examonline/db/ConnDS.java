package com.neuedu.examonline.db;

import java.sql.Connection;

public interface ConnDS {
	
	public Connection getConn();
	
	public void initDataSource();

}
