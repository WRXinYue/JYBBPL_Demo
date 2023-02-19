package com.rf.a05.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rf.a05.dao.A0503Dao;
import com.rf.a05.dao.imp.A0503DaoImp;
import com.rf.a05.service.A0503Service;
import com.rf.common.model.Userlogin;

public class A0503ServiceImp implements A0503Service {
	A0503Dao a0503Dao;
	public A0503ServiceImp() {
		a0503Dao = new A0503DaoImp();
	}
	@Override
	public Map<String, Object> selectByid(int paramPid) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Userlogin> dataList = a0503Dao.selectById(paramPid);
		if (dataList.size() > 0) {
			dataMap.put("data", dataList);
		} else {
			dataMap.put("error", "A0503_ERR_01");
		}
		return dataMap;
	}
	@Override
	public Map<String, Object> selectByName(String paramPname) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Userlogin> dataList = a0503Dao.selectByName(paramPname);
		if (dataList.size() > 0) {
			dataMap.put("data", dataList);
		} else {
			dataMap.put("error", "A0503_ERR_01");
		}
		return dataMap;
	}
	@Override
	public Map<String, Object> selectByPhone(String param) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<Userlogin> dataList = a0503Dao.selectByPhone(param);
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
		List<Userlogin> dataList = a0503Dao.selectAll();
		if (dataList.size() > 0) {
			dataMap.put("data", dataList);
		} else {
			dataMap.put("error", "A0503_ERR_01");
		}
		return dataMap;
	}
}
