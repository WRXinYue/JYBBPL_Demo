package com.rf.a05.dao;

import java.util.List;

import com.rf.common.model.Userlogin;

public interface A0505Dao {
	List<Userlogin> selectById(Integer paraId);
	List<Userlogin> selectByAll();
	int freezeUser(Integer paraId);
	int unfreezeUser(Integer paraId);
}
