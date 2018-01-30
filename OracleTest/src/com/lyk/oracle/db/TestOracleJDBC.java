package com.lyk.oracle.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestOracleJDBC {
	
	public static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	public static final String URL="jdbc:oracle:thin:@localhost:1521:oracle";
	public static final String USER="LYK";
	public static final String PWD="123456";
	
	
	public static void main(String[] args)
	{
		Connection conn = null;
		PreparedStatement ps = null;
//		String sql = "insert into userinfo values(1,'admin','123456','��ע')";
		String sql = "select * from userinfo";
//		String sql = "delete from emp where sal > 8000";
//		String sql = "update emp set sal = 8899 where ENAME = '����'";
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USER,PWD);
			conn.setAutoCommit(false);
			query(conn, sql);
//			add(conn,sql);
//			del(conn,sql);
//			update(conn,sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ʧ�ܣ�");
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			System.out.println("ʧ�ܣ�");
		}
	}
	
	/**
	 * �޸�
	 * @param conn
	 * @param sql
	 * @throws SQLException
	 */
	public static void update(Connection conn,String sql)throws SQLException
	{
		PreparedStatement ps = conn.prepareStatement(sql);
		if(ps.executeUpdate()> 0){
			System.out.println("�޸ĳɹ���");
		}
	}
	/**
	 * ɾ��
	 * @param conn
	 * @param sql
	 * @throws SQLException
	 */
	public static void del(Connection conn,String sql)throws SQLException
	{
		PreparedStatement ps = conn.prepareStatement(sql);
		if(ps.executeUpdate()> 0){
			System.out.println("ɾ���ɹ���");
		}
	}
	/**
	 * ����
	 * @param conn
	 * @param sql
	 * @throws SQLException
	 */
	public static void add(Connection conn,String sql)throws SQLException
	{
		PreparedStatement ps = conn.prepareStatement(sql);
		if(ps.executeUpdate()> 0){
			System.out.println("�����ɹ���");
		}
	}
	/**
	 * ��ѯ
	 * @param conn
	 * @param sql
	 * @throws SQLException
	 */
	public static void query(Connection conn,String sql) throws SQLException
	{
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		
		  String username = null;
          String userpwd = null;
		  while(rs.next()){
                //��ȡstuname��������
			  username = rs.getString("username");
                //��ȡstuid��������
			  userpwd = rs.getString("userpwd");
                //������
                System.out.println(username + "\t" + userpwd);
            }
	}
	
}
