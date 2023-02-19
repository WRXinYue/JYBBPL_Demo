package com.rf.a05.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rf.a05.dao.A0504Dao;
import com.rf.common.dao.imp.CommonDaoImp;
import com.rf.common.db.DBUtils;
import com.rf.common.model.Purview;
import com.rf.common.model.Subparameter;
import com.rf.common.model.Userinformation;
import com.rf.common.model.Userlogin;

public class A0504DaoImp extends CommonDaoImp implements A0504Dao{
	protected DBUtils dbUtils;
	public A0504DaoImp() {
		dbUtils = DBUtils.getInstance();
	}
	@Override
	public Userlogin selectData(Integer paramPid) {
		Userlogin userlogin = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtils.getConn();
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT ");
			sql.append(" 		 ulid, ");
			sql.append(" 		 f_uidtouname(ulid) AS username, ");
			sql.append(" 		 ulpassword, ");
			sql.append(" 		 ulphone, ");
			sql.append(" 		 ulpowerid, ");
			sql.append(" 		 f_ulpoweridtoname(ulpowerid) AS purname, ");
			sql.append(" 		 ulstatus, ");
			sql.append(" 		 f_codetoname(2, ulstatus) AS ulstatusname, ");
			sql.append(" 		 ullosure, ");
			sql.append(" 		 f_codetoname(3, ulstatus) AS ullosurename");
			sql.append(" FROM ");
			sql.append("       userlogin ");
			sql.append(" WHERE ");
			sql.append("      userid = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, paramPid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				userlogin = new Userlogin();
				Userinformation userinformation = new Userinformation();
				Purview purview = new Purview();
				Subparameter subUlstatus = new Subparameter();
				Subparameter subUllosure = new Subparameter();
				userlogin.setUlid(rs.getInt("ulid"));
				userinformation.setUsername(rs.getString("username"));
				userlogin.setUlpassword(rs.getString("ulpassword"));
				userlogin.setUlphone(rs.getString("ulphone"));
				purview.setPurid(rs.getInt("ulpowerid"));
				purview.setPurname(rs.getString("purname"));
				subUlstatus.setSparid(rs.getInt("ulstatus"));
				subUlstatus.setSparname(rs.getString("ulstatusname"));
				subUllosure.setSparid(rs.getInt("ullosure"));
				subUllosure.setSparname(rs.getString("ullosurename"));
				userlogin.setUserid(userinformation);
				userlogin.setUlpowerid(purview);
				userlogin.setUlstatus(subUlstatus);
				userlogin.setUllosure(subUllosure);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return userlogin;
	}
//	@Override
//	public int selectCountRow(Integer paramPid) {
//		int countRow = 0;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = dbUtils.getConn();
//			StringBuffer sql = new StringBuffer();
//			sql.append(" SELECT ");
//			sql.append(" 		 COUNT(userid) userid ");
//			sql.append(" FROM ");
//			sql.append("       userlogin ");
//			sql.append(" WHERE ");
//			sql.append("      userid = ? ");
//			pstmt = conn.prepareStatement(sql.toString());
//			pstmt.setInt(1, paramPid);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				countRow = rs.getInt("userid");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(conn, pstmt, rs);
//		}
//		return countRow;
//	}
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
			sql.append("       userlogin ");
			sql.append("    WHERE ");
			sql.append("       userid = ? ");
//			sql.append(" DELETE ");
//			sql.append("    FROM ");
//			sql.append("       userinformation ");
//			sql.append("    WHERE ");
//			sql.append("       userid = ? ;");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, paramPid);
//			pstmt.setInt(2, paramPid);
			affectRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return affectRow;
	}
}
