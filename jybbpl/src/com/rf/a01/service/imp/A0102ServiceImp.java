package com.rf.a01.service.imp;

import java.util.HashMap;
import java.util.Map;

import com.rf.a01.dao.A0102Dao;
import com.rf.a01.dao.imp.A0102DaoImp;
import com.rf.a01.service.A0102Service;
import com.rf.common.dao.imp.CommonDaoImp;

public class A0102ServiceImp extends CommonDaoImp implements A0102Service {
	A0102Dao a0102Dao;

	public A0102ServiceImp() {
		a0102Dao = new A0102DaoImp();
	}

	@Override
	public Map<String, Object> upDateHeight(float height) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int affectRow = a0102Dao.upDateHeight(height);
		if (affectRow > 0) {
			dataMap.put("success", "A0102_SUCC_01");
		} else {
			dataMap.put("error", "A0102_ERR_01");
		}
		return dataMap;
	}

	@Override
	public Map<String, Object> upDateWeight(float weight) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int affectRow = a0102Dao.upDateHeight(weight);
		if (affectRow > 0) {
			dataMap.put("success", "A0102_SUCC_01");
		} else {
			dataMap.put("error", "A0102_ERR_01");
		}
		return dataMap;
	}

}
