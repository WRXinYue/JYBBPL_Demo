package com.rf.a03.view;

import com.rf.common.utils.CommonUtils;
import com.rf.common.view.CommonView;

public class A03View extends CommonView {

    @Override
    public void menu() {
        System.out.println("1.教练授权  2.教练解除  3.修改教练  4.查询教练  5.签到查询  6.学员评价  7.返回");
        int opId = sc.nextInt();
        if (1 == opId) {
        } else if (2 == opId) {
        } else if (3 == opId) {
        } else if (4 == opId) {
            new A0304View().menu();
        } else if (5 == opId) {
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
