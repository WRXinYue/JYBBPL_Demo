package com.rf.a05.service;

import java.util.Map;

public interface A0505Service {
	Map<String, Object> selectByid(int paramPid);
	Map<String, Object> selectByAll();
	Map<String, String> freezeUser(int paramPid);
	Map<String, String> unfreezeUser(int paramPid);
}
