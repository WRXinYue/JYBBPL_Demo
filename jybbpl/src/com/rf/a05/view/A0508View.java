package com.rf.a05.view;

import java.util.Map;

import com.rf.a05.service.A0508Service;
import com.rf.a05.service.imp.A0508ServiceImp;
import com.rf.common.model.Userlogin;
import com.rf.common.utils.CommonUtils;
import com.rf.common.view.CommonView;

public class A0508View extends CommonView{
	A0508Service a0508Service;
	public A0508View() {
		a0508Service = new A0508ServiceImp();
	}
	@Override
	protected void menu() {
		System.out.println("输入账户编号：");
		int inputId = sc.nextInt();
		Map<String, Object> dataMap = a0508Service.selectData(inputId);
		Userlogin paramData = null;
		if (dataMap.containsKey("data")) {
			paramData = (Userlogin) dataMap.get("data");
			showData(paramData);
		} else {
			CommonUtils.printErrorMessage(dataMap.get("error").toString());
		}
		System.out.println("是否进行密码初始化(Y/N)");
		String strOp = sc.next();
		if ("y".equalsIgnoreCase(strOp)) {
			Map<String, String> dataMap2 = a0508Service.updateData(inputId);
			if (dataMap2.containsKey("success")) {
				CommonUtils.printSuccessMessage(dataMap2.get("success"));
			} else {
				CommonUtils.printErrorMessage(dataMap2.get("error"));
			}
		} else if ("n".equalsIgnoreCase(strOp)) {
			System.out.println("取消成功");
		}
		new A05View().menu();
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
