package com.rf.a05.service;

import java.util.Map;

import com.rf.common.model.Userlogin;

public interface A0502Service {
	Map<String, Object> selectData (Integer paramData);
	Map<String, String> updateData(Userlogin paramData, int parameter);
}
