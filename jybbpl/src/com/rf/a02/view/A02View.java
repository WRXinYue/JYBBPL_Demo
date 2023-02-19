package com.rf.a02.view;

import com.rf.a00.view.A00View;
import com.rf.common.utils.CommonUtils;
import com.rf.common.view.CommonView;

public class A02View extends CommonView {
	public A02View() {
	}
	@Override
	public void menu() {
		System.out.println("1.新增项目  2.修改项目  3.查询项目  4.删除项目  5.返回");
		int opId =  sc.nextInt();
		if (1 == opId) {
			new A0201View().menu();
		} else if (2 == opId) {
			new A0202View().menu();
		} else if (3 == opId) {
			new A0203View().menu();
		} else if (4 == opId) {
			new A0204View().menu();
		} else if (5 == opId) {
			new A00View().menu();
		} else {
			CommonUtils.printErrorMessage("COMMON_ERR_03");
		}
		menu();
	}
}
