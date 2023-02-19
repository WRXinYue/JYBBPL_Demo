package com.rf.a05.service;

import java.util.Map;

public interface A0503Service {
	Map<String, Object> selectByid(int paramPid);
	Map<String, Object> selectByName(String paramPname);
	Map<String, Object> selectByPhone(String param);
	Map<String, Object> selectByAll();
}
