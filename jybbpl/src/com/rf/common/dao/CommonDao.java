package com.rf.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.rf.common.model.Subparameter;

public interface CommonDao {
	void close(Connection conn,Statement stmt,ResultSet rs);
	void close(Connection conn,PreparedStatement pstmt,ResultSet rs);
	void close(Connection conn,Statement stmt);
	void close(Connection conn,PreparedStatement pstmt);
	int cancleUser(Integer paramUlid,Subparameter paramUlstatus);
	int exitSystem(Integer paramUlid,Subparameter paramUlstatus);
}
