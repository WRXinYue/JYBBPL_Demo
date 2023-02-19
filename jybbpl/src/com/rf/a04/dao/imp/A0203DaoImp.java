package com.rf.a04.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rf.a02.dao.A0203Dao;
import com.rf.common.dao.imp.CommonDaoImp;
import com.rf.common.db.DBUtils;
import com.rf.common.model.Project;

public class A0203DaoImp extends CommonDaoImp implements A0203Dao {
	protected DBUtils dbUtils;
	public A0203DaoImp() {
		dbUtils = DBUtils.getInstance();
	}
	@Override
	public List<Project> selectById(Integer paramPid) {
		List<Project> dataList = new ArrayList<Project>();
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
				Project data = new Project();
				data.setPid(rs.getInt("pid"));
				data.setPname(rs.getString("pname"));
				dataList.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt,rs);
		}
		return dataList;
	}
	@Override
	public List<Project> selectByName(String paramPname) {
		List<Project> dataList = new ArrayList<Project>();
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
			sql.append("      pname like ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, "%" + paramPname + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Project data = new Project();
				data.setPid(rs.getInt("pid"));
				data.setPname(rs.getString("pname"));
				dataList.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt,rs);
		}
		return dataList;
	}
	@Override
	public List<Project> selectByAll() {
		List<Project> dataList = new ArrayList<Project>();
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
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Project data = new Project();
				data.setPid(rs.getInt("pid"));
				data.setPname(rs.getString("pname"));
				dataList.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt,rs);
		}
		return dataList;
	}

}
