package com.rf.a02.dao;

import com.rf.common.model.Project;

public interface A0204Dao {
	Project selectData(Integer paramPid);
	int selectCountRow(Integer paramPid);
	int deleteData(Integer paramPid);
}