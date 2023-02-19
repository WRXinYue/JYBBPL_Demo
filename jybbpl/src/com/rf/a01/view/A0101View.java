package com.rf.a01.view;

import com.rf.common.session.SessionUser;
import com.rf.common.view.CommonView;

public class A0101View extends CommonView {
	@Override
	public void menu() {
		System.out.println("当前账号基本信息如下：");
		System.out.println("用户编号为： " + SessionUser.userid + "  用户账号：" + SessionUser.ulphone + "   用户名： "
				+ SessionUser.username + "  用户密码：" + SessionUser.ulpassword + "    用户权限" + SessionUser.ullosure
				+ "用户状态：" + SessionUser.ulstatus);
	}
}
