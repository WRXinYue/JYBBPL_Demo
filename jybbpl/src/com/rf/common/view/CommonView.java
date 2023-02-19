package com.rf.common.view;

import java.util.Map;
import java.util.Scanner;

import com.rf.common.service.CommonService;
import com.rf.common.service.imp.CommonServiceImp;
import com.rf.common.utils.CommonUtils;

public abstract class CommonView {
	protected Scanner sc;
	private CommonService commonService;
	protected abstract void menu();
	public CommonView() {
		sc = new Scanner(System.in);
		commonService = new CommonServiceImp();
	}
	protected void cancleUser() {
		System.out.println("是否注销该用户?(y/n)");
		String strOp = sc.next();
		if ("y".equalsIgnoreCase(strOp)) {
			Map<String,String> dataMap1 = commonService.cancleUser();
			if (dataMap1.containsKey("success")) {
				CommonUtils.printSuccessMessage(dataMap1.get("success"));
				new IndexView().menu();
			} else {
				CommonUtils.printErrorMessage(dataMap1.get("success"));
			}
		}
	}
	protected void exitSystem() {
		System.out.println("是否退出?(y/n)");
		String strOp = sc.next();
		if ("y".equalsIgnoreCase(strOp)) {
			Map<String,String> dataMap1 = commonService.exitSystem();
			if (dataMap1.containsKey("success")) {
				CommonUtils.printSuccessMessage(dataMap1.get("success"));
				System.exit(0);
			} else {
				CommonUtils.printErrorMessage(dataMap1.get("success"));
			}
		}
	}
}
