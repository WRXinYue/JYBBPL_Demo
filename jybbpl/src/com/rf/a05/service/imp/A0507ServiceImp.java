package com.rf.a05.service.imp;

import java.util.HashMap;
import java.util.Map;

import com.rf.a05.dao.A0507Dao;
import com.rf.a05.dao.imp.A0507DaoImp;
import com.rf.a05.service.A0507Service;
import com.rf.common.model.Userlogin;

public class A0507ServiceImp implements A0507Service {
	A0507Dao a0507Dao;
	public A0507ServiceImp() {
		a0507Dao = new A0507DaoImp();
	}
	@Override
	public Map<String, String> updateData(int paramPid) {
		Map<String, String> dataMap = new HashMap<String, String>();
		int affectRow = a0507Dao.updateData(paramPid);
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
		Userlogin data = a0507Dao.selectData(paramPid);
		if (data != null) {
			dataMap.put("data", data);
		} else {
			dataMap.put("error", "A0502_ERR_02");
		}
		return dataMap;
	}
}
