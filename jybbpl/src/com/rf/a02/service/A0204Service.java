package com.rf.a02.service;

import java.util.Map;

import com.rf.common.model.Project;

public interface A0204Service {
	Map<String,Object> selectData(Integer paramPid);
	Map<String,String> deleteData(Integer paramPid);
}
