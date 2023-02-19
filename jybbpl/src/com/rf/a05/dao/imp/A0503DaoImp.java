package com.rf.a05.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rf.a05.dao.A0503Dao;
import com.rf.common.dao.imp.CommonDaoImp;
import com.rf.common.db.DBUtils;
import com.rf.common.model.Purview;
import com.rf.common.model.Subparameter;
import com.rf.common.model.Userinformation;
import com.rf.common.model.Userlogin;

public class A0503DaoImp extends CommonDaoImp implements A0503Dao{
	protected DBUtils dbUtils;
	public A0503DaoImp() {
		dbUtils = DBUtils.getInstance();
	}
	@Override
	public List<Userlogin> selectById(Integer paraId) {
		List<Userlogin> dataList = new ArrayList<Userlogin>();
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
				Userlogin userlogin = new Userlogin();
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
				dataList.add(userlogin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return dataList;
	}
	@Override
	public List<Userlogin> selectByName(String paraName) {
		List<Userlogin> dataList = new ArrayList<Userlogin>();
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
			sql.append("        userid LIKE ( ");
			sql.append("						SELECT ");
			sql.append("                              userid ");
			sql.append(" 						FROM ");
			sql.append("                              userinformation ");
			sql.append(" 					    WHERE ");
			sql.append("                              username LIKE ? ");
			sql.append(" 					  ) ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + paraName + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Userlogin userlogin = new Userlogin();
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
				dataList.add(userlogin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return dataList;
	}
	@Override
	public List<Userlogin> selectByPhone(String paraPhone) {
		List<Userlogin> dataList = new ArrayList<Userlogin>();
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
			sql.append("      ulphone LIKE ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + paraPhone + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Userlogin userlogin = new Userlogin();
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
				dataList.add(userlogin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return dataList;
	}
	@Override
	public List<Userlogin> selectAll() {
		List<Userlogin> dataList = new ArrayList<Userlogin>();
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
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Userlogin userlogin = new Userlogin();
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
				dataList.add(userlogin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return dataList;
	}
}
