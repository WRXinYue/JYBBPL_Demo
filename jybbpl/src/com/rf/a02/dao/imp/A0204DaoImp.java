package com.rf.a02.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rf.a02.dao.A0204Dao;
import com.rf.common.dao.imp.CommonDaoImp;
import com.rf.common.db.DBUtils;
import com.rf.common.model.Project;

public class A0204DaoImp extends CommonDaoImp implements A0204Dao {
	protected DBUtils dbUtils;
	public A0204DaoImp() {
		dbUtils = DBUtils.getInstance();
	}
	@Override
	public int deleteData(Integer paramPid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int affectRow = 0;
		try {
			conn = dbUtils.getConn();
			StringBuffer sql = new StringBuffer();
			sql.append(" DELETE ");
			sql.append("    FROM ");
			sql.append("       project ");
			sql.append("    WHERE ");
			sql.append("       pid = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, paramPid);
			affectRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return affectRow;
	}
	@Override
	public Project selectData(Integer paramPid) {
		Project data = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtils.getConn();
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT ");
			sql.append(" 		 pid ");
			sql.append(" 		 ,pname ");
			sql.append(" FROM ");
			sql.append("       project ");
			sql.append(" WHERE ");
			sql.append("      pid = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, paramPid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				data = new Project();
				data.setPid(rs.getInt("pid"));
				data.setPname(rs.getString("pname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt,rs);
		}
		return data;
	}
	@Override
	public int selectCountRow(Integer paramPid) {
		int countRow = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtils.getConn();
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT ");
			sql.append(" 		 COUNT(pid) ts ");
			sql.append(" FROM ");
			sql.append("       course ");
			sql.append(" WHERE ");
			sql.append("      pid = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, paramPid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				countRow = rs.getInt("ts");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt,rs);
		}
		return countRow;
	}
}
