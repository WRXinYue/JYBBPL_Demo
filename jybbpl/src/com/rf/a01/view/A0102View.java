package com.rf.a01.view;

import java.util.Map;

import com.rf.a01.service.A0102Service;
import com.rf.a01.service.imp.A0102ServiceImp;
import com.rf.common.utils.CommonUtils;
import com.rf.common.view.CommonView;

public class A0102View extends CommonView {
	A0102Service a0102Service;

	public A0102View() {
		a0102Service = new A0102ServiceImp();
	}

	@Override
	public void menu() {
		System.out.println("1.身高 2.体重");
		int opId = sc.nextInt();
		if (1 == opId) {
			upDateHeight();
		} else if (2 == opId) {
			upDateWeight();
		} else {
			CommonUtils.printErrorMessage("COMMON_ERR_03");
		}
	}

	public void upDateHeight() {
		System.out.println("请输入您修改后的身高");
		float height = sc.nextFloat();
		Map<String, Object> dataMap = a0102Service.upDateHeight(height);
		if (dataMap.containsKey("error")) {
			CommonUtils.printErrorMessage(dataMap.get("error").toString());
		} else {
			CommonUtils.printSuccessMessage(dataMap.get("success").toString());
		}

	}

	public void upDateWeight() {
		System.out.println("请输入您修改后的体重");
		float weight = sc.nextFloat();
		Map<String, Object> dataMap = a0102Service.upDateHeight(weight);
		if (dataMap.containsKey("error")) {
			CommonUtils.printErrorMessage(dataMap.get("error").toString());
		} else {
			CommonUtils.printSuccessMessage(dataMap.get("success").toString());
		}
	}
}
