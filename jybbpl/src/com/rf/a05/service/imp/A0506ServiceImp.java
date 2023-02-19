package com.rf.a05.service.imp;

import java.util.HashMap;
import java.util.Map;

import com.rf.a05.dao.A0506Dao;
import com.rf.a05.dao.imp.A0506DaoImp;
import com.rf.a05.service.A0506Service;
import com.rf.common.model.Userlogin;

public class A0506ServiceImp implements A0506Service {
	A0506Dao a0506Dao;
	public A0506ServiceImp() {
		a0506Dao = new A0506DaoImp();
	}
	@Override
	public Map<String, String> updateData(int paramPid, int parameter) {
		Map<String, String> dataMap = new HashMap<String, String>();
		int affectRow = a0506Dao.updateData(paramPid, parameter);
		if (affectRow > 0) {
			dataMap.put("success", "A0502_SUCC_01");
		} else {
			dataMap.put("error", "A0502_ERR_01");
		}
		return dataMap;
	}
	@Override
	public Map<String, Object> selectData(Integer paramPid) {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		Userlogin data = a0506Dao.selectData(paramPid);
		if (data != null) {
			dataMap.put("data", data);
		} else {
			dataMap.put("error", "A0502_ERR_02");
		}
		return dataMap;
	}
}
