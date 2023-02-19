package com.rf.common.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.rf.common.dao.CommonDao;
import com.rf.common.db.DBUtils;
import com.rf.common.model.Subparameter;

public class CommonDaoImp implements CommonDao {
	protected DBUtils dbUtils;
	public CommonDaoImp() {
		dbUtils = DBUtils.getInstance();
	}
	@Override
	public void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close(Connection conn, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close(Connection conn, PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int cancleUser(Integer paramUlid,Subparameter paramUlstatus) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int affectRow = 0;
		try {
			conn = dbUtils.getConn();
			StringBuffer sql = new StringBuffer();
			sql.append(" UPDATE ");
			sql.append("       userlogin ");
			sql.append(" SET ");
			sql.append("    ulstatus = ? ");
			sql.append(" WHERE ");
			sql.append("      ulid = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, paramUlstatus.getSparid());
			pstmt.setInt(2, paramUlid);
			affectRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return affectRow;
	}

	@Override
	public int exitSystem(Integer paramUlid,Subparameter paramUlstatus) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int affectRow = 0;
		try {
			conn = dbUtils.getConn();
			StringBuffer sql = new StringBuffer();
			sql.append(" UPDATE ");
			sql.append("       userlogin ");
			sql.append(" SET ");
			sql.append("    ulstatus = ? ");
			sql.append(" WHERE ");
			sql.append("      ulid = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, paramUlstatus.getSparid());
			pstmt.setInt(2, paramUlid);
			affectRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return affectRow;
	}

}
