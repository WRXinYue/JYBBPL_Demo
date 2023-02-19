package com.rf.a05.view;

import java.util.List;
import java.util.Map;

import com.rf.a05.service.A0505Service;
import com.rf.a05.service.imp.A0505ServiceImp;
import com.rf.common.model.Userlogin;
import com.rf.common.utils.CommonUtils;
import com.rf.common.view.CommonView;

public class A0505View extends CommonView{
	A0505Service a0505Service;
	public A0505View() {
		a0505Service = new A0505ServiceImp();
	}
	@Override
	protected void menu() {
		while (true) {
			System.out.println("1.查询冻结用户  2.冻结用户  3.解冻用户  4.返回");
			switch (sc.next()) {
			case "1":
				queryFrozenUser();
				break; 
			case "2":
				freezeUser();
				break;
			case "3":
				unfreezeUser();
				break;
			case "4":
				return;
			}
		}
	}
	private void queryFrozenUser() {
		while (true) {
			System.out.println("1.编号查询  2.查询全部  3.返回");
			switch (sc.next()) {
			case "1":
				selectById();
				break;
			case "2":
				selectByAll();
				break;
			case "3":
				return;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private void selectById() {
		System.out.println("请输入用户编号：");
		int param = sc.nextInt();
		Map<String, Object> dataMap = a0505Service.selectByid(param);
		if (dataMap.containsKey("data")) {
			showData((List<Userlogin>)dataMap.get("data"));
		} else {
			CommonUtils.printErrorMessage(dataMap.get("error").toString());
		}
	}
	@SuppressWarnings("unchecked")
	private void selectByAll() {
		Map<String, Object> dataMap = a0505Service.selectByAll();
		if (dataMap.containsKey("data")) {
			showData((List<Userlogin>)dataMap.get("data"));
		} else {
			CommonUtils.printErrorMessage(dataMap.get("error").toString());
		}
	}
	private void showData(List<Userlogin> dataList) {
		for (int i = 0; i < dataList.size(); i++) {
			Userlogin data = dataList.get(i);
			System.out.println(
					  "用户编号：" + data.getUlid() + "\t"
					+ "用户名：" + data.getUserid().getUsername() + "\t"
					+ "用户权限：" + data.getUlpowerid().getPurname() + "\t"
					+ "用户在线状态：" + data.getUlstatus().getSparname() + "\t"
					+ "用户封停状态：" + data.getUllosure().getSparname()
					);
		}
	}
	private void freezeUser() {
		System.out.println("请输入冻结用户ID:");
		int strId = sc.nextInt();
		System.out.println("是否冻结(y/n):");
		String strOp = sc.next();
		if ("y".equalsIgnoreCase(strOp)) {
			Map<String, String> dataMap = a0505Service.freezeUser(strId);
			if (dataMap.containsKey("success")) {
				CommonUtils.printSuccessMessage(dataMap.get("success"));
			} else {
				CommonUtils.printErrorMessage(dataMap.get("error"));
			}
		} else if ("n".equalsIgnoreCase(strOp)) {
			System.out.println("取消成功");
		}
		System.out.println("冻结成功");		
	}
	private void unfreezeUser() {
		System.out.println("请输入解冻用户ID:");
		int strId = sc.nextInt();
		System.out.println("是否解冻(y/n):");
		String strOp = sc.next();
		if ("y".equalsIgnoreCase(strOp)) {
			Map<String, String> dataMap = a0505Service.unfreezeUser(strId);
			if (dataMap.containsKey("success")) {
				CommonUtils.printSuccessMessage(dataMap.get("success"));
			} else {
				CommonUtils.printErrorMessage(dataMap.get("error"));
			}
		} else if ("n".equalsIgnoreCase(strOp)) {
			System.out.println("取消成功");
		}
		System.out.println("解冻成功");				
	}
}
