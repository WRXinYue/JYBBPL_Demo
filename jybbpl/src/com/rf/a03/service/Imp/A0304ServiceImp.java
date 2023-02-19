package com.rf.a03.service.Imp;

import com.rf.a03.dao.A0304Dao;
import com.rf.a03.dao.Imp.A0304DaoImp;
import com.rf.a03.service.A0304Service;
import com.rf.common.model.Course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A0304ServiceImp implements A0304Service {
    A0304Dao a0304Dao;

    public A0304ServiceImp() {
        a0304Dao = new A0304DaoImp();
    }


    @Override
    public Map<String , Object> selectByAll() {
    Map<String , Object > dataMap = new HashMap<>();
        List<Course> dataList = a0304Dao.selectByAll();
        if (dataList.size() > 0) {
            dataMap.put("data", dataList);
        } else {
            dataMap.put("error", "A0304_ERR_06");
        }
        return dataMap;
    }

    @Override
    public Map<String, Object> selectById(Integer paramIdt) {
        Map<String , Object > dataMap = new HashMap<>();
        List<Course> dataList = a0304Dao.selectById(paramIdt);
        if (dataList.size() > 0) {
            dataMap.put("data", dataList);
        } else {
            dataMap.put("error", "A0304_ERR_02");
        }
        return dataMap;
    }

    @Override
    public Map<String, Object> selectByName(String paramName) {
         Map<String , Object > dataMap = new HashMap<>();
        List<Course> dataList = a0304Dao.selectByName(paramName);
        if (dataList.size() > 0) {
            dataMap.put("data", dataList);
        } else {
            dataMap.put("error", "A0304_ERR_03");
        }
        return dataMap;
    }

    @Override
    public Map<String, Object> selectByAge(String paramAge) {
        Map<String , Object > dataMap = new HashMap<>();
        List<Course> dataList = a0304Dao.selectByAge(paramAge);
        if (dataList.size() > 0) {
            dataMap.put("data", dataList);
        } else {
            dataMap.put("error", "A0304_ERR_04");
        }
        return dataMap;
    }
}
