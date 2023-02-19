package com.rf.a05.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rf.a05.dao.A0508Dao;
import com.rf.common.dao.imp.CommonDaoImp;
import com.rf.common.db.DBUtils;
import com.rf.common.model.Purview;
import com.rf.common.model.Subparameter;
import com.rf.common.model.Userinformation;
import com.rf.common.model.Userlogin;
import com.rf.common.utils.CommonUtils;

public class A0508DaoImp extends CommonDaoImp implements A0508Dao{
	protected DBUtils dbUtils;
	public A0508DaoImp() {
		dbUtils = DBUtils.getInstance();
	}
	@Override
	public int updateData(int paramPid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int affectRow = 0;
		conn = dbUtils.getConn();
		StringBuffer sql = new StringBuffer();
		sql.append(" UPDATE ");
		sql.append("       userlogin ");
		sql.append("    SET ");
		sql.append("       ulpassword = ? ");
		sql.append("    WHERE ");
		sql.append("       userid = ? ");
		try {
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, CommonUtils.encryption("123456"));
			pstmt.setInt(2, paramPid);
			affectRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return affectRow;
	}
	@Override
	public Userlogin selectData(Integer paraId) {
		Userlogin userlogin = null;
		Connection conn = null;
		PreparedStatement pstmt  = null;
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
			sql.append(" 		 f_codetoname(3, ullosure) AS ullosurename ");
			sql.append(" FROM ");
			sql.append("       userlogin ");
			sql.append(" WHERE ");
			sql.append("      ulid = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, paraId);
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
}
