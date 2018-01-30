package com.lyk.oracle.db;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 定义一个接口。获取查询的实体
 * @author mi
 *
 * @param <G>
 */
public interface GetEntity<G> {
	G getEntity(ResultSet rs) throws SQLException ;
}
