package com.rf.a05.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rf.a05.dao.A0505Dao;
import com.rf.a05.dao.imp.A0505DaoImp;
import com.rf.a05.service.A0505Service;
import com.rf.common.model.Userlogin;

public class A0505ServiceImp implements A0505Service {
	A0505Dao a0505Dao;
	public A0505ServiceImp() {
		a0505Dao = new A0505DaoImp();
	}
	@Override
	public Map<String, Object> selectByid(int paramPid) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Userlogin> dataList = a0505Dao.selectById(paramPid);
		if (dataList.size() > 0) {
			dataMap.put("data", dataList);
		} else {
			dataMap.put("error", "A0503_ERR_01");
		}
		return dataMap;
	}
	@Override
	public Map<String, Object> selectByAll() {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Userlogin> dataList = a0505Dao.selectByAll();
		if (dataList.size() > 0) {
			dataMap.put("data", dataList);
		} else {
			dataMap.put("error", "A0503_ERR_01");
		}
		return dataMap;
	}
	@Override
	public Map<String, String> freezeUser(int paramPid) {
		Map<String, String> dataMap = new HashMap<String, String>();
		int affectRow = a0505Dao.freezeUser(paramPid);
		if (affectRow > 0) {
			dataMap.put("success", "A0502_SUCC_01");
		} else {
			dataMap.put("error", "A0502_ERR_01");
		}
		return dataMap;
	}
	@Override
	public Map<String, String> unfreezeUser(int paramPid) {
		Map<String, String> dataMap = new HashMap<String, String>();
		int affectRow = a0505Dao.unfreezeUser(paramPid);
		if (affectRow > 0) {
			dataMap.put("success", "A0502_SUCC_01");
		} else {
			dataMap.put("error", "A0502_ERR_01");
		}
		return dataMap;
	}
}
