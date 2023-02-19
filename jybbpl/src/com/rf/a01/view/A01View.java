package com.rf.a01.view;

import com.rf.common.utils.CommonUtils;
import com.rf.common.view.CommonView;

public class A01View extends CommonView {

	@Override
	public void menu() {
		System.out.println("1.查看信息 2.修改信息3.密码修改");
		int opId = sc.nextInt();
		if (1 == opId) {
			new A0101View().menu();
		} else if (2 == opId) {
			new A0102View().menu();
		} else if (3 == opId) {
			new A0103View().menu();
		} else {
			CommonUtils.printErrorMessage("COMMON_ERR_03");
		}

	}

}
