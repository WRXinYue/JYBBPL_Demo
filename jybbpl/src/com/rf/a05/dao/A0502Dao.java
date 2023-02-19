package com.rf.a05.dao;

import com.rf.common.model.Userlogin;

public interface A0502Dao {
	Userlogin selectData(Integer paramPid);
	int updateData(Userlogin paramData, int parameter);
}
