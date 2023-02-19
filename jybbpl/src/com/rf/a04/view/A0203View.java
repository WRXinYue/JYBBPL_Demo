package com.rf.a04.view;

import java.util.List;
import java.util.Map;

import com.rf.a02.service.A0203Service;
import com.rf.a02.service.imp.A0203ServiceImp;
import com.rf.common.model.Project;
import com.rf.common.utils.CommonUtils;
import com.rf.common.view.CommonView;

public class A0203View extends CommonView {
	A0203Service a0203Service;
	public A0203View() {
		a0203Service = new A0203ServiceImp();
	}
	@Override
	protected void menu() {
		System.out.println("1.编号  2.名称  3.全部  4.返回");
		int opId =  sc.nextInt();
		if (1 == opId) {
			selectById();
		} else if (2 == opId) {
			selectByName();
		} else if (3 == opId) {
			selectByAll();
		} else if (4 == opId) {
			new A04View().menu();
		} else {
			CommonUtils.printErrorMessage("COMMON_ERR_03");
		}
		menu();
	}
	public void selectById() {
		System.out.println("请输入项目的编号");
		int paramPid = sc.nextInt();
		Map<String,Object> dataMap1 = a0203Service.selectById(paramPid);
		if (dataMap1.containsKey("data")) {
			showData((List<Project>)dataMap1.get("data"));
		} else {
			CommonUtils.printErrorMessage(dataMap1.get("error").toString());
		}
	}
	public void selectByName() {
		System.out.println("请输入项目名称");
		String paramPname = sc.next();
		Map<String,Object> dataMap1 = a0203Service.selectByName(paramPname);
		if (dataMap1.containsKey("data")) {
			showData((List<Project>)dataMap1.get("data"));
		} else {
			CommonUtils.printErrorMessage(dataMap1.get("error").toString());
		}
	}
	public void selectByAll() {
		Map<String,Object> dataMap1 = a0203Service.selectByAll();
		if (dataMap1.containsKey("data")) {
			showData((List<Project>)dataMap1.get("data"));
		} else {
			CommonUtils.printErrorMessage(dataMap1.get("error").toString());
		}
	}
	public void showData(List<Project> dataList) {
		for (int i = 0; i < dataList.size(); i++) {
			Project data = dataList.get(i);
			System.out.println("项目编号:" + data.getPid()
			+ "\t项目名:" + data.getPname());
		}
	}
}
