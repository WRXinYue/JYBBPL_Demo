package com.rf.a04.view;

import com.rf.a00.view.A00View;
import com.rf.common.utils.CommonUtils;
import com.rf.common.view.CommonView;

public class A04View extends CommonView {
	public A04View() {
	}
	@Override
	public void menu() {
		System.out.println("1.增加课程  2.修改课程  3.查询课程  4.删除课程  5.课程签到  6.返回");
		int opId =  sc.nextInt();
		if (1 == opId) {
			new A0401View().menu();
		} else if (2 == opId) {
			new A0202View().menu();
		} else if (3 == opId) {
			new A0203View().menu();
		} else if (4 == opId) {
			new A0204View().menu();
		} else if (5 == opId) {
			new A00View().menu();
		} else if (6 == opId) {
			new A00View().menu();
		} else {
			CommonUtils.printErrorMessage("COMMON_ERR_03");
		}
		menu();
	}
}
