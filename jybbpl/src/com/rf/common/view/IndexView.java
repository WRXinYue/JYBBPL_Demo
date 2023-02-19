package com.rf.common.view;

import java.util.Map;

import com.rf.a00.view.A00View;
import com.rf.common.model.Userlogin;
import com.rf.common.service.IndexService;
import com.rf.common.service.imp.IndexServiceImp;
import com.rf.common.utils.CommonUtils;

public class IndexView extends CommonView {
	//索引视图
	IndexService indexService;
	public IndexView() {
		indexService = new IndexServiceImp();
	}
	@Override
	public void menu() {
		System.out.println("1.登录 2.退出");
		int opId =  sc.nextInt();
		if (1 == opId) {
			checkLogin();
		} else if (2 == opId) {
			exitSystem();
		} else {
			CommonUtils.printErrorMessage("COMMON_ERR_03");
		}
		menu();
	}
	public void exitSystem() {
		CommonUtils.printSuccessMessage("INDEX_SUCC_02");
		System.exit(0);
	}
	/**
	 * 登录检测
	 */
	public void checkLogin() {
		System.out.println("请输入联系电话");
		String paramUlphone = sc.next();
		System.out.println("请输入密码");
		String paramPassword = sc.next();
		//在索引视图执行Map值密码检查
		Map<String,Object> dataMap1 = indexService.checkLogin(paramUlphone, paramPassword);
		//containsKey Map值查询返回Boolean，success值是什么？
		if (dataMap1.containsKey("success")) {
			//在公共工具类，打印输出消息
			CommonUtils.printSuccessMessage(dataMap1.get("success").toString());
			selectView((Userlogin)dataMap1.get("data"));
		} else {
			CommonUtils.printErrorMessage(dataMap1.get("error").toString());
		}
	}
	public void selectView(Userlogin data) {
		System.out.println("当前用户为:" + data.getUserid().getUsername()
				+ "\t当前权限为:" + data.getUlpowerid().getPurname());
		if (1 == data.getUlpowerid().getPurid()) {
			new A00View().menu();
		} else if (2 == data.getUlpowerid().getPurid()) {
			
		} else if (3 == data.getUlpowerid().getPurid()) {
			
		} else if (4 == data.getUlpowerid().getPurid()) {
			
		}
	}
}
