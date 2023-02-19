package com.rf.a04.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rf.a02.dao.A0202Dao;
import com.rf.common.dao.imp.CommonDaoImp;
import com.rf.common.db.DBUtils;
import com.rf.common.model.Project;

public class A0202DaoImp extends CommonDaoImp implements A0202Dao {
	protected DBUtils dbUtils;
	public A0202DaoImp() {
		dbUtils = DBUtils.getInstance();
	}
	@Override
	public int updateData(Project paramData) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int affectRow = 0;
		try {
			conn = dbUtils.getConn();
			StringBuffer sql = new StringBuffer();
			sql.append(" UPDATE ");
			sql.append("       project ");
			sql.append("    SET ");
			sql.append("       pname = ? ");
			sql.append("    WHERE ");
			sql.append("       pid = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, paramData.getPname());
			pstmt.setInt(2, paramData.getPid());
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

}
