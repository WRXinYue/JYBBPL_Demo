package com.rf.a05.service.imp;

import java.util.HashMap;
import java.util.Map;

import com.rf.a05.dao.A0501Dao;
import com.rf.a05.dao.imp.A0501DaoImp;
import com.rf.a05.service.A0501Service;
import com.rf.common.model.Userinformation;
import com.rf.common.model.Userlogin;

public class A0501ServiceImp implements A0501Service {
	A0501Dao a0501Dao;
	public A0501ServiceImp() {
		a0501Dao = new A0501DaoImp();
	}
	@Override
	public Map<String, String> insertData(Userlogin userlogin, Userinformation userinformation) {
		Map<String, String> dataMap = new HashMap<String,String>();
		int affectRow = a0501Dao.insertData(userlogin, userinformation);
		if (affectRow > 0) {
			dataMap.put("success", "A0501_SUCC_01");
		} else {
			dataMap.put("error", "A0501_ERR_01");
		}
		return dataMap;
	}
}
