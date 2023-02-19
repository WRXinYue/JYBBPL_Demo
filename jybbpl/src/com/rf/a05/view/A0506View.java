package com.rf.a05.view;

import java.util.Map;

import com.rf.a05.service.A0506Service;
import com.rf.a05.service.imp.A0506ServiceImp;
import com.rf.common.model.Userlogin;
import com.rf.common.utils.CommonUtils;
import com.rf.common.view.CommonView;

public class A0506View extends CommonView{
	A0506Service a0506Service;
	public A0506View() {
		a0506Service = new A0506ServiceImp();
	}
	@Override
	protected void menu() {
		while (true) {
			System.out.println("1.管理员授权  2.教练授权  3.vip授权  4重置普通用户  5.返回");
			int number = sc.nextInt();
			if (number >= 1 && number <= 4) {
				upDateData(number);
			} else if (number == 5) {
				return;
			} else {
				System.out.println("请输入正确选项");
			}
		}
	}
	
	private void upDateData(int parameter) {
		System.out.println("请输入授权用户编号：");
		int inputId = sc.nextInt();
		Map<String, Object> dataMap = a0506Service.selectData(inputId);
		Userlogin paramData = null;
		if (dataMap.containsKey("data")) {
			paramData = (Userlogin) dataMap.get("data");
			showData(paramData);
		} else {
			CommonUtils.printErrorMessage(dataMap.get("error").toString());
		}
		System.out.println("是否确认授权(Y/N)");
		String strOp = sc.next();
		if ("y".equalsIgnoreCase(strOp)) {
			Map<String, String> dataMap2 = a0506Service.updateData(inputId, parameter);
			if (dataMap2.containsKey("success")) {
				CommonUtils.printSuccessMessage(dataMap2.get("success"));
			} else {
				CommonUtils.printErrorMessage(dataMap2.get("error"));
			}
		} else if ("n".equalsIgnoreCase(strOp)) {
			System.out.println("取消成功");
		}
	}
	
	private void showData(Userlogin data) {
		System.out.println("账号信息如下：");
		System.out.println(
				  "用户编号：" + data.getUlid() + "\t"
				+ "用户名：" + data.getUserid().getUsername() + "\t"
				+ "用户电话：" + data.getUlphone() + "\t"
				+ "用户权限：" + data.getUlpowerid().getPurname() + "\t"
				+ "用户在线状态：" + data.getUlstatus().getSparname() + "\t"
				+ "用户封停状态：" + data.getUllosure().getSparname()
				);
	}
}
