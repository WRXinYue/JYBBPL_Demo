package com.rf.a04.service.imp;

import java.util.HashMap;
import java.util.Map;

import com.rf.a02.dao.A0204Dao;
import com.rf.a02.dao.imp.A0204DaoImp;
import com.rf.a02.service.A0204Service;
import com.rf.common.model.Project;

public class A0204ServiceImp implements A0204Service {
	A0204Dao a0204Dao;
	public A0204ServiceImp() {
		a0204Dao = new A0204DaoImp();
	}
	@Override
	public Map<String, String> deleteData(Integer paramPid) {
		Map<String, String> dataMap = new HashMap<String,String>();
		int countRow = a0204Dao.selectCountRow(paramPid);
		if (countRow > 0) {
			dataMap.put("error", "A0204_ERR_02");
			return dataMap;
		}
		int affectRow = a0204Dao.deleteData(paramPid);
		if (affectRow > 0) {
			dataMap.put("success", "A0204_SUCC_01");
		} else {
			dataMap.put("error", "A0204_ERR_03");
		}
		return dataMap;
	}
	@Override
	public Map<String, Object> selectData(Integer paramPid) {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		Project data = a0204Dao.selectData(paramPid);
		if (data != null) {
			dataMap.put("data", data);
		} else {
			dataMap.put("error", "A0204_ERR_01");
		}
		return dataMap;
	}
}
