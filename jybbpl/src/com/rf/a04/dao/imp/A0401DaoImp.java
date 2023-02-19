package com.rf.a04.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import com.rf.a04.dao.A0401Dao;
import com.rf.common.dao.imp.CommonDaoImp;
import com.rf.common.db.DBUtils;
import com.rf.common.model.Course;
import com.rf.common.model.Project;
import com.rf.common.model.Subparameter;
import com.rf.common.model.Userinformation;
import com.rf.common.utils.CommonUtils;

public class A0401DaoImp extends CommonDaoImp implements A0401Dao {
	protected DBUtils dbUtils;
	public A0401DaoImp() {
		dbUtils = DBUtils.getInstance();
	}
	@Override
	public int insertData(Course paramData) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int affectRow = 0;
		try {
			conn = dbUtils.getConn();
			StringBuffer sql = new StringBuffer();
			sql.append(" INSERT ");
			sql.append("     INTO ");
			sql.append("       course( ");
			sql.append("       			cname ");
			sql.append("       			,pid ");
			sql.append("       			,useridt ");
			sql.append("       			,cstarttime ");
			sql.append("       			,cattendtime ");
			sql.append("       			,cendtime ");
			sql.append("       			,clesson ");
			sql.append("       			,cdescribe ");
			sql.append("       			,cpeonum ");
			sql.append("       			,cactpeonum ");
			sql.append("       			,cstartstatus ");
			sql.append("       			,creservetime ");
			sql.append("       			,ccreateid ");
			sql.append("       			,ccreatetime ");
			sql.append("        	  )");
			sql.append("     VALUES( ");
			sql.append("       			? ");
			sql.append("       			,? ");
			sql.append("       			,? ");
			sql.append("       			,? ");
			sql.append("       			,? ");
			sql.append("       			,? ");
			sql.append("       			,? ");
			sql.append("       			,? ");
			sql.append("       			,? ");
			sql.append("       			,? ");
			sql.append("       			,? ");
			sql.append("       			,? ");
			sql.append("       			,? ");
			sql.append("       			,now() ");
			sql.append(" 			) ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, paramData.getCname());
			pstmt.setInt(2, paramData.getPid().getPid());
			pstmt.setInt(3, paramData.getUseridt().getUserid());
			pstmt.setDate(4, CommonUtils.uDateToSQLDate(paramData.getCstarttime()));
			pstmt.setDate(5, CommonUtils.uDateToSQLDate(paramData.getCattendtime()));
			pstmt.setDate(6, CommonUtils.uDateToSQLDate(paramData.getCendtime()));
			pstmt.setInt(7, paramData.getClesson());
			pstmt.setString(8, paramData.getCdescribe());
			pstmt.setInt(9, paramData.getCpeonum());
			pstmt.setInt(10, paramData.getCactpeonum());
			pstmt.setInt(11, paramData.getCstartstatus().getSparid());
			pstmt.setDate(12, CommonUtils.uDateToSQLDate(paramData.getCreservetime()));
			pstmt.setInt(13, paramData.getCcreateid().getUserid());
			affectRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt);
		}
		return affectRow;
	}

}
