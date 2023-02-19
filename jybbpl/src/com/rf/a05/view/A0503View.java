package com.rf.a05.view;

import java.util.List;
import java.util.Map;

import com.rf.a05.service.A0503Service;
import com.rf.a05.service.imp.A0503ServiceImp;
import com.rf.common.model.Userlogin;
import com.rf.common.utils.CommonUtils;
import com.rf.common.view.CommonView;

public class A0503View extends CommonView{
	A0503Service a0503Service;
	public A0503View() {
		a0503Service = new A0503ServiceImp();
	}
	@Override
	protected void menu() {
		while (true) {
			System.out.println("1.编号查询  2.用户名查询  3.电话查询  4.展示全部  5.返回");
			switch (sc.next()) {
			case "1":
				selectById();
				break;
			case "2":
				selectByName();
				break;
			case "3":
				selectByPhone();
				break;
			case "4":
				selectByAll();
				break;
			case "5":
				return;
			default :
				break;
			}
		}
	}
	@SuppressWarnings("unchecked")
	private void selectById() {
		System.out.println("请输入用户编号：");
		int param = sc.nextInt();
		Map<String, Object> dataMap = a0503Service.selectByid(param);
		if (dataMap.containsKey("data")) {
			showData((List<Userlogin>)dataMap.get("data"));
		} else {
			CommonUtils.printErrorMessage(dataMap.get("error").toString());
		}
	}
	@SuppressWarnings("unchecked")
	private void selectByName() {
		System.out.println("请输入用户名：");
		String param = sc.next();
		Map<String, Object> dataMap = a0503Service.selectByName(param);
		if (dataMap.containsKey("data")) {
			showData((List<Userlogin>)dataMap.get("data"));
		} else {
			CommonUtils.printErrorMessage(dataMap.get("error").toString());
		}
	}
	@SuppressWarnings("unchecked")
	private void selectByPhone() {
		System.out.println("请输入电话：");
		String param = sc.next();
		Map<String, Object> dataMap = a0503Service.selectByPhone(param);
		if (dataMap.containsKey("data")) {
			showData((List<Userlogin>)dataMap.get("data"));
		} else {
			CommonUtils.printErrorMessage(dataMap.get("error").toString());
		}
	}
	@SuppressWarnings("unchecked")
	private void selectByAll() {
		Map<String, Object> dataMap = a0503Service.selectByAll();
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
					+ "用户电话：" + data.getUlphone() + "\t"
					+ "用户密码：" + data.getUlpassword() + "\t"
					+ "用户权限：" + data.getUlpowerid().getPurname() + "\t"
					+ "用户在线状态：" + data.getUlstatus().getSparname() + "\t"
					+ "用户封停状态：" + data.getUllosure().getSparname()
					);
		}
	}
}
