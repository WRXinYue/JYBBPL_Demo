package com.rf.common.service.imp;

import java.util.HashMap;
import java.util.Map;

import com.rf.common.dao.CommonDao;
import com.rf.common.dao.imp.CommonDaoImp;
import com.rf.common.model.Subparameter;
import com.rf.common.service.CommonService;
import com.rf.common.session.SessionUser;

public class CommonServiceImp implements CommonService {
	CommonDao commonDao;
	public CommonServiceImp() {
		commonDao = new CommonDaoImp();
	}
	@Override
	public Map<String, String> cancleUser() {
		Map<String, String> dataMap = new HashMap<String,String>();
		Subparameter paramUlstatus = new Subparameter();
		paramUlstatus.setSparid(0);
		int affectRow = commonDao.cancleUser(SessionUser.ulid, paramUlstatus);
		if (affectRow > 0) {
			SessionUser.ulid = null;
			SessionUser.ulphone = null;
			SessionUser.ulpassword = null;
			SessionUser.ulstatus = null;
			SessionUser.ullosure = null;
			SessionUser.ulpowerid = null;
			SessionUser.ulbalance = null;
			SessionUser.userid = null;
			SessionUser.username = null;
			SessionUser.userphone = null;
			SessionUser.usersex = null;
			SessionUser.userheight = null;
			SessionUser.userweight = null;
			dataMap.put("success", "COMMON_SUCC_01");
		} else {
			dataMap.put("error", "COMMON_ERR_01");
		}
		return dataMap;
	}

	@Override
	public Map<String, String> exitSystem() {
		Map<String, String> dataMap = new HashMap<String,String>();
		Subparameter paramUlstatus = new Subparameter();
		paramUlstatus.setSparid(0);
		int affectRow = commonDao.exitSystem(SessionUser.ulid, paramUlstatus);
		if (affectRow > 0) {
			dataMap.put("success", "COMMON_SUCC_02");
		} else {
			dataMap.put("error", "COMMON_ERR_02");
		}
		return dataMap;
	}

}
