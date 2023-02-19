package com.rf.a02.view;

import java.util.Map;

import com.rf.a02.service.A0204Service;
import com.rf.a02.service.imp.A0204ServiceImp;
import com.rf.common.model.Project;
import com.rf.common.utils.CommonUtils;
import com.rf.common.view.CommonView;

public class A0204View extends CommonView {
	A0204Service a0204Service;
	public A0204View() {
		a0204Service = new A0204ServiceImp();
	}
	@Override
	protected void menu() {
		System.out.println("请输入删除项目的编号");
		int paramPid = sc.nextInt();
		Map<String,Object> dataMap1 = a0204Service.selectData(paramPid);
		if (dataMap1.containsKey("data")) {
			showData((Project)dataMap1.get("data"));
		} else {
			CommonUtils.printErrorMessage(dataMap1.get("error").toString());
			new A02View().menu();
		}
		System.out.println("是否删除?(y/n)");
		String strOp = sc.next();
		if ("y".equalsIgnoreCase(strOp)) {
			Map<String,String> dataMap2 = a0204Service.deleteData(paramPid);
			if (dataMap2.containsKey("success")) {
				CommonUtils.printSuccessMessage(dataMap2.get("success"));
			} else {
				CommonUtils.printErrorMessage(dataMap2.get("error"));
			}
		}
		new A02View().menu();
	}
	public void showData(Project data) {
		System.out.println("项目编号:" + data.getPid()
					+ "\t项目名:" + data.getPname());
	}
}
