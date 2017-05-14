package com.neuedu.examonline.db;

import java.sql.Connection;

public class ConnectionFactory{

	private String type="jdbc";
	
	public ConnectionFactory(){
		
	}
	
	public ConnectionFactory(String type){
		this.type = type;
	}
	
	private Connection create(String type){
		ConnDS conn = null;
		if("jdbc".equals(type)){
			conn = new ConnJdbcDS();
		}else if("c3p0".equals(type)){
			conn = new ConnC3p0DS();
		}
		return conn.getConn();
	}
	
	public Connection get(){
		return create(this.type);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
