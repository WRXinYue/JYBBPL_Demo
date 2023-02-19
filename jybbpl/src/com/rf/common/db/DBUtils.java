package com.rf.common.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.rf.common.utils.ReadFileUtils;

public class DBUtils {
	private DBUtils() {}
	private static DBUtils dbUtils;
	static {
		dbUtils = new DBUtils();
	}
	public static DBUtils getInstance() {
		return dbUtils;
	}
	public Connection getConn() {
		Connection conn = null; 
		try {
			Class.forName(ReadFileUtils.getDBProperties("jdbc.driverclass"));
			conn = DriverManager.getConnection(
						ReadFileUtils.getDBProperties("jdbc.url")
						,ReadFileUtils.getDBProperties("jdbc.username")
						,ReadFileUtils.getDBProperties("jdbc.password"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public void close(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void close(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void close(PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
