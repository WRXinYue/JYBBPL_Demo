package com.rf.a05.service.imp;

import java.util.HashMap;
import java.util.Map;

import com.rf.a05.dao.A0508Dao;
import com.rf.a05.dao.imp.A0508DaoImp;
import com.rf.a05.service.A0508Service;
import com.rf.common.model.Userlogin;

public class A0508ServiceImp implements A0508Service {
	A0508Dao a0508Dao;
	public A0508ServiceImp() {
		a0508Dao = new A0508DaoImp();
	}
	@Override
	public Map<String, String> updateData(int paramPid) {
		Map<String, String> dataMap = new HashMap<String, String>();
		int affectRow = a0508Dao.updateData(paramPid);
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
		Userlogin data = a0508Dao.selectData(paramPid);
		if (data != null) {
			dataMap.put("data", data);
		} else {
			dataMap.put("error", "A0502_ERR_02");
		}
		return dataMap;
	}
}
