package com.rf.a04.view;

import java.util.Map;

import com.rf.a04.service.A0401Service;
import com.rf.a04.service.imp.A0401ServiceImp;
import com.rf.common.model.Course;
import com.rf.common.model.Project;
import com.rf.common.model.Userinformation;
import com.rf.common.utils.CommonUtils;
import com.rf.common.view.CommonView;

public class A0401View extends CommonView {
	A0401Service a0401Service;
	public A0401View() {
		a0401Service = new A0401ServiceImp();
	}
	@Override
	protected void menu() {
		Course paramData = new Course();
		System.out.println("请输入课程名");
		paramData.setCname(sc.next());
		CommonUtils.printProject();
		System.out.println("请输入项目编号");
		Project pid = new Project();
		pid.setPid(sc.nextInt());
		paramData.setPid(pid);
		CommonUtils.printCoach();
		System.out.println("请输入教练编号");
		Userinformation useridt = new Userinformation();
		useridt.setUserid(sc.nextInt());
		paramData.setUseridt(useridt);
		System.out.println("请输入开课时间(yyyy-MM-dd hh:mm)");
		paramData.setCstarttime(CommonUtils.strToDate(sc.next(),1));
		System.out.println("请输入上课时间");
		paramData.setCattendtime(CommonUtils.strToDate(sc.next(), 2));
		System.out.println("请输入结束时间");
		paramData.setCendtime(CommonUtils.strToDate(sc.next(), 2));
		System.out.println("请输入课时");
		paramData.setClesson(sc.nextInt());
		System.out.println("请输入课程描述");
		paramData.setCdescribe(sc.next());
		System.out.println("请输入开课人数");
		paramData.setCpeonum(sc.nextInt());
		System.out.println("请输入预约课程时间(yyyy-MM-dd hh:mm)");
		paramData.setCreservetime(CommonUtils.strToDate(sc.next(),1));
		Map<String,String> dataMap1 = a0401Service.insertData(paramData);
		if (dataMap1.containsKey("success")) {
			CommonUtils.printSuccessMessage(dataMap1.get("success"));
		} else {
			CommonUtils.printErrorMessage(dataMap1.get("error"));
		}
		new A04View().menu();
	}
}
