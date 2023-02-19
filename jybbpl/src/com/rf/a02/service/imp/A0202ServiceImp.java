package com.rf.a02.service.imp;

import java.util.HashMap;
import java.util.Map;

import com.rf.a02.dao.A0202Dao;
import com.rf.a02.dao.imp.A0202DaoImp;
import com.rf.a02.service.A0202Service;
import com.rf.common.model.Project;

public class A0202ServiceImp implements A0202Service {
	A0202Dao a0202Dao;
	public A0202ServiceImp() {
		a0202Dao = new A0202DaoImp();
	}
	@Override
	public Map<String, String> updateData(Project paramData) {
		Map<String, String> dataMap = new HashMap<String,String>();
		int affectRow = a0202Dao.updateData(paramData);
		if (affectRow > 0) {
			dataMap.put("success", "A0202_SUCC_01");
		} else {
			dataMap.put("error", "A0202_ERR_01");
		}
		return dataMap;
	}
	@Override
	public Map<String, Object> selectData(Integer paramPid) {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		Project data = a0202Dao.selectData(paramPid);
		if (data != null) {
			dataMap.put("data", data);
		} else {
			dataMap.put("error", "A0202_ERR_02");
		}
		return dataMap;
	}
}
