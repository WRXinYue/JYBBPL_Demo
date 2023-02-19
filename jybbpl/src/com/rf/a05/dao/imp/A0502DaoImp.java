package com.rf.a05.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rf.a05.dao.A0502Dao;
import com.rf.common.dao.imp.CommonDaoImp;
import com.rf.common.db.DBUtils;
import com.rf.common.model.Userinformation;
import com.rf.common.model.Userlogin;
import com.rf.common.utils.CommonUtils;

public class A0502DaoImp extends CommonDaoImp implements A0502Dao{
	protected DBUtils dbUtils;
	public A0502DaoImp() {
		dbUtils = DBUtils.getInstance();
	}
	@Override
	public Userlogin selectData(Integer paramPid) {
		Userlogin data = null;
		Userinformation data2 = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtils.getConn();
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT ");
			sql.append(" 		 userid, ");
			sql.append(" 		 f_uidtouname(userid) AS username ");
			sql.append(" FROM ");
			sql.append("       userlogin ");
			sql.append(" WHERE ");
			sql.append("      userid = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, paramPid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				data = new Userlogin();
				data2 = new Userinformation();
				data.setUlid(rs.getInt("userid"));
				data2.setUsername(rs.getString("username"));
				data.setUserid(data2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}
	@Override
	public int updateData(Userlogin paramData, int parameter) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int affectRow = 0;
		conn = dbUtils.getConn();
		StringBuffer sql = new StringBuffer();
		if (parameter == 1) {
			sql.append(" UPDATE ");
			sql.append("       userinformation ");
			sql.append("    SET ");
			sql.append("       username = ? ");
			sql.append("    WHERE ");
			sql.append("       userid = ? ");
		} else if (parameter == 2) {
			sql.append(" UPDATE ");
			sql.append("       userlogin ");
			sql.append("    SET ");
			sql.append("       ulpassword = ? ");
			sql.append("    WHERE ");
			sql.append("       userid = ? ");
		} else if (parameter == 3) {
			sql.append(" UPDATE ");
			sql.append("       userlogin ");
			sql.append("    SET ");
			sql.append("       ulphone = ? ");
			sql.append("    WHERE ");
			sql.append("       userid = ? ");
		} else if (parameter == 4) {
			sql.append(" UPDATE ");
			sql.append("       userlogin ");
			sql.append("    SET ");
			sql.append("       ulpowerid = ? ");
			sql.append("    WHERE ");
			sql.append("       userid = ? ");
		}
		try {
			pstmt = conn.prepareStatement(sql.toString());
			if (parameter == 1) {
				pstmt.setString(1, paramData.getUserid().getUsername());
			} else if (parameter == 2) {
				pstmt.setString(1, CommonUtils.encryption(paramData.getUlpassword()));
			} else if (parameter == 3) {
				pstmt.setString(1, paramData.getUlphone());
			} else if (parameter == 4) {
				pstmt.setInt(1, paramData.getUlpowerid().getPurid());
			}
			pstmt.setInt(2, paramData.getUlid());
			affectRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return affectRow;
	}
}
