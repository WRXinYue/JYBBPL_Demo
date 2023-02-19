package com.rf.a05.service;

import java.util.Map;

public interface A0504Service {
	Map<String, Object> selectData(int paramPid);
	Map<String, String> deleteData(int paramPid);
}
