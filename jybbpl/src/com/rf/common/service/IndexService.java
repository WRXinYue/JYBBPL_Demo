package com.rf.common.service;

import java.util.Map;

public interface IndexService {
	Map<String,Object> checkLogin(String paramUlphone,String paramPassword);
}
