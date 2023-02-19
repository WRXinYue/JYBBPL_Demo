package com.rf.a05.view;

import com.rf.common.utils.CommonUtils;
import com.rf.common.view.CommonView;

public class A05View extends CommonView {

	@Override
	public void menu() {
		System.out.println("1.增加用户  2.修改用户  3.查询用户  4.删除用户  5.封冻管理  6.用户授权  7.注销用户  8.初始化密码  9.返回");
		switch (sc.next()) {
		case "1":
			new A0501View().menu();
			break;
		case "2":
			new A0502View().menu();
			break;
		case "3":
			new A0503View().menu();
			break;
		case "4":
			new A0504View().menu();
			break;
		case "5":
			new A0505View().menu();
			break;
		case "6":
			new A0506View().menu();
			break;
		case "7":
			new A0507View().menu();
			break;
		case "8":
			new A0508View().menu();
			break;
		case "9":
			break;
		default:
			CommonUtils.printErrorMessage("COMMON_SUCC_03");
			break;
		}
	}
}
