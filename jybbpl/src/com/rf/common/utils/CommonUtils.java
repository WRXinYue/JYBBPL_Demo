package com.rf.common.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.rf.common.db.DBUtils;
import com.wj.utils.MD5;

public class CommonUtils {
	private static DBUtils db;
	private static final String SUCCESSMESSAGE = "succmessage.properties";
	private static final String ERRORMESSAGE = "errormessage.properties";
	private static final String DATE_FORMAT_01 = "yyyy-MM-dd hh:mm";
	private static final String DATE_FORMAT_02 = "hh:mm";
	static {
		db = DBUtils.getInstance();
	}
	public static String encryption(String password) {
		return MD5.MD5(password);	
	}
	public static void printSuccessMessage(String key) {
		StringBuffer info = new StringBuffer();
		info.append("☆☆☆\t");
		info.append(ReadFileUtils.getMessageProperties(SUCCESSMESSAGE, key));
		info.append("☆☆☆");
		System.out.println(info);
	}
	public static void printErrorMessage(String key) {
		StringBuffer info = new StringBuffer();
		info.append("❌❌❌\t");
		info.append(ReadFileUtils.getMessageProperties(ERRORMESSAGE, key));
		info.append("❌❌❌");
		System.err.println(info);
		System.out.println();
	}
	public static void printProject() {
		StringBuffer info = new StringBuffer();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = db.getConn();
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT ");
			sql.append("       pid ");
			sql.append("       ,pname ");
			sql.append(" FROM ");
			sql.append("     project ");
			sql.append(" ORDER BY ");
			sql.append("         pid ");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				info.append(rs.getInt("pid") + ".");
				info.append(rs.getString("pname") + "\t");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(conn);
		}
		if (info.toString().length() > 0) {
			System.out.println(info);
		} else {
			System.out.println("没有任何项目可以加载！");
		}
	}
	public static void printCoach() {
		StringBuffer info = new StringBuffer();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = db.getConn();
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT ");
			sql.append("       a.userid userid ");
			sql.append("       ,a.username username ");
			sql.append(" FROM ");
			sql.append("     userinformation a ");
			sql.append(" INNER JOIN ");
			sql.append("     userlogin b ");
			sql.append(" ON ");
			sql.append("     a.userid = b.userid ");
			sql.append(" WHERE ");
			sql.append("     b.ulpowerid = ? ");
			sql.append(" ORDER BY ");
			sql.append("         a.userid ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, 3);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				info.append(rs.getInt("userid") + ".");
				info.append(rs.getString("username") + "\t");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(conn);
		}
		if (info.toString().length() > 0) {
			System.out.println(info);
		} else {
			System.out.println("没有任何教练可以加载！");
		}
	}
	public static Date strToDate(String strDate,int typeId) {
		Date result = null;
		try {
			String strFmt = "";
			if (1 == typeId) {
				strFmt = DATE_FORMAT_01;
			} else if (2 == typeId) {
				strFmt = DATE_FORMAT_02;
			}
			SimpleDateFormat fmt = new SimpleDateFormat(strFmt);
			result = fmt.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static java.sql.Date uDateToSQLDate(Date paramUDate) {
		return new java.sql.Date(paramUDate.getTime());
	} 
	public static void main(String[] args) {
//		System.out.println(encryption("123456"));
		printSuccessMessage("A0202_SUCC_01");
	}
}
