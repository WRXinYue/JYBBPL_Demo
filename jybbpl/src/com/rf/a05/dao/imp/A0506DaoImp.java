package com.rf.a05.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rf.a05.dao.A0506Dao;
import com.rf.common.dao.imp.CommonDaoImp;
import com.rf.common.db.DBUtils;
import com.rf.common.model.Purview;
import com.rf.common.model.Subparameter;
import com.rf.common.model.Userinformation;
import com.rf.common.model.Userlogin;

public class A0506DaoImp extends CommonDaoImp implements A0506Dao{
	protected DBUtils dbUtils;
	public A0506DaoImp() {
		dbUtils = DBUtils.getInstance();
	}
	@Override
	public int updateData(int paramPid, int parameter) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int affectRow = 0;
		conn = dbUtils.getConn();
		StringBuffer sql = new StringBuffer();
		/**
		 * 1 : 授权管理员
		 * 2 : 授权教练
		 * 3 : 授权vip
		 * 4 : 重置普通用户
		 */
		if (parameter == 1) {
			sql.append(" UPDATE ");
			sql.append("       userlogin ");
			sql.append("    SET ");
			sql.append("       ulpowerid = 1 ");
			sql.append("    WHERE ");
			sql.append("       userid = ? ");
		} else if (parameter == 2) {
			sql.append(" UPDATE ");
			sql.append("       userlogin ");
			sql.append("    SET ");
			sql.append("       ulpowerid = 3 ");
			sql.append("    WHERE ");
			sql.append("       userid = ? ");
		} else if (parameter == 3) {
			sql.append(" UPDATE ");
			sql.append("       userlogin ");
			sql.append("    SET ");
			sql.append("       ulpowerid = 5 ");
			sql.append("    WHERE ");
			sql.append("       userid = ? ");
		} else if (parameter == 4) {
			sql.append(" UPDATE ");
			sql.append("       userlogin ");
			sql.append("    SET ");
			sql.append("       ulpowerid = 2 ");
			sql.append("    WHERE ");
			sql.append("       userid = ? ");
		}
		try {
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
