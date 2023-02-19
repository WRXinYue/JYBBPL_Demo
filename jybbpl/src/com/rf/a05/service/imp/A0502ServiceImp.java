package com.rf.a05.service.imp;

import java.util.HashMap;
import java.util.Map;

import com.rf.a05.dao.A0502Dao;
import com.rf.a05.dao.imp.A0502DaoImp;
import com.rf.a05.service.A0502Service;
import com.rf.common.model.Userlogin;

public class A0502ServiceImp implements A0502Service {
	A0502Dao a0502Dao;
	public A0502ServiceImp() {
		a0502Dao = new A0502DaoImp();
	}
	@Override
	public Map<String, String> updateData(Userlogin paramData, int parameter) {
		Map<String, String> dataMap = new HashMap<String, String>();
		int affectRow = a0502Dao.updateData(paramData, parameter);
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
		Userlogin data = a0502Dao.selectData(paramPid);
		if (data != null) {
			dataMap.put("data", data);
		} else {
			dataMap.put("error", "A0502_ERR_02");
		}
		return dataMap;
	}
}
