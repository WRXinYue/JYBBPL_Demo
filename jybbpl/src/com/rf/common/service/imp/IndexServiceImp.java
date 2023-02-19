package com.rf.common.service.imp;

import java.util.HashMap;
import java.util.Map;

import com.rf.common.dao.IndexDao;
import com.rf.common.dao.imp.IndexDaoImp;
import com.rf.common.model.Subparameter;
import com.rf.common.model.Userlogin;
import com.rf.common.service.IndexService;
import com.rf.common.session.SessionUser;
import com.rf.common.utils.CommonUtils;

public class IndexServiceImp implements IndexService {
	IndexDao indexDao;
	public IndexServiceImp() {
		indexDao = new IndexDaoImp();
	}
	@Override
	public Map<String, Object> checkLogin(String paramUlphone, String paramPassword) {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		Userlogin paramUserlogin = new Userlogin();
		paramUserlogin.setUlphone(paramUlphone);
		paramUserlogin.setUlpassword(CommonUtils.encryption(paramPassword));
		Subparameter paramUlstatus = new Subparameter();
		paramUlstatus.setSparid(0);
		paramUserlogin.setUlstatus(paramUlstatus);
		Subparameter ullosure = new Subparameter();
		ullosure.setSparid(0);
		paramUserlogin.setUllosure(ullosure);
		Userlogin data = indexDao.checkLogin(paramUserlogin);
		if (data == null) {
			dataMap.put("error","INDEX_ERR_01");
			return dataMap;
		}
		data.getUlstatus().setSparid(1);
		int affectRow = indexDao.updateUlstatus(data);
		if (affectRow > 0) {
			SessionUser.ulid = data.getUlid();
			SessionUser.ulphone = data.getUlphone();
			SessionUser.ulstatus = data.getUlstatus();
			SessionUser.ullosure = data.getUllosure();
			SessionUser.ulpowerid = data.getUlpowerid();
			SessionUser.ulbalance = data.getUlbalance();
			SessionUser.userid = data.getUserid().getUserid();
			SessionUser.username = data.getUserid().getUsername();
			SessionUser.userphone = data.getUserid().getUserphone();
			SessionUser.usersex = data.getUserid().getUsersex();
			SessionUser.userheight = data.getUserid().getUserheight();
			SessionUser.userweight = data.getUserid().getUserweight();
			dataMap.put("data",data);
			dataMap.put("success", "INDEX_SUCC_01");
		} else {
			dataMap.put("error", "INDEX_ERR_01");
		}
		return dataMap;
	}

}
