package com.rf.a01.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rf.a01.dao.A0102Dao;
import com.rf.common.dao.imp.CommonDaoImp;
import com.rf.common.session.SessionUser;

public class A0102DaoImp extends CommonDaoImp implements A0102Dao {

	@Override
	public int upDateHeight(float height) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int affectRow = 0;
		try {
			conn = dbUtils.getConn();
			StringBuffer sql = new StringBuffer();
			sql.append(" UPDATE ");
			sql.append("       userinformation ");
			sql.append("    SET ");
			sql.append("       userheight = ? ");
			sql.append("    WHERE ");
			sql.append("       userid = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setFloat(1, height);
			SessionUser data = new SessionUser();
			pstmt.setInt(2, data.userid);
			affectRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return affectRow;
	}

	@Override
	public int upDateWeight(float weight) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int affectRow = 0;
		try {
			conn = dbUtils.getConn();
			StringBuffer sql = new StringBuffer();
			sql.append(" UPDATE ");
			sql.append("       userinformation ");
			sql.append("    SET ");
			sql.append("       userweight = ? ");
			sql.append("    WHERE ");
			sql.append("       userid = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setFloat(1, weight);
			pstmt.setInt(2, SessionUser.userid);
			affectRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return affectRow;
	}

}
