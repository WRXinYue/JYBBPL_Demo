package com.rf.common.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rf.common.dao.IndexDao;
import com.rf.common.model.Purview;
import com.rf.common.model.Subparameter;
import com.rf.common.model.Userinformation;
import com.rf.common.model.Userlogin;

public class IndexDaoImp extends CommonDaoImp implements IndexDao {

	@Override
	public Userlogin checkLogin(Userlogin paramUserlogin) {
		Userlogin data = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtils.getConn();
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT ");
			sql.append(" 		 a.ulid as ulid ");
			sql.append(" 		 ,a.ulphone as ulphone ");
			sql.append(" 		 ,a.ulstatus as ulstatusid ");
			sql.append(" 		 ,f_codetoname(2,a.ulstatus) as ulstatusname  ");
			sql.append(" 		 ,a.ullosure as ullosureid ");
			sql.append(" 		 ,f_codetoname(3,a.ullosure) as ullosurename ");
			sql.append(" 		 ,c.purid as purid ");
			sql.append(" 		 ,c.purname as purname ");
			sql.append(" 		 ,a.ulbalance as ulbalance ");
			sql.append(" 		 ,b.userid as userid ");
			sql.append(" 		 ,b.username as username ");
			sql.append(" 		 ,b.userphone as userphone ");
			sql.append(" 		 ,b.usersex as usersexid ");
			sql.append(" 		 ,f_codetoname(1,b.usersex) as usersexname ");
			sql.append(" 		 ,b.userheight as userheight ");
			sql.append(" 		 ,b.userweight as userweight ");
			sql.append(" FROM ");
			sql.append("       userlogin a ");
			sql.append(" INNER JOIN ");
			sql.append("       userinformation b ");
			sql.append(" ON ");
			sql.append("       a.userid = b.userid ");
			sql.append(" INNER JOIN ");
			sql.append("       purview c ");
			sql.append(" ON ");
			sql.append("       a.ulpowerid = c.purid ");
			sql.append(" WHERE ");
			sql.append("      a.ulphone = ? ");
			sql.append(" AND ");
			sql.append("      a.ulpassword = ? ");
			sql.append(" AND ");
			sql.append("      a.ulstatus = ? ");
			sql.append(" AND ");
			sql.append("      a.ullosure = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, paramUserlogin.getUlphone());
			pstmt.setString(2, paramUserlogin.getUlpassword());
			pstmt.setInt(3, paramUserlogin.getUlstatus().getSparid());
			pstmt.setInt(4, paramUserlogin.getUllosure().getSparid());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				data = new Userlogin();
				data.setUlid(rs.getInt("ulid"));
				data.setUlphone(rs.getString("ulphone"));
				Subparameter ulstatus = new Subparameter();
				ulstatus.setSparid(rs.getInt("ulstatusid"));
				ulstatus.setSparname(rs.getString("ulstatusname"));
				data.setUlstatus(ulstatus);
				Subparameter ullosure = new Subparameter();
				ullosure.setSparid(rs.getInt("ullosureid"));
				ullosure.setSparname(rs.getString("ullosurename"));
				data.setUllosure(ullosure);
				Purview ulpowerid = new Purview();
				ulpowerid.setPurid(rs.getInt("purid"));
				ulpowerid.setPurname(rs.getString("purname"));
				data.setUlpowerid(ulpowerid);
				data.setUlbalance(rs.getFloat("ulbalance"));
				Userinformation userid = new Userinformation();
				userid.setUserid(rs.getInt("userid"));
				userid.setUsername(rs.getString("username"));
				userid.setUserphone(rs.getString("userphone"));
				Subparameter usersex = new Subparameter();
				usersex.setSparid(rs.getInt("usersexid"));
				usersex.setSparname(rs.getString("usersexname"));
				userid.setUsersex(usersex);
				userid.setUserheight(rs.getFloat("userheight"));
				userid.setUserweight(rs.getFloat("userweight"));
				data.setUserid(userid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt,rs);
		}
		return data;
	}

	@Override
	public int updateUlstatus(Userlogin paramUserlogin) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int affectRow = 0;
		try {
			conn = dbUtils.getConn();
			StringBuffer sql = new StringBuffer();
			sql.append(" UPDATE ");
			sql.append("       userlogin ");
			sql.append(" SET ");
			sql.append("    ulstatus = ? ");
			sql.append(" WHERE ");
			sql.append("      ulid = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, paramUserlogin.getUlstatus().getSparid());
			pstmt.setInt(2, paramUserlogin.getUlid());
			affectRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return affectRow;
	}

}
