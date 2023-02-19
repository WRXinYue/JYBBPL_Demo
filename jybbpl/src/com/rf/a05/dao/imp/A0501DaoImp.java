package com.rf.a05.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.rf.a05.dao.A0501Dao;
import com.rf.common.dao.imp.CommonDaoImp;
import com.rf.common.db.DBUtils;
import com.rf.common.model.Userinformation;
import com.rf.common.model.Userlogin;

public class A0501DaoImp extends CommonDaoImp implements A0501Dao{
	protected DBUtils dbUtils;
	public A0501DaoImp() {
		dbUtils = DBUtils.getInstance();
	}
	@Override
	public int insertData(Userlogin paramData1,Userinformation paramData2) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		int affectRow = 0;
		int id = 0;
		try {
			conn = dbUtils.getConn();
			StringBuffer sql = new StringBuffer();
			sql.append(" INSERT ");
			sql.append("     INTO ");
			sql.append("         userinformation( ");
			sql.append("                     username, ");
			sql.append("                     userphone, ");
			sql.append("                     usersex" );
			sql.append("                   )");
			sql.append("      VALUES( ");
			sql.append("               ?, ");
			sql.append("               ?, ");
			sql.append("               ? ");
			sql.append("             );");
			pstmt2 = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			pstmt2.setString(1, paramData2.getUsername());
			pstmt2.setString(2, paramData2.getUserphone());
			pstmt2.setInt(3, 1);
			affectRow += pstmt2.executeUpdate();
			ResultSet rs = pstmt2.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
			sql = new StringBuffer();
			sql.append(" INSERT ");
			sql.append("     INTO ");
			sql.append("         userlogin( ");
			sql.append("                     ulphone, ");
			sql.append("                     userid, ");
			sql.append("                     ulpassword, ");
			sql.append("                     ulstatus, ");
			sql.append("                     ullosure, ");
			sql.append("                     ulpowerid, ");
			sql.append("                     ulbalance");
			sql.append("                   )");
			sql.append("      VALUES( ");
			sql.append("               ?, ");
			sql.append("               ?, ");
			sql.append("               ?, ");
			sql.append("               ?, ");
			sql.append("               ?, ");
			sql.append("               ?, ");
			sql.append("               ? ");
			sql.append("             );");
			pstmt = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, paramData1.getUlphone());
			pstmt.setInt(2, id);
			pstmt.setString(3, paramData1.getUlpassword());
			pstmt.setInt(4, 0);
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 3); //权限为普通用户，这里表格提供有问题，权限表需要更改
			pstmt.setFloat(7, 0);
			affectRow += pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return affectRow;
	}
}
