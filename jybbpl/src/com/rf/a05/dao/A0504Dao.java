package com.rf.a05.dao;

import com.rf.common.model.Userlogin;

public interface A0504Dao {
	Userlogin selectData(Integer paramPid);
	//int selectCountRow(Integer paramPid);
	int deleteData(Integer paramPid);
}
