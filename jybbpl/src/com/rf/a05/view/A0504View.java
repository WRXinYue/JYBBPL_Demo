package com.rf.a05.view;

import java.util.Map;

import com.rf.a05.service.A0504Service;
import com.rf.a05.service.imp.A0504ServiceImp;
import com.rf.common.model.Userlogin;
import com.rf.common.utils.CommonUtils;
import com.rf.common.view.CommonView;

public class A0504View extends CommonView{
	A0504Service a0504Service;
	public A0504View() {
		a0504Service = new A0504ServiceImp();
	}
	@Override
	protected void menu() {
		System.out.println("请输入删除的账号编号：");
		int paramPid = sc.nextInt();
		Map<String, Object> dataMap = a0504Service.selectData(paramPid);
		if (dataMap.containsKey("data")) {
			showData((Userlogin)dataMap.get("data"));
		} else {
			CommonUtils.printErrorMessage(dataMap.get("error").toString());
			new A0504View().menu();
		}
		System.out.println("是否进行删除(Y/N)");
		String strOp = sc.next();
		if ("y".equalsIgnoreCase(strOp)) {
			Map<String, String> dataMap2 = a0504Service.deleteData(paramPid);
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
				+ "用户密码：" + data.getUlpassword() + "\t"
				+ "用户权限：" + data.getUlpowerid().getPurname() + "\t"
				+ "用户在线状态：" + data.getUlstatus().getSparname() + "\t"
				+ "用户封停状态：" + data.getUllosure().getSparname()
				);
	}
}
