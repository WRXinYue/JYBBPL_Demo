package com.rf.a00.view;

import com.rf.a01.view.A01View;
import com.rf.a02.view.A02View;
import com.rf.a03.view.A03View;
import com.rf.a04.view.A04View;
import com.rf.a05.view.A05View;
import com.rf.common.utils.CommonUtils;
import com.rf.common.view.CommonView;

public class A00View extends CommonView {
	public A00View() {
	}
	@Override
	public void menu() {
		System.out.println("1.基本信息  2.项目管理  3.教练管理  4.课程管理  5.用户管理  6.用户充值  7.用户消费  8.注销  9.退出");
		int opId =  sc.nextInt();
		if (1 == opId) {
			new A01View().menu();
		} else if (2 == opId) {
			new A02View().menu();
		} else if (3 == opId) {
			new A03View().menu();
		} else if (4 == opId) {
			new A04View().menu();
		} else if (5 == opId) {
			new A05View().menu();
		} else if (6 == opId) {
		} else if (7 == opId) {
		} else if (8 == opId) {
			cancleUser();
		} else if (9 == opId) {
			exitSystem();
		} else {
			CommonUtils.printErrorMessage("COMMON_ERR_03");
		}
		menu();
	}
}
