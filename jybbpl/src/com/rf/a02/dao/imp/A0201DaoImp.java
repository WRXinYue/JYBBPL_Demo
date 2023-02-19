package com.rf.a02.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rf.a02.dao.A0201Dao;
import com.rf.common.dao.imp.CommonDaoImp;
import com.rf.common.db.DBUtils;

public class A0201DaoImp extends CommonDaoImp implements A0201Dao {
	protected DBUtils dbUtils;
	public A0201DaoImp() {
		dbUtils = DBUtils.getInstance();
	}
	@Override
	public int insertData(String paramPname) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int affectRow = 0;
		try {
			conn = dbUtils.getConn();
			StringBuffer sql = new StringBuffer();
			sql.append(" INSERT ");
			sql.append("     INTO ");
			sql.append("       project( ");
			sql.append("       			pname ");
			sql.append("        	  )");
			sql.append("     VALUES( ");
			sql.append("    		 ? ");
			sql.append(" 			) ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, paramPname);
			affectRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return affectRow;
	}

}
