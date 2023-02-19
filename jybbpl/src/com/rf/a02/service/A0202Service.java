package com.rf.a02.service;

import java.util.Map;

import com.rf.common.model.Project;

public interface A0202Service {
	Map<String,Object> selectData(Integer paramPid);
	Map<String,String> updateData(Project paramData);
}
