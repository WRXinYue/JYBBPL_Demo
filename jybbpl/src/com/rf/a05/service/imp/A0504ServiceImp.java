package com.rf.a05.service.imp;

import java.util.HashMap;
import java.util.Map;

import com.rf.a05.dao.A0504Dao;
import com.rf.a05.dao.imp.A0504DaoImp;
import com.rf.a05.service.A0504Service;
import com.rf.common.model.Userlogin;

public class A0504ServiceImp implements A0504Service {
	A0504Dao a0504Dao;
	public A0504ServiceImp() {
		a0504Dao = new A0504DaoImp();
	}
	@Override
	public Map<String, Object> selectData(int paramPid) {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		Userlogin data = a0504Dao.selectData(paramPid);
		if (data != null) {
			dataMap.put("data", data);
		} else {
			dataMap.put("error", "A0504_ERR_01");
		}
		return dataMap;
	}
	@Override
	public Map<String, String> deleteData(int paramPid) {
		Map<String, String> dataMap = new HashMap<String,String>();
		int affectRow = a0504Dao.deleteData(paramPid);
		if (affectRow > 0) {
			dataMap.put("success", "A0504_SUCC_01");
		} else {
			dataMap.put("error", "A0504_ERR_03");
		}
		return dataMap;
	}
}
