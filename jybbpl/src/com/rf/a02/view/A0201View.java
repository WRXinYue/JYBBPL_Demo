package com.rf.a02.view;

import java.util.Map;

import com.rf.a02.service.A0201Service;
import com.rf.a02.service.imp.A0201ServiceImp;
import com.rf.common.utils.CommonUtils;
import com.rf.common.view.CommonView;

public class A0201View extends CommonView {
	A0201Service a0201Service;
	public A0201View() {
		a0201Service = new A0201ServiceImp();
	}
	@Override
	protected void menu() {
		System.out.println("请输入项目名");
		String paramPname = sc.next();
		Map<String,String> dataMap1 = a0201Service.insertData(paramPname);
		if (dataMap1.containsKey("success")) {
			CommonUtils.printSuccessMessage(dataMap1.get("success"));
		} else {
			CommonUtils.printErrorMessage(dataMap1.get("error"));
		}
		new A02View().menu();
	}
}
