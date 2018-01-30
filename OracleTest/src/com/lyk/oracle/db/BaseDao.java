package com.lyk.oracle.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class BaseDao<G> {
	/**
	 * ִ����ɾ�ķ���
	 * @param sql sql���
	 * @param param sql����е� ����
	 * @return ��Ӱ������
	 */
	public int exeSql(String sql,Object...param){
		int i = 0;
		Connection conn = DBConnectionOracle.getConn();
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			for (int j = 0; j < param.length; j++) {
				pstmt.setObject(j+1, param[j]);
			}
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("sql���ִ���쳣");
		}finally{
			DBConnectionOracle.closeDB(null, pstmt, null, conn);
		}
	
		return i;
	}
	
	/**
	 * ��ѯ�ķ���
	 * @param sql
	 * @param getEntityObj
	 * @param param
	 * @return
	 */
	public ArrayList<G> query(String sql,GetEntity<G> getEntityObj,Object...param){
		
		ArrayList<G> list = new ArrayList<G>();
		Connection conn = DBConnectionOracle.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			for (int j = 0; j < param.length; j++) {
				pstmt.setObject(j+1, param[j]);
			}
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				G g = getEntityObj.getEntity(rs);
				System.out.println("g:"+g);
				list.add(g);
			}
		} catch (SQLException e) {
			System.out.println("sql���ִ���쳣");
			e.printStackTrace();
		}finally{
			DBConnectionOracle.closeDB(null,pstmt, rs, conn);
		}
		return list;
		
	}
	/**
	 * ��ȡ�ܼ�¼����
	 * @param sql
	 * @param param
	 * @return
	 */
	public int getTotal(String sql,Object...param){
		int count = 0;
		ArrayList<G> list = new ArrayList<G>();
		Connection conn = DBConnectionOracle.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int j = 0; j < param.length; j++) {
				pstmt.setObject(j+1, param[j]);
			}
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("sql���ִ���쳣");
			e.printStackTrace();
		} finally{
			DBConnectionOracle.closeDB(null,pstmt, rs, conn);
		}
		return count;
	}

}
