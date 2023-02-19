package com.rf.a02.service.imp;

import java.util.HashMap;
import java.util.Map;

import com.rf.a02.dao.A0201Dao;
import com.rf.a02.dao.imp.A0201DaoImp;
import com.rf.a02.service.A0201Service;

public class A0201ServiceImp implements A0201Service {
	A0201Dao a0201Dao;
	public A0201ServiceImp() {
		a0201Dao = new A0201DaoImp();
	}
	@Override
	public Map<String, String> insertData(String paramPname) {
		Map<String, String> dataMap = new HashMap<String,String>();
		int affectRow = a0201Dao.insertData(paramPname);
		if (affectRow > 0) {
			dataMap.put("success", "A0201_SUCC_01");
		} else {
			dataMap.put("error", "A0201_ERR_01");
		}
		return dataMap;
	}

}
