package com.rf.a02.dao;

import java.util.List;

import com.rf.common.model.Project;

public interface A0203Dao {
	List<Project> selectById(Integer paramPid);
	List<Project> selectByName(String paramPname);
	List<Project> selectByAll();
}