package com.neuedu.examonline.report.chart;
import java.sql.*;

public class DB {
	private static final String driver="oracle.jdbc.driver.OracleDriver";
	private static final String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String dbname="scott";
	private static final String dbpasswd="tiger";
    private static Connection conn;
    public static Connection opendb() throws ClassNotFoundException,SQLException
    {
    	Class.forName(driver);
    	conn=DriverManager.getConnection(url,dbname,dbpasswd);
    	return conn;
    }
    public static void closedb(Connection conn,Statement st,ResultSet rs)
    throws SQLException
    {
    	if(conn!=null){
    		if(st!=null){
    			if(rs!=null){
    				try{
    					rs.close();
    				}catch(SQLException e){
    					e.printStackTrace();
    				}
    			}
    			try{
					st.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
    		}
    		try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
    	}
    }
    public static void closedb(Connection conn,Statement st){
    	if(conn!=null){
    		if(st!=null){
    			try{
					st.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
    		}
    		try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
    	}
    }
}
