package com.pfc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
	private String driver;
	private String url;
	private String loginuser;
	private String pwd;
	private static JDBCUtil instance = new JDBCUtil();
	private JDBCUtil(){
		InputStream in = JDBCUtil.class.getClassLoader().getResourceAsStream("../properties/dbinfo.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			loginuser = prop.getProperty("username");
			pwd = prop.getProperty("password");			
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static JDBCUtil getInstance(){
		return instance;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public  String getDriver() {
		return driver;
	}
	public String getLoginuser() {
		return loginuser;
	}
	public String getPwd() {
		return pwd;
	}
	public static Connection getConnection(){
		
		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Class.forName(instance.getDriver());
			return DriverManager.getConnection(instance.getUrl(),instance.getLoginuser(),instance.getPwd());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
	public static void free(ResultSet rs,PreparedStatement ps,Connection conn){
		if(rs != null ){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					if(ps != null)
						ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					try {
						if(conn != null)
							conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
			
		
	}
}
