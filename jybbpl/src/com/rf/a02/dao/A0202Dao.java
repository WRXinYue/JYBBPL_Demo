package com.rf.a02.dao;

import com.rf.common.model.Project;

public interface A0202Dao {
	Project selectData(Integer paramPid);
	int updateData(Project paramData);
}