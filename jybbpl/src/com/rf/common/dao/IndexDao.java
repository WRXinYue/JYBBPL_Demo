package com.rf.common.dao;

import com.rf.common.model.Userlogin;

public interface IndexDao {
	Userlogin checkLogin(Userlogin paramUserlogin);
	int updateUlstatus(Userlogin paramUserlogin);
}
