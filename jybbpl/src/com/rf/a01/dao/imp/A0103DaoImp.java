package com.rf.a01.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rf.a01.dao.A0103Dao;
import com.rf.common.dao.imp.CommonDaoImp;
import com.rf.common.model.Userlogin;
import com.rf.common.session.SessionUser;

public class A0103DaoImp extends CommonDaoImp implements A0103Dao {

	@Override
	public int upDatePassword(Userlogin userPassword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int affectRow = 0;
		try {
			conn = dbUtils.getConn();
			StringBuffer sql = new StringBuffer();
			sql.append(" UPDATE ");
			sql.append("       userlogin ");
			sql.append("    SET ");
			sql.append("       ulpassword = ? ");
			sql.append("    WHERE ");
			sql.append("       userid = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userPassword.getUlpassword());
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
