package com.rf.a01.view;

import java.util.Map;

import com.rf.a01.service.A0103Service;
import com.rf.a01.service.imp.A0103ServiceImp;
import com.rf.common.model.Userlogin;
import com.rf.common.utils.CommonUtils;
import com.rf.common.view.CommonView;

public class A0103View extends CommonView {
	A0103Service a0103Service;

	public A0103View() {
		a0103Service = new A0103ServiceImp();
	}

	@Override
	public void menu() {
		Userlogin userPassword = new Userlogin();
		System.out.println("请输入修改后的密码");
		userPassword.setUlpassword(CommonUtils.encryption(sc.next()));
		Map<String, Object> dataMap = a0103Service.upDatePassword(userPassword);
		if (dataMap.containsKey("error")) {
			CommonUtils.printErrorMessage(dataMap.get("error").toString());
		} else {
			CommonUtils.printSuccessMessage(dataMap.get("success").toString());
		}
	}
}
