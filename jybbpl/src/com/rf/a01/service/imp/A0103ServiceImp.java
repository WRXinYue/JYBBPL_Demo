package com.rf.a01.service.imp;

import java.util.HashMap;
import java.util.Map;

import com.rf.a01.dao.A0103Dao;
import com.rf.a01.dao.imp.A0103DaoImp;
import com.rf.a01.service.A0103Service;
import com.rf.common.dao.imp.CommonDaoImp;
import com.rf.common.model.Userlogin;

public class A0103ServiceImp extends CommonDaoImp implements A0103Service {
	A0103Dao a0103Dao;

	public A0103ServiceImp() {
		a0103Dao = new A0103DaoImp();
	}

	@Override
	public Map<String, Object> upDatePassword(Userlogin userPassword) {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		int affectRow = a0103Dao.upDatePassword(userPassword);
		if (affectRow > 0) {
			dataMap.put("success", "A0103_SUCC_01");
		} else {
			dataMap.put("error", "A0103_ERR_01");
		}
		return dataMap;
	}
}
