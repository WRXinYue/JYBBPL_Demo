package com.rf.a05.dao;

import java.util.List;

import com.rf.common.model.Userlogin;

public interface A0503Dao {
	List<Userlogin> selectById(Integer paraId);
	List<Userlogin> selectByName(String paraName);
	List<Userlogin> selectByPhone(String paraPhone);
	List<Userlogin> selectAll();
}
