package com.rf.a03.view;

import com.rf.a03.service.A0304Service;
import com.rf.a03.service.Imp.A0304ServiceImp;
import com.rf.common.model.Course;
import com.rf.common.model.Project;
import com.rf.common.utils.CommonUtils;
import com.rf.common.view.CommonView;

import java.util.List;
import java.util.Map;

public class A0304View extends CommonView {
    A0304Service a0304Service;

    public A0304View() {
        a0304Service = new A0304ServiceImp();
    }

    @Override
    protected void menu() {
        System.out.println("1.id查询  2.姓名查询  3.性别查询  4.全部查询  5.返回");
        int opId = sc.nextInt();
        if (1 == opId) {
            ById();
        } else if (2 == opId) {
            ByName();
        } else if (3 == opId) {
            ByAge();
        } else if (4 == opId) {
            ByAll();
        } else if (5 == opId) {
            new A03View().menu();
        } else {
            CommonUtils.printErrorMessage("A0304_ERR_01");
        }
        menu();
    }

    public void ByAll() {
        Map<String, Object> dataMap1 = a0304Service.selectByAll();
        if (dataMap1.containsKey("data")) {
            showData((List<Course>) dataMap1.get("data"));
        } else {
            CommonUtils.printErrorMessage(dataMap1.get("error").toString());
        }
    }
    public void ById() {
        System.out.println("请输入教练编号");
        int paramIdt = sc.nextInt();
        Map<String, Object> dataMap1 = a0304Service.selectById(paramIdt);
        if (dataMap1.containsKey("data")) {
            showData((List<Course>) dataMap1.get("data"));
        } else {
            CommonUtils.printErrorMessage(dataMap1.get("error").toString());
        }
    }
    public void ByName() {
        System.out.println("请输入教练的名字");
        String paramName = sc.next();
        Map<String, Object> dataMap1 = a0304Service.selectByName(paramName);
        if (dataMap1.containsKey("data")) {
            showData((List<Course>) dataMap1.get("data"));
        } else {
            CommonUtils.printErrorMessage(dataMap1.get("error").toString());
        }
    }
    public void ByAge() {
        System.out.println("请输入教练的性别");
        String paramAge = sc.next();
        Map<String, Object> dataMap1 = a0304Service.selectByAge(paramAge);
        if (dataMap1.containsKey("data")) {
            showData((List<Course>) dataMap1.get("data"));
        } else {
            CommonUtils.printErrorMessage(dataMap1.get("error").toString());
        }
    }

    private void showData(List<Course> data) {
        for (int i = 0; i < data.size(); i++) {
            Course data1 = data.get(i);
            System.out.println("教练编号:" + data1.getUseridt().getUserid() +
                    "\t姓名:" + data1.getUseridt().getUsername() +
                    "\t性别" + data1.getUseridt().getUsersex().getSparname() +
                    "\t电话" + data1.getUseridt().getUserphone() +
                    "\t课程编号" + data1.getCid() +
                    "\t课程名" + data1.getCname() +
                    "\t\t参加人数" + data1.getCpeonum());
        }
    }

    public static void main(String[] args) {
        //new A0304View().menu();
        int[] arr = {2,4,5,3,1};
        //冒泡排序
        //第一轮:结束后,最大的在右面
        for (int i = 0; i < arr.length - 1; i++) {
            //i 依次表示数组中的每一个索引
            for (int j = 0; j < arr.length -1 - i; j++) {
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
