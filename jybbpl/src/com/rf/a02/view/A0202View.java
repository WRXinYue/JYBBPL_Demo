package com.rf.a02.view;

import java.util.Map;

import com.rf.a02.service.A0202Service;
import com.rf.a02.service.imp.A0202ServiceImp;
import com.rf.common.model.Project;
import com.rf.common.utils.CommonUtils;
import com.rf.common.view.CommonView;

public class A0202View extends CommonView {
	A0202Service a0202Service;
	public A0202View() {
		a0202Service = new A0202ServiceImp();
	}
	@Override
	protected void menu() {
		System.out.println("请输入修改项目的编号");
		int paramPid = sc.nextInt();
		Map<String,Object> dataMap1 = a0202Service.selectData(paramPid);
		Project paramData = null;
		if (dataMap1.containsKey("data")) {
			paramData = (Project)dataMap1.get("data");
			showData(paramData);
		} else {
			CommonUtils.printErrorMessage(dataMap1.get("error").toString());
			new A02View().menu();
		}
		System.out.println("请输入项目名");
		paramData.setPname(sc.next());
		Map<String,String> dataMap2 = a0202Service.updateData(paramData);
		if (dataMap2.containsKey("success")) {
			CommonUtils.printSuccessMessage(dataMap2.get("success"));
		} else {
			CommonUtils.printErrorMessage(dataMap2.get("error"));
		}
		new A02View().menu();
	}
	public void showData(Project data) {
		System.out.println("项目编号:" + data.getPid()
					+ "\t项目名:" + data.getPname());
	}
}
