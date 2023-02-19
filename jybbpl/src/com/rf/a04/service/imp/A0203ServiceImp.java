package com.rf.a04.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rf.a02.dao.A0203Dao;
import com.rf.a02.dao.imp.A0203DaoImp;
import com.rf.a02.service.A0203Service;
import com.rf.common.model.Project;

public class A0203ServiceImp implements A0203Service {
	A0203Dao a0203Dao;
	public A0203ServiceImp() {
		a0203Dao = new A0203DaoImp();
	}
	@Override
	public Map<String, Object> selectById(Integer paramPid) {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		List<Project> dataList = a0203Dao.selectById(paramPid);
		if (dataList.size() > 0) {
			dataMap.put("data", dataList);
		} else {
			dataMap.put("error", "A0203_ERR_01");
		}
		return dataMap;
	}
	@Override
	public Map<String, Object> selectByName(String paramPname) {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		List<Project> dataList = a0203Dao.selectByName(paramPname);
		if (dataList.size() > 0) {
			dataMap.put("data", dataList);
		} else {
			dataMap.put("error", "A0203_ERR_01");
		}
		return dataMap;
	}
	@Override
	public Map<String, Object> selectByAll() {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		List<Project> dataList = a0203Dao.selectByAll();
		if (dataList.size() > 0) {
			dataMap.put("data", dataList);
		} else {
			dataMap.put("error", "A0203_ERR_01");
		}
		return dataMap;
	}
}
