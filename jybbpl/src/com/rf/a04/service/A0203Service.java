package com.rf.a04.service;

import java.util.Map;

public interface A0203Service {
	Map<String,Object> selectById(Integer paramPid);
	Map<String,Object> selectByName(String paramPname);
	Map<String,Object> selectByAll();
}
