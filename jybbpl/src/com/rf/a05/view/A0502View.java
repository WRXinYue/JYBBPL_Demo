package com.rf.a05.view;

import java.util.Map;

import com.rf.a05.service.A0502Service;
import com.rf.a05.service.imp.A0502ServiceImp;
import com.rf.common.model.Userlogin;
import com.rf.common.utils.CommonUtils;
import com.rf.common.view.CommonView;

public class A0502View extends CommonView{
	A0502Service a0502Service;
	public A0502View() {
		a0502Service = new A0502ServiceImp();
	}
	@Override
	protected void menu() {
		System.out.println("请输入修改用户的编号:");
		int paramPid = sc.nextInt();
		Map<String, Object> dataMap = a0502Service.selectData(paramPid);
		Userlogin paramData = null;
		if (dataMap.containsKey("data")) {
			paramData = (Userlogin) dataMap.get("data");
			showData(paramData);
		} else {
			CommonUtils.printErrorMessage(dataMap.get("error").toString());
			new A05View().menu();
		}
		subMenu(paramData);
	}
	private void subMenu(Userlogin paramData) {
		System.out.println("1.修改用户名  2.修改用户密码  3.修改用户电话  4.修改用户权限  5.返回");
		int parameter = sc.nextInt();
		switch (parameter) {
		case 1:
			System.out.println("请输入修改用户名：");
			paramData.getUserid().setUsername(sc.next());
			break;
		case 2:
			System.out.println("请输入修改用户密码：");
			paramData.setUlpassword(sc.next());
			break;
		case 3:
			System.out.println("请输入修改用户电话：");
			paramData.setUlphone(sc.next());
			break;
		case 4:
			System.out.println("请输入用户权限：");
			paramData.getUlpowerid().setPurid(sc.nextInt());;
			break;
		case 5:
			return;
		default:
			break;
		}
		System.out.println("是否确认修改(Y/N)");
		String strOp = sc.next();
		if ("y".equalsIgnoreCase(strOp)) {
			Map<String, String> dataMap2 = a0502Service.updateData(paramData, parameter);
			if (dataMap2.containsKey("success")) {
				CommonUtils.printSuccessMessage(dataMap2.get("success"));
			} else {
				CommonUtils.printErrorMessage(dataMap2.get("error"));
			}
			subMenu(paramData);
		} else if ("n".equalsIgnoreCase(strOp)) {
			subMenu(paramData);
			System.out.println("取消成功");
		}
	}
	private void showData(Userlogin paramData) {
		System.out.println("用户名：" + paramData.getUserid().getUsername());
	}
}
