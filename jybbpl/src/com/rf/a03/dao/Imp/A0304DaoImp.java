package com.rf.a03.dao.Imp;

import com.rf.a03.dao.A0304Dao;
import com.rf.common.dao.imp.CommonDaoImp;
import com.rf.common.db.DBUtils;
import com.rf.common.model.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class A0304DaoImp extends CommonDaoImp implements A0304Dao {
    protected DBUtils dbUtils;

    public A0304DaoImp() {
        dbUtils = DBUtils.getInstance();
    }

    @Override
    public List<Course> selectByAll() {
        List<Course> dataList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = dbUtils.getConn();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT ");
            sql.append(" 		 b.userid ");
            sql.append(" 		,b.username ");
            sql.append("        ,f.sparname ");
            sql.append("        ,b.userphone ");
            sql.append("        ,e.cid ");
            sql.append("        ,e.cname ");
            sql.append("        ,e.cpeonum ");
            sql.append(" FROM ");
            sql.append("         userlogin a ");
            sql.append(" INNER JOIN ");
            sql.append("         userinformation b ");
            sql.append(" ON ");
            sql.append("         b.userid = a.userid ");
            sql.append(" INNER JOIN ");
            sql.append("          purview c ");
            sql.append(" ON ");
            sql.append("          a.ulpowerid = c.purid ");
            sql.append(" INNER JOIN ");
            sql.append("          course e ");
            sql.append(" ON ");
            sql.append("          a.userid = e.useridt ");
            sql.append(" INNER JOIN ");
            sql.append("          subparameter f ");
            sql.append(" ON ");
            sql.append("          f.sparid = b.usersex ");
            sql.append(" WHERE parid = 1 ");
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Userinformation user = new Userinformation();
                Course course = new Course();
                Subparameter smr = new Subparameter();
                user.setUserid(rs.getInt("userid"));
                user.setUsername(rs.getString("username"));
                smr.setSparname(rs.getString("sparname"));
                user.setUsersex(smr);
                user.setUserphone(rs.getString("userphone"));
                course.setUseridt(user);
                course.setCid(rs.getInt("cid"));
                course.setCname(rs.getString("cname"));
                course.setCpeonum(rs.getInt("cpeonum"));
                dataList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs);
        }
        return dataList;
    }

    @Override
    public List<Course> selectById(Integer paramIdt) {
        List<Course> dataList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = dbUtils.getConn();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT ");
            sql.append(" 		 b.userid ");
            sql.append(" 		,b.username ");
            sql.append("        ,f.sparname ");
            sql.append("        ,b.userphone ");
            sql.append("        ,e.cid ");
            sql.append("        ,e.cname ");
            sql.append("        ,e.cpeonum ");
            sql.append(" FROM ");
            sql.append("         userlogin a ");
            sql.append(" INNER JOIN ");
            sql.append("         userinformation b ");
            sql.append(" ON ");
            sql.append("         b.userid = a.userid ");
            sql.append(" INNER JOIN ");
            sql.append("          purview c ");
            sql.append(" ON ");
            sql.append("          a.ulpowerid = c.purid ");
            sql.append(" INNER JOIN ");
            sql.append("          course e ");
            sql.append(" ON ");
            sql.append("          a.userid = e.useridt ");
            sql.append(" INNER JOIN ");
            sql.append("          subparameter f ");
            sql.append(" ON ");
            sql.append("          f.sparid = b.usersex ");
            sql.append(" WHERE parid = 1 ");
            sql.append(" AND ");
            sql.append("          useridt = ? ");
            pstmt = conn.prepareStatement(sql.toString());
             pstmt.setInt(1, paramIdt);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Userinformation user = new Userinformation();
                Course course = new Course();
                Subparameter smr = new Subparameter();
                user.setUserid(rs.getInt("userid"));
                user.setUsername(rs.getString("username"));
                smr.setSparname(rs.getString("sparname"));
                user.setUsersex(smr);
                user.setUserphone(rs.getString("userphone"));
                course.setUseridt(user);
                course.setCid(rs.getInt("cid"));
                course.setCname(rs.getString("cname"));
                course.setCpeonum(rs.getInt("cpeonum"));
                dataList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs);
        }
        return dataList;
    }

    @Override
    public List<Course> selectByName(String paramName) {
        List<Course> dataList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = dbUtils.getConn();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT ");
            sql.append(" 		 b.userid ");
            sql.append(" 		,b.username ");
            sql.append("        ,f.sparname ");
            sql.append("        ,b.userphone ");
            sql.append("        ,e.cid ");
            sql.append("        ,e.cname ");
            sql.append("        ,e.cpeonum ");
            sql.append(" FROM ");
            sql.append("         userlogin a ");
            sql.append(" INNER JOIN ");
            sql.append("         userinformation b ");
            sql.append(" ON ");
            sql.append("         b.userid = a.userid ");
            sql.append(" INNER JOIN ");
            sql.append("          purview c ");
            sql.append(" ON ");
            sql.append("          a.ulpowerid = c.purid ");
            sql.append(" INNER JOIN ");
            sql.append("          course e ");
            sql.append(" ON ");
            sql.append("          a.userid = e.useridt ");
            sql.append(" INNER JOIN ");
            sql.append("          subparameter f ");
            sql.append(" ON ");
            sql.append("          f.sparid = b.usersex ");
            sql.append(" WHERE parid = 1 ");
            sql.append(" AND ");
            sql.append("          username Like  ? ");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, "%" + paramName + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Userinformation user = new Userinformation();
                Course course = new Course();
                Subparameter smr = new Subparameter();
                user.setUserid(rs.getInt("userid"));
                user.setUsername(rs.getString("username"));
                smr.setSparname(rs.getString("sparname"));
                user.setUsersex(smr);
                user.setUserphone(rs.getString("userphone"));
                course.setUseridt(user);
                course.setCid(rs.getInt("cid"));
                course.setCname(rs.getString("cname"));
                course.setCpeonum(rs.getInt("cpeonum"));
                dataList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs);
        }
        return dataList;
    }

    @Override
    public List<Course> selectByAge(String paramAge) {
        List<Course> dataList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = dbUtils.getConn();
            StringBuffer sql = new StringBuffer();
            sql.append(" SELECT ");
            sql.append(" 		 b.userid ");
            sql.append(" 		,b.username ");
            sql.append("        ,f.sparname ");
            sql.append("        ,b.userphone ");
            sql.append("        ,e.cid ");
            sql.append("        ,e.cname ");
            sql.append("        ,e.cpeonum ");
            sql.append(" FROM ");
            sql.append("         userlogin a ");
            sql.append(" INNER JOIN ");
            sql.append("         userinformation b ");
            sql.append(" ON ");
            sql.append("         b.userid = a.userid ");
            sql.append(" INNER JOIN ");
            sql.append("          purview c ");
            sql.append(" ON ");
            sql.append("          a.ulpowerid = c.purid ");
            sql.append(" INNER JOIN ");
            sql.append("          course e ");
            sql.append(" ON ");
            sql.append("          a.userid = e.useridt ");
            sql.append(" INNER JOIN ");
            sql.append("          subparameter f ");
            sql.append(" ON ");
            sql.append("          f.sparid = b.usersex ");
            sql.append(" WHERE parid = 1 ");
            sql.append(" AND ");
            sql.append("          sparname = ? ");
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, paramAge);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Userinformation user = new Userinformation();
                Course course = new Course();
                Subparameter smr = new Subparameter();
                user.setUserid(rs.getInt("userid"));
                user.setUsername(rs.getString("username"));
                smr.setSparname(rs.getString("sparname"));
                user.setUsersex(smr);
                user.setUserphone(rs.getString("userphone"));
                course.setUseridt(user);
                course.setCid(rs.getInt("cid"));
                course.setCname(rs.getString("cname"));
                course.setCpeonum(rs.getInt("cpeonum"));
                dataList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, pstmt, rs);
        }
        return dataList;
    }
    }

