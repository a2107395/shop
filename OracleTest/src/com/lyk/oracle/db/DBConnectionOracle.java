package com.lyk.oracle.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class DBConnectionOracle {
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConn(){
		String driver="";
		String url="";
		String user="";
		String pwd="";
		InputStream is = DBConnectionOracle.class.getResourceAsStream("/db.properties");
		Properties p = new Properties();
		Connection conn = null;
		
		try {
			p.load(is);
			driver = p.getProperty("driver");
			url = p.getProperty("url");
			user = p.getProperty("user");
			pwd = p.getProperty("pwd");
			//1、加载驱动
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("加载驱动异常");
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("获取连接异常");
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("文件加载异常");
		}
		return conn;
	}
	
	/**
	 * 关闭连接
	 * @param stmt
	 * @param pstmt
	 * @param rs
	 * @param conn
	 */
	public static void closeDB(Statement stmt,PreparedStatement pstmt,ResultSet rs,Connection conn){
		if (stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("关闭stmt异常");
			}
		}
		if(pstmt!=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
