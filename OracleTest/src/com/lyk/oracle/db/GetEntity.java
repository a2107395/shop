package com.lyk.oracle.db;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ����һ���ӿڡ���ȡ��ѯ��ʵ��
 * @author mi
 *
 * @param <G>
 */
public interface GetEntity<G> {
	G getEntity(ResultSet rs) throws SQLException ;
}
