package com.rf.a04.service.imp;

import java.util.HashMap;
import java.util.Map;

import com.rf.a04.dao.A0401Dao;
import com.rf.a04.dao.imp.A0401DaoImp;
import com.rf.a04.service.A0401Service;
import com.rf.common.model.Course;
import com.rf.common.model.Subparameter;
import com.rf.common.model.Userinformation;
import com.rf.common.session.SessionUser;

public class A0401ServiceImp implements A0401Service {
	A0401Dao a0401Dao;
	public A0401ServiceImp() {
		a0401Dao = new A0401DaoImp();
	}
	@Override
	public Map<String, String> insertData(Course paramData) {
		Map<String, String> dataMap = new HashMap<String,String>();
		Subparameter cstartstatus = new Subparameter();
		cstartstatus.setSparid(0);
		paramData.setCstartstatus(cstartstatus);
		Userinformation ccreateid = new Userinformation();
		ccreateid.setUserid(SessionUser.userid);
		paramData.setCcreateid(ccreateid);
		paramData.setCactpeonum(0);
		int affectRow = a0401Dao.insertData(paramData);
		if (affectRow > 0) {
			dataMap.put("success", "A0401_SUCC_01");
		} else {
			dataMap.put("error", "A0401_ERR_01");
		}
		return dataMap;
	}

}
