package com.rf.a05.view;

import java.util.Map;

import com.rf.a05.service.A0501Service;
import com.rf.a05.service.imp.A0501ServiceImp;
import com.rf.common.model.Userinformation;
import com.rf.common.model.Userlogin;
import com.rf.common.utils.CommonUtils;
import com.rf.common.view.CommonView;

public class A0501View extends CommonView{
	A0501Service a0501Service;
	public A0501View() {
		a0501Service = new A0501ServiceImp();
	}
	@Override
	protected void menu() {
		Userlogin userlogin = new Userlogin();
		Userinformation userinformation = new Userinformation();
		System.out.println("请输入注册手机号:");
		String userPhone = sc.next();
		System.out.println("请输入用户名:");
		String userName = sc.next();
		System.out.println("请输入用户密码:");
		String userPassWord = sc.next();
		System.out.println("是否进行添加(Y/N)");
		String strOp = sc.next();
		if ("y".equalsIgnoreCase(strOp)) {
			userlogin.setUlphone(userPhone);
			userinformation.setUserphone(userPhone);
			userinformation.setUsername(userName);
			userlogin.setUlpassword(CommonUtils.encryption(userPassWord));
		} else if ("n".equalsIgnoreCase(strOp)) {
			System.out.println("取消成功");
		}
		Map<String, String> dataMap = a0501Service.insertData(userlogin, userinformation);
		if (dataMap.containsKey("success")) {
			CommonUtils.printSuccessMessage(dataMap.get("success"));
		} else {
			CommonUtils.printErrorMessage(dataMap.get("success"));
		}
		new A05View().menu();
	}
}
